package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.CreditCard;
import com.karan.paul.banking.customer.service.entities.DebitCard;
import com.karan.paul.banking.customer.service.repositories.CreditCardRepository;
import com.karan.paul.banking.customer.service.repositories.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private DebitCardRepository debitCardRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<DebitCard> getDebitCardsByAccountId(Long accountId) {
        return debitCardRepository.findBySavingsCurrentAccountId(accountId);
    }

    public List<CreditCard> getCreditCardsByCustomerId(Long customerId) {
        return creditCardRepository.findByCustomer_CustomerId(customerId);
    }
}
