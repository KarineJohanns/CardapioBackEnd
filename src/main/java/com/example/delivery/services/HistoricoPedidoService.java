package com.example.delivery.services;

import com.example.delivery.models.HistoricoPedidoModel;
import com.example.delivery.repositories.HistoricoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoricoPedidoService {

    private final HistoricoPedidoRepository historicoPedidoRepository;

    @Autowired
    public HistoricoPedidoService(HistoricoPedidoRepository historicoPedidoRepository) {
        this.historicoPedidoRepository = historicoPedidoRepository;
    }
}
