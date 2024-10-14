package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "debit_cards")
public class DebitCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private LocalDate validity;
    private double limit;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private SavingsCurrentAccount savingsCurrentAccount;
}
