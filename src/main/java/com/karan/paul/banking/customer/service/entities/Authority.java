package com.karan.paul.banking.customer.service.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
