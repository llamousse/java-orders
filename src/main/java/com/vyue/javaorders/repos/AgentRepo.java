package com.vyue.javaorders.repos;

import com.vyue.javaorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

// interface for CRUD repo
public interface AgentRepo extends CrudRepository<Agent, Long>
{
}
