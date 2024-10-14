package com.karan.paul.banking.customer.service.controllers;

import com.karan.paul.banking.customer.service.entities.CreditCard;
import com.karan.paul.banking.customer.service.entities.DebitCard;
import com.karan.paul.banking.customer.service.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/debit/{accountId}")
    public ResponseEntity<List<DebitCard>> getDebitCardsByAccountId(@PathVariable Long accountId) {
        List<DebitCard> debitCards = cardService.getDebitCardsByAccountId(accountId);
        return ResponseEntity.ok(debitCards);
    }

    @GetMapping("/credit/{customerId}")
    public ResponseEntity<List<CreditCard>> getCreditCardsByCustomerId(@PathVariable Long customerId) {
        List<CreditCard> creditCards = cardService.getCreditCardsByCustomerId(customerId);
        return ResponseEntity.ok(creditCards);
    }
}
