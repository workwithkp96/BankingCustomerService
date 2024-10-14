package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.Loan;
import com.karan.paul.banking.customer.service.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable Long customerId) {
        List<Loan> loans = loanService.getLoansByCustomerId(customerId);
        return ResponseEntity.ok(loans);
    }
}
