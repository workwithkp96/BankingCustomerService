package com.karan.paul.banking.customer.service.config;

import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
public class BankingUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(()
                -> new UsernameNotFoundException("User not found with username " + username));
        List<SimpleGrantedAuthority> authorityList = user.getAuthoritySet().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())).toList();
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorityList);
    }
}
