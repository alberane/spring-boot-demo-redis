package com.example.spring_boot_demo_redis.controller;

import com.example.spring_boot_demo_redis.model.Cliente;
import com.example.spring_boot_demo_redis.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @PostMapping
  @CacheEvict(value = "clientes", allEntries = true)
  public Cliente criar(@RequestBody Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @GetMapping("/{id}")
  public Optional<Cliente> buscarPorId(@PathVariable String id) {
    return clienteRepository.findById(id);
  }

  @GetMapping
  @Cacheable(value = "clientes")
  public List<Cliente> listarTodos() {
    return (List<Cliente>) clienteRepository.findAll();
  }

  @PutMapping("/{id}")
  @CacheEvict(value = "clientes", allEntries = true)
  public Cliente atualizar(@PathVariable String id, @RequestBody Cliente cliente) {
    cliente.setId(id);
    return clienteRepository.save(cliente);
  }

  @DeleteMapping("/{id}")
  @CacheEvict(value = "clientes", allEntries = true)
  public void deletar(@PathVariable String id) {
    clienteRepository.deleteById(id);
  }
}