package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySavingsCurrentAccountId(Long accountId);
}
