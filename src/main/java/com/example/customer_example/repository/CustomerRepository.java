package com.example.customer_example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer_example.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
