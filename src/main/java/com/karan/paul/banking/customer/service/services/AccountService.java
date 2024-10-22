package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.FixedAccount;
import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.repositories.FixedAccountRepository;
import com.karan.paul.banking.customer.service.repositories.SavingsCurrentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private SavingsCurrentAccountRepository savingsCurrentAccountRepository;
    @Autowired
    private FixedAccountRepository fixedAccountRepository;

    public List<SavingsCurrentAccount> getAccountsByCustomerId(Long customerId) {
        return savingsCurrentAccountRepository.findByCustomer_CustomerId(customerId);
    }

    public List<FixedAccount> getFixedAccountsByCustomerId(Long customerId){
        return fixedAccountRepository.findByCustomer_CustomerId(customerId);
    }
}
