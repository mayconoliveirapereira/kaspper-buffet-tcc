package com.buffet.backend.controller;

import com.buffet.backend.model.Cliente;
import com.buffet.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok(createdCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodosClientes() {
        List<Cliente> clientes = clienteService.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteService.buscarClientePorId(id);

        if (clienteExistente != null) {
            clienteExistente.setName(cliente.getName());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setpNo(cliente.getpNo());
            clienteExistente.setAddress(cliente.getAddress());
            clienteExistente.setTipoEvento(cliente.getTipoEvento());

            Cliente clienteAtualizado = clienteService.atualizarCliente(clienteExistente);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirClientePorId(@PathVariable Long id) {
        Cliente clienteExistente = clienteService.buscarClientePorId(id);

        if (clienteExistente != null) {
            clienteService.excluirClientePorId(id);
            String mensagem = "O cliente " + clienteExistente.getName() + " foi deletado com sucesso.";
            return ResponseEntity.ok(mensagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
