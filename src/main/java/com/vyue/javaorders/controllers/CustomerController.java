package com.vyue.javaorders.controllers;

import com.vyue.javaorders.models.Customer;
import com.vyue.javaorders.models.Order;
import com.vyue.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	// localhost:2019/customer/order
	@GetMapping(value = "/order",
				produces = {"application/json"})
	public ResponseEntity<?> listAllOrders()
	{
		List<Order> myOrders = customerService.findAll();
		return new ResponseEntity<>(myOrders, HttpStatus.OK);
	}
}
