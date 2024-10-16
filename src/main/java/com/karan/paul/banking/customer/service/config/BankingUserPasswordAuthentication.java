package com.karan.paul.banking.customer.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BankingUserPasswordAuthentication implements AuthenticationProvider {

    @Autowired
    private BankingUserDetailsService bankingUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        UserDetails userDetails = bankingUserDetailsService.loadUserByUsername(userName);
        if(!passwordEncoder.encode(pwd).matches(userDetails.getPassword()))
            throw new BadCredentialsException("Invalid Credential");

        return new UsernamePasswordAuthenticationToken(userName,pwd,userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
