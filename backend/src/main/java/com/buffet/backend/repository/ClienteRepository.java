package com.buffet.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buffet.backend.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}