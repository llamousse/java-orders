package com.vyue.javaorders.controllers;

import com.vyue.javaorders.models.Customer;
import com.vyue.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/customers")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	// GET - returns all customers with their orders
	// localhost:2019/data/customers/orders
	@GetMapping(value = "/orders",
				produces = {"application/json"})
	public ResponseEntity<?> listAllCustomers()
	{
		List<Customer> myCustomers = customerService.findAll();
		return new ResponseEntity<>(myCustomers, HttpStatus.OK);
	}


}
