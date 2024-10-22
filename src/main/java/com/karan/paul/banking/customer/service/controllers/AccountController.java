package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.services.SavingsCurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private SavingsCurrentAccountService savingsCurrentAccountService;

    @GetMapping("/{customerId}")
    @PreAuthorize("#customerId == authentication.principal.id")
    public ResponseEntity<List<SavingsCurrentAccount>> getSavingsAndCurrentAccountsByCustomerId(@PathVariable Long customerId) {
        List<SavingsCurrentAccount> accounts = savingsCurrentAccountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }
}
