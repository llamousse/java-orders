package com.vyue.javaorders.services;

import com.vyue.javaorders.models.Customer;
import com.vyue.javaorders.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepo custrepos;

	@Override
	public List<Customer> findAll()
	{
		List<Customer> list = new ArrayList<>();
		custrepos.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Customer findCustomerByName(String name)
	{
		return null;
	}

	@Override
	public void delete(long id)
	{

	}

	@Override
	public Customer save(Customer customer)
	{
		return null;
	}

	@Override
	public Customer update(Customer customer, long id)
	{
		return null;
	}
}
