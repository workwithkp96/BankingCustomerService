package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
