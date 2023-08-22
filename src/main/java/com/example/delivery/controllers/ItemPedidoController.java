package com.example.delivery.controllers;

import com.example.delivery.Dto.ItemPedidoDTO;
import com.example.delivery.models.ItemPedidoModel;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.services.ItemPedidoService;
import com.example.delivery.repositories.ItemPedidoRepository;
import com.example.delivery.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

}

