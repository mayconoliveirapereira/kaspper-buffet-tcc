package com.buffet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buffet.backend.model.Cliente;
import com.buffet.backend.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getCliente() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente getClienteById(long id) {
		 return clienteRepository.findById(id).get();
	}

	@Override
	public void deleteCliente(long id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente updateCliente(Cliente cliente, long id) {
		 Cliente cliente1 = clienteRepository.findById(id).get();
		 cliente1.setName(cliente.getName());
		 cliente1.setEmail(cliente.getEmail());
		 cliente1.setpNo(cliente.getpNo());
		 cliente1.setAddress(cliente.getAddress());
		 
		 
		 return clienteRepository.save(cliente1);
	}


	

}