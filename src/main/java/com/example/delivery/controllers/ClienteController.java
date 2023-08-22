package com.example.delivery.controllers;

import com.example.delivery.Dto.ClienteDTO;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ClienteModel;
import com.example.delivery.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        ClienteModel clienteCriado = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes() {
        List<ClienteModel> clientes = clienteService.listarClientes();
        String mensagem = "Cliente criado com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(clientes);
    }
}

