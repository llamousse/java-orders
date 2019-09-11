package com.vyue.javaorders.services;

import com.vyue.javaorders.models.Customer;

import java.util.List;

// interface - functions for implementation
public interface CustomerService
{
	List<Customer> findAll();

	Customer findCustomerByName(String name);

	void delete(long id);

	Customer save(Customer customer);

	Customer update(Customer customer, long id);
}
