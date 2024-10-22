package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.FixedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixedAccountRepository extends JpaRepository<FixedAccount, Long> {
    List<FixedAccount> findByCustomer_CustomerId(Long customerId);
}
