package com.vyue.javaorders.controllers;

import com.vyue.javaorders.models.Customer;
import com.vyue.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

	// GET - returns all orders for a particular customer based on name
	// localhost:2019/data/customers/name/{custname}
	//	@GetMapping(value = "/name/{custname}",
	//				produces = {"application/json"})
	//	public ResponseEntity<?> getCustomerByName(@PathVariable String name)
	//	{
	//		Customer customer = customerService.findCustomerByName(name);
	//		return new ResponseEntity<>(customer, HttpStatus.OK);
	//	}

	// POST - adds a new customer including any new orders
	// localhost:2019/data/customers/new
	@PostMapping(value = "/new")
	public ResponseEntity<?> saveCustomer(
			@Valid
			@RequestBody Customer newCustomer)
	{
		newCustomer = customerService.save(newCustomer);

		// set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
		responseHeaders.setLocation(newCustomerURI);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	// DELETE - deletes the customer based off of custcode
	// localhost:2019/data/customers/delete/{custcode}
	@DeleteMapping("/delete/{custcode}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
	{
		customerService.delete(custcode);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
