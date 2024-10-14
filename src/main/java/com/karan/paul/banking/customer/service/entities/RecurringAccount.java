package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "recurring_accounts")
public class RecurringAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monthlyInvestment;
    private Double interestRate;
    private LocalDate nextCycleDate;
    private LocalDate lastInvestmentDate;
    private LocalDate maturityDate;
    private Double maturedAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
