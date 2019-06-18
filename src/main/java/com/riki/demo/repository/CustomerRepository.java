package com.riki.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riki.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
