package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.Authority;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.repositories.AuthorityRepository;
import com.karan.paul.banking.customer.service.repositories.UserRepository;
import com.karan.paul.banking.customer.service.requestDTOs.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationDTO userDTO) {
        // Create a new User entity
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypt password

        // Save user first
        User savedUser = userRepository.save(user);

        // Create Authority for the user with default role "USER"
        Authority authority = new Authority();
        authority.setName("ROLE_USER"); // ROLE_USER is the convention for authorities in Spring Security
        authority.setUser(savedUser);

        // Save Authority
        authorityRepository.save(authority);

        return savedUser;
    }
}
