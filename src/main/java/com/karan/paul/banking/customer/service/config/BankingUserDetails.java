package com.karan.paul.banking.customer.service.config;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class BankingUserDetails implements UserDetails {

    @Getter
    private Long Id;  // Custom field for Id
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public BankingUserDetails(Long Id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
