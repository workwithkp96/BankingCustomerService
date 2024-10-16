package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.Authority;
import com.karan.paul.banking.customer.service.entities.Customer;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.repositories.AuthorityRepository;
import com.karan.paul.banking.customer.service.repositories.CustomerRepository;
import com.karan.paul.banking.customer.service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final AuthorityRepository authorityRepository;

    public Customer registerNewCustomer(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new RuntimeException("User is not registered.");


        User registeredUser = user.get();

        //create new customer
        Customer newCustomer = new Customer();

        newCustomer.setUser(registeredUser);
        newCustomer.setName(registeredUser.getName());
        newCustomer.setEmail(registeredUser.getEmail());

        //save customer
        customerRepository.save(newCustomer);

        Authority authority = new Authority();
        authority.setName("ROLE_CUSTOMER");
        authority.setUser(registeredUser);

        authorityRepository.save(authority);

        return newCustomer;
    }
}
