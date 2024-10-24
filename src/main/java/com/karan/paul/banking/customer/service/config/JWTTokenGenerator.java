package com.karan.paul.banking.customer.service.config;

import com.karan.paul.banking.customer.service.constants.ApplicationConstants;
import com.karan.paul.banking.customer.service.entities.User;
import com.karan.paul.banking.customer.service.repositories.UserRepository;
import com.karan.paul.banking.customer.service.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JWTTokenGenerator {
    @Autowired
    private Environment environment;
    public String generateJWTToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String JWTToken="";
        if(null!=authentication){
            String secret = environment.getProperty(ApplicationConstants.JWT_SECRET_KEY,ApplicationConstants.JWT_SECRET_VALUE);
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            BankingUserDetails bankingUserDetails = (BankingUserDetails) authentication.getPrincipal();
            JWTToken = Jwts.builder().issuer("Customer Banking Service").issuedAt(new Date())
                    .subject("Customer Service Token").claim("username",authentication.getName())
                    .claim("userId",bankingUserDetails.getId()).claim("roles",authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.joining(",")))
                    .expiration(new Date(new Date().getTime()+30000000))
                    .signWith(secretKey).compact();
        }
        return JWTToken;
    }
}
