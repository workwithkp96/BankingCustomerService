package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "fixed_accounts")
public class FixedAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double interestRate;
    private LocalDate startDate;
    private LocalDate maturityDate;
    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
