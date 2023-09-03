package com.example.delivery.services;

import com.example.delivery.Dto.PedidoDTO;
import com.example.delivery.models.ClienteModel;
import com.example.delivery.models.ItemPedidoModel;
import com.example.delivery.models.PedidoModel;
import com.example.delivery.repositories.ClienteRepository;
import com.example.delivery.repositories.ItemPedidoRepository;
import com.example.delivery.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienterepository, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienterepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public PedidoModel criarPedido(PedidoDTO pedidoDTO) {
        ClienteModel cliente = clienteRepository.findByTelefone(pedidoDTO.getTelefone());

        if (cliente == null) {
            cliente = new ClienteModel();
            cliente.setNome(pedidoDTO.getCliente());
            cliente.setTelefone(pedidoDTO.getTelefone());
            cliente.setEndereco(pedidoDTO.getEndereco());

            cliente = clienteRepository.save(cliente);
        } else {
            if (!cliente.getNome().equals(pedidoDTO.getCliente())) {
                cliente.setNome(pedidoDTO.getCliente());
                cliente.setEndereco(pedidoDTO.getEndereco());
                cliente = clienteRepository.save(cliente);
            }
        }

        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setCliente(cliente.getNome());
        pedidoModel.setTelefone(pedidoDTO.getTelefone());
        pedidoModel.setEndereco(pedidoDTO.getEndereco());

        Integer totalPagamento = 0;
        for (ItemPedidoModel itemPedido : pedidoDTO.getItensPedido()) {
            Integer quantidade = itemPedido.getQuantidate();
            Integer precoUnitario = itemPedido.getValorUnitario();
            Integer totalItem = quantidade * precoUnitario;
            itemPedido.setValorTotal(totalItem);
        }

        for (ItemPedidoModel itemPedido : pedidoDTO.getItensPedido()) {
            totalPagamento += itemPedido.getValorTotal();
        }
        pedidoModel.setTotalPagamento(totalPagamento);

        pedidoModel = pedidoRepository.save(pedidoModel);

        for (ItemPedidoModel itemPedido : pedidoDTO.getItensPedido()) {
            itemPedido.setPedido(pedidoModel);
            itemPedidoRepository.save(itemPedido);
        }
        pedidoModel.setItensPedido(pedidoDTO.getItensPedido());

        return pedidoModel;

    }

    public List<PedidoModel> listarPedidos() {
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public PedidoModel getPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElse(null);
    }

}