package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.Customer;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.requestDTOs.UserRegistrationDTO;
import com.karan.paul.banking.customer.service.services.CustomerService;
import com.karan.paul.banking.customer.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController  {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

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
}
