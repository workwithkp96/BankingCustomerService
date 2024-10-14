package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.Loan;
import com.karan.paul.banking.customer.service.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getLoansByCustomerId(Long customerId) {
        return loanRepository.findByCustomer_CustomerId(customerId);
    }
}
