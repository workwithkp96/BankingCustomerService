package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomer_CustomerId(Long customerId);
}
