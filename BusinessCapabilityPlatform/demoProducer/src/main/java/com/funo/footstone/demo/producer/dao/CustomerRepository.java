package com.funo.footstone.demo.producer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funo.footstone.demo.producer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}