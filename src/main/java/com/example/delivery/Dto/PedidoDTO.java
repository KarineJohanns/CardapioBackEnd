package com.example.delivery.Dto;

import com.example.delivery.enums.StatusPedido;
import com.example.delivery.models.ItemPedidoModel;
import com.example.delivery.models.PedidoModel;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        Long id,
        String cliente,
        String endereco,
        String telefone,
        List<ItemPedidoModel> itensPedido
) {
    public String getCliente() {
        return this.cliente();
    }
    public String getTelefone() { return this.telefone(); }
    public String getEndereco() {
        return this.endereco();
    }

    public List<ItemPedidoModel> getItensPedido() {
        return this.itensPedido;
    }

    public PedidoModel getIdPedido() {
        return this.getIdPedido();
    }

}
