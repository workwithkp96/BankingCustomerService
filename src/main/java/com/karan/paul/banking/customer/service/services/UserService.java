package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.Authority;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.repositories.AuthorityRepository;
import com.karan.paul.banking.customer.service.repositories.UserRepository;
import com.karan.paul.banking.customer.service.requestDTOs.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public User registerAdmin(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty())
            throw new RuntimeException("User is not registered");

        User registeredUser = user.get();

        // Create Authority for the user with admin role "ADMIN"
        Authority authority = new Authority();
        authority.setName("ROLE_ADMIN");
        authority.setUser(registeredUser);

        authorityRepository.save(authority);

        return registeredUser;
    }

    public User findUserByEmail(String email){

        //FETCH the user through email
        User user = userRepository.findByEmail(email).orElseThrow(()
                -> new UsernameNotFoundException("User not found with username " + email));

        //FETCH the set of authorities associated with the user lazily
        user.setAuthoritySet(new HashSet<>(authorityRepository.findByUserId(user.getId())));

        return user;
    }
}
