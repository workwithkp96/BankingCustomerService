package com.karan.paul.banking.customer.service.services;

import com.karan.paul.banking.customer.service.entities.CreditCard;
import com.karan.paul.banking.customer.service.entities.DebitCard;
import com.karan.paul.banking.customer.service.entities.SavingsCurrentAccount;
import com.karan.paul.banking.customer.service.repositories.CreditCardRepository;
import com.karan.paul.banking.customer.service.repositories.DebitCardRepository;
import com.karan.paul.banking.customer.service.repositories.SavingsCurrentAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private DebitCardRepository debitCardRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private SavingsCurrentAccountRepository savingsCurrentAccountRepository;


    public List<CreditCard> getCreditCardsByCustomerId(Long customerId) {
        return creditCardRepository.findByCustomer_CustomerId(customerId);
    }

    public List<DebitCard> getDebitCardsByCustomerId(Long customerId) {
        List<SavingsCurrentAccount> savingsCurrentAccounts = savingsCurrentAccountRepository.findByCustomer_CustomerId(customerId);
        return debitCardRepository.findBySavingsCurrentAccountsIn(savingsCurrentAccounts);
    }
}
