package com.karan.paul.banking.customer.service.entities;

import com.karan.paul.banking.customer.service.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type; // CREDIT, DEBIT
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private SavingsCurrentAccount savingsCurrentAccount;
}
