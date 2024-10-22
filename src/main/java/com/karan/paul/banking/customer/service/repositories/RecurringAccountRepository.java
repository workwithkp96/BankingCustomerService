package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.RecurringAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecurringAccountRepository extends JpaRepository<RecurringAccount, Long> {
    List<RecurringAccount> findByCustomer_CustomerId(Long customerId);
}
