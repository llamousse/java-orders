package com.vyue.javaorders.repos;

import com.vyue.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

// interface for CRUD repo
public interface OrderRepo extends CrudRepository<Order, Long>
{
}
