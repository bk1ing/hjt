package com.bk.test.producer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bk.test.producer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}