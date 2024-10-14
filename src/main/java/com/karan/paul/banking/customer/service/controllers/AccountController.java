package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.services.SavingsCurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<SavingsCurrentAccount>> getAccountsByCustomerId(@PathVariable Long customerId) {
        List<SavingsCurrentAccount> accounts = savingsCurrentAccountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }
}
