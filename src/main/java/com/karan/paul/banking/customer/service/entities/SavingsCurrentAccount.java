package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "savings_current_accounts ")
public class SavingsCurrentAccount  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
