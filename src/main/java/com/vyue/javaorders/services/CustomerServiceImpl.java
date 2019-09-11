package com.vyue.javaorders.services;

import com.vyue.javaorders.models.Customer;
import com.vyue.javaorders.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
	public Customer findCustomerByName(String name) throws EntityNotFoundException
	{
		return null;
	}

//	@Override
//	public Customer findCustomerByName(String name) throws EntityNotFoundException
//	{
//		Customer cus = custrepos.findCustomerByName(name);
//
//		if (cus == null)
//		{
//			throw new EntityNotFoundException("Customer " + name + " not found!");
//		} else
//		{
//			return cus;
//		}
//	}

	@Override
	@Transactional
	public void delete(long id)
	{
		// see if id exists
		// yes - delete
		// no - warning

		if (custrepos.findById(id).isPresent())
		{
			custrepos.deleteById(id);
		} else
		{
			throw new EntityNotFoundException(Long.toString(id));
		}
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
