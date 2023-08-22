package com.example.delivery.controllers;

import com.example.delivery.Dto.PedidoDTO;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.PedidoModel;
import com.example.delivery.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody @Valid PedidoDTO pedidoDTO) {
        PedidoModel pedidoCriado = pedidoService.criarPedido(pedidoDTO);
        String mensagem = "Pedido criado com sucesso.";
        return ResponseEntity.status(HttpStatus.CREATED).header("Mensagem", mensagem).body(pedidoCriado);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarPedidos() {
        List<PedidoModel> listaDePedidos = pedidoService.listarPedidos();
        return ResponseEntity.status((HttpStatus.OK)).body(listaDePedidos);
    }
}

