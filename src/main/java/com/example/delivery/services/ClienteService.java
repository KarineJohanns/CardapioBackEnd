package com.example.delivery.services;

import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.Dto.ClienteDTO;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ClienteModel;
import com.example.delivery.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel criarCliente(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO, clienteModel);
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> listarClientes() {
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes;
    }

}

