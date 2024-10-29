package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.DebitCard;
import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {
    List<DebitCard> findBySavingsCurrentAccountsIn(List<SavingsCurrentAccount> savingsCurrentAccountList);
}
