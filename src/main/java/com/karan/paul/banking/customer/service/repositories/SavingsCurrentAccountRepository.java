package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsCurrentAccountRepository extends JpaRepository<SavingsCurrentAccount, Long> {
    List<SavingsCurrentAccount> findByCustomer_CustomerId(Long customerId);
}
