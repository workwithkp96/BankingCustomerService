package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "debit_cards")
public class DebitCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private LocalDate validity;
    private Double debitLimit;

    @ManyToMany
    @JoinTable(
            name = "debit_card_account_link",  // Name of the join table
            joinColumns = @JoinColumn(name = "debit_card_id"),  // Foreign key in join table for DebitCard
            inverseJoinColumns = @JoinColumn(name = "account_id")  // Foreign key in join table for SavingsCurrentAccount
    )
    private List<SavingsCurrentAccount> savingsCurrentAccounts;
}
