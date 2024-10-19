package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.config.JWTTokenGenerator;
import com.karan.paul.banking.customer.service.constants.ApplicationConstants;
import com.karan.paul.banking.customer.service.entities.Customer;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.requestDTOs.UserLoginDTO;
import com.karan.paul.banking.customer.service.requestDTOs.UserRegistrationDTO;
import com.karan.paul.banking.customer.service.services.CustomerService;
import com.karan.paul.banking.customer.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController  {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    @PostMapping("/register/user")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        User newUser = userService.registerNewUser(userDTO);
        return ResponseEntity.ok("User registered successfully with ID: " + newUser.getId());
    }

    @PostMapping("/register/customer")
    public ResponseEntity<String> registerCustomer(@RequestParam Long userId){
        Customer newCustomer = customerService.registerNewCustomer(userId);
        return ResponseEntity.ok("New Customer registered successfully with ID : " + newCustomer.getCustomerId());
    }

    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestParam Long userId){
        User user = userService.registerAdmin(userId);
        return ResponseEntity.ok("New Admin has been registered successfully with ID : " + user.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO){
        Authentication authenticationResponse = authenticationManager.authenticate(UsernamePasswordAuthenticationToken
                .unauthenticated(userLoginDTO.username(), userLoginDTO.password()));
        String JWTToken = jwtTokenGenerator.generateJWTToken();
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER,JWTToken)
                    .body("User logged in successfully !");
    }
}
