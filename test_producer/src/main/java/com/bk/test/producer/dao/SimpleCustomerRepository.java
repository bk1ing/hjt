package com.bk.test.producer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bk.test.producer.entity.SimpleCustomer;

public interface SimpleCustomerRepository extends JpaRepository<SimpleCustomer, Long>
{
	@Query(value = "select ID, Name1 Name, Address1 Address, Created from Customer where Created > ?1 and Name1 is not null order by Created desc limit ?2, ?3", nativeQuery = true)
	List<SimpleCustomer> paging(Date startDate, int skip, int pageSize);
	
	
}
