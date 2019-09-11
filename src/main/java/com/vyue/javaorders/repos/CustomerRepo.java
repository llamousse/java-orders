package com.vyue.javaorders.repos;

import com.vyue.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long>
{
}
