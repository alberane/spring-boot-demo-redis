package com.example.spring_boot_demo_redis.repository;

import com.example.spring_boot_demo_redis.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
}