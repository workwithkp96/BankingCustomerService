package com.karan.paul.banking.customer.service.filters;

import com.karan.paul.banking.customer.service.config.BankingUserDetails;
import com.karan.paul.banking.customer.service.constants.ApplicationConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String JWTToken = request.getHeader(ApplicationConstants.JWT_HEADER);
        try{
            Environment environment = getEnvironment();
            String secret = environment.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                    ApplicationConstants.JWT_SECRET_VALUE);
            SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            Claims claims = Jwts.parser().verifyWith(secretKey)
                    .build().parseSignedClaims(JWTToken).getPayload();
            String username = String.valueOf(claims.get("username"));
            String authorities = String.valueOf(claims.get("roles"));
            Long userId = Long.valueOf(String.valueOf(claims.get("userId")));
            Authentication authentication = new UsernamePasswordAuthenticationToken(new BankingUserDetails(userId,username,null,null), null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e){
            throw new BadCredentialsException("Invalid Token Received");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/api/v1/auth/login");
    }
}
