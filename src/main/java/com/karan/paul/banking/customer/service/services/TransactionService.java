package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.Transaction;
import com.karan.paul.banking.customer.service.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findBySavingsCurrentAccountId(accountId);
    }
}
