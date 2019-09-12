package com.vyue.javaorders.services;

import com.vyue.javaorders.models.Customer;

import java.util.List;

// interface - functions for implementation
public interface CustomerService
{
	// returns all customers with orders
	List<Customer> findAll();

	// (R) - returns orders for customer from name
	Customer findCustomerByName(String name);

	// (D) - deletes customer based on customer id + their orders
	void delete(long id);

	// (C) - creates new customer + any associated orders
	Customer save(Customer customer);

	// (U) - updates customer based on customer id
	Customer update(Customer customer, long id);
}
