package com.vyue.javaorders.repos;

import com.vyue.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

// interface for CRUD repo
public interface CustomerRepo extends CrudRepository<Customer, Long>
{
	Customer findByCustname(String name);
}
