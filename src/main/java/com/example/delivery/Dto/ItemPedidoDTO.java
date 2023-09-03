package com.example.delivery.Dto;

import jakarta.validation.constraints.NotNull;

public record ItemPedidoDTO(
        Long id,
        Long idProduto,
        String descricao,
        @NotNull(message = "A quantidade não pode ser nula") Integer quantidade,
        @NotNull Integer valorUnitario,
        @NotNull(message = "O subtotal não pode ser nulo") Long valorTotal
) {
    public Integer getQuantidade() {
        return this.quantidade();
    }

    public Long getProdutoId() {
        return this.idProduto();
    }

    public String getProduto() { return this.descricao();
    }

    public Integer getValorUnitario() {return this.valorUnitario();
    }
}