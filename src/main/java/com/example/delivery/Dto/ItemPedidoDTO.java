package com.example.delivery.Dto;

import jakarta.validation.constraints.NotNull;

public record ItemPedidoDTO(
        Long id,
        Long idProduto,
        String descricao,
        @NotNull(message = "A quantidade não pode ser nula") Integer quantidade,
        @NotNull(message = "O subtotal não pode ser nulo") Long valorTotal
) {
    public Long getProdutoId() {
        return this.idProduto();
    }
}
