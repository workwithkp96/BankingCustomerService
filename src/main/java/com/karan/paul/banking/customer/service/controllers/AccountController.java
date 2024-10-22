package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.FixedAccount;
import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.services.AccountService;
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
    private AccountService accountService;

    @GetMapping("/{customerId}")
    @PreAuthorize("#customerId == authentication.principal.id")
    public ResponseEntity<List<SavingsCurrentAccount>> getSavingsAndCurrentAccountsByCustomerId(@PathVariable Long customerId) {
        List<SavingsCurrentAccount> accounts = accountService.getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/fixed/{customerId}")
    @PreAuthorize("#customerId == authentication.principal.id")
    public ResponseEntity<List<FixedAccount>> getFixedAccountsByCustomerId(@PathVariable Long customerId){
        List<FixedAccount> accounts = accountService.getFixedAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }
}
