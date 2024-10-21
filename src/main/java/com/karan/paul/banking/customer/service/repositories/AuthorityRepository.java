package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    public List<Authority> findByUserId(Long userId);
}
