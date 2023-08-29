package com.buffet.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buffet.backend.model.Cliente;

@Service
public interface ClienteService {

	//create cliente
	public Cliente createCliente(Cliente cliente);
	
	
	//read users - Listar
	public List<Cliente> getCliente();
	
	//read cliente by id - Listar pelo id
	public Cliente getClienteById(long id);
	
	//delete cliente by id
	public void  deleteCliente(long id);
	
	
	//update cliente by id
	public Cliente updateCliente(Cliente cliente, long id);
	
}
