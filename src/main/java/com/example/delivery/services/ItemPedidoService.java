package com.example.delivery.services;

import com.example.delivery.Dto.ItemPedidoDTO;
import com.example.delivery.Dto.PedidoDTO;
import com.example.delivery.models.ItemPedidoModel;
import com.example.delivery.models.PedidoModel;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.repositories.ItemPedidoRepository;


import com.example.delivery.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

