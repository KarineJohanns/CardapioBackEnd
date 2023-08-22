package com.example.delivery.Dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record HistoricoPedidoDTO(
        Long id,
        Long pedidoId,

        Long valorTotal,

        @NotNull(message = "A data e hora de criação não pode ser nula") LocalDateTime dataHoraCriacao,
        @NotNull(message = "A data e hora de conclusão não pode ser nula") LocalDateTime dataHoraConclusao
) {
}
