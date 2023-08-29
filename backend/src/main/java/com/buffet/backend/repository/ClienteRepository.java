package com.buffet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buffet.backend.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}