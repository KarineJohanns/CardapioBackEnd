package com.example.delivery.services;

import com.example.delivery.exceptions.NotFoundException;
import com.example.delivery.models.ItemPedidoModel;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.repositories.ItemPedidoRepository;


import com.example.delivery.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository, ProdutoRepository produtoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.produtoRepository = produtoRepository;
    }

}