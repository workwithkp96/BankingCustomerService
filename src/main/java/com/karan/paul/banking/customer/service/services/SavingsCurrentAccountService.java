package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.repositories.SavingsCurrentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsCurrentAccountService {
    @Autowired
    private SavingsCurrentAccountRepository savingsCurrentAccountRepository;

    public List<SavingsCurrentAccount> getAccountsByCustomerId(Long customerId) {
        return savingsCurrentAccountRepository.findByCustomer_CustomerId(customerId);
    }
}
