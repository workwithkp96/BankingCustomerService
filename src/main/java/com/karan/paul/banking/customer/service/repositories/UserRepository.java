package com.karan.paul.banking.customer.service.repositories;

import com.karan.paul.banking.customer.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
