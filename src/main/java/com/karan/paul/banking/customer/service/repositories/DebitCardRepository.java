package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {
}
