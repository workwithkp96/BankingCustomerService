package com.karan.paul.banking.customer.service.entities;

import com.karan.paul.banking.customer.service.enums.LoanType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LoanType type; // PERSONAL, HOME, CAR, BIKE
    private double amount;
    private double interestRate;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
