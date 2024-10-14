package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.requestDTOs.UserRegistrationDTO;
import com.karan.paul.banking.customer.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController  {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        User newUser = userService.registerNewUser(userDTO);
        return ResponseEntity.ok("User registered successfully with ID: " + newUser.getId());
    }
}
