package com.intercorp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intercorp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
