package com.bk.test.producer.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.test.producer.dao.CustomerRepository;
import com.bk.test.producer.dao.SimpleCustomerRepository;
import com.bk.test.producer.entity.Customer;
import com.bk.test.producer.entity.SimpleCustomer;

@RestController
@RequestMapping("/mysql")
public class MySqlController
{
	private int pageSize = 10;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SimpleCustomerRepository simpleCustomerRepository;

	/*
	http://localhost:8001/customer?id=1
	 */
	@RequestMapping("/customer")
	public Customer findCustomer(Long id)
	{
		return customerRepository.getOne(id);
	}

	/*
	http://localhost:8001/update-customer?id=1
	 */
	@RequestMapping("/update-customer")
	public OperationResult updateCustomer(Long id)
	{
		OperationResult result = new OperationResult();
		Customer customer = customerRepository.getOne(id);

		if (customer == null)
		{
			result.setErrorMessage(String.format("Customer with id %d not found!", id));
			return result;
		}

		customer.setName("Test-Customer");
		Customer updatedCustomer = customerRepository.save(customer);
		result.setData(updatedCustomer);
		return result;
	}

	@RequestMapping("/paging-customers")
	public List<Customer> pagingCustomers(int page)
	{
		Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Direction.DESC, "Created"));
		Page<Customer> customerPage = customerRepository.findAll(pageable);
		System.out.println(String.format("TotalElements: %d", customerPage.getTotalElements()));
		System.out.println(String.format("TotalPages: %d", customerPage.getTotalPages()));
		return customerPage.getContent();
	}

	@RequestMapping("/paging-simple-customers")
	public List<SimpleCustomer> pagingSimpleCustomers(int page) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//"yyyy-MM-dd HH:mm:ss.SSS");
		Date startDate = sdf.parse("2018-01-01");//DateFormatUtils.parse("2018-01-01", "yyyy-MM-dd");
		return simpleCustomerRepository.paging(startDate, (page - 1) * pageSize, pageSize);
	}
}
class OperationResult
{
	private String errorMessage;
	private Object data;
	
	
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	public Object getData()
	{
		return data;
	}
	public void setData(Object data)
	{
		this.data = data;
	}
	
}
