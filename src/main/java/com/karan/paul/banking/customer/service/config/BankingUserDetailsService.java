package com.karan.paul.banking.customer.service.config;

import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.services.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
@Slf4j
public class BankingUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(username);
        List<SimpleGrantedAuthority> authorityList = user.getAuthoritySet().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())).toList();
        return new BankingUserDetails(user.getId(),user.getEmail(),user.getPassword(),authorityList);
    }
}
