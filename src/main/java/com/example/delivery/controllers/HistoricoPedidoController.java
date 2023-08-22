package com.example.delivery.controllers;

import com.example.delivery.models.HistoricoPedidoModel;
import com.example.delivery.services.HistoricoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/historico-pedidos")
public class HistoricoPedidoController {

    private final HistoricoPedidoService historicoPedidoService;

    @Autowired
    public HistoricoPedidoController(HistoricoPedidoService historicoPedidoService) {
        this.historicoPedidoService = historicoPedidoService;
    }

}

