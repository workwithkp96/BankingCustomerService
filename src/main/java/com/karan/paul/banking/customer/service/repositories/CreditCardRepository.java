package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByCustomer_CustomerId(Long customerId);
}
