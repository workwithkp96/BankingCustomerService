package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private LocalDate validity;
    private double limit;
    private int rewardPoints;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
