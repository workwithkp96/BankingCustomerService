package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
