package com.example.delivery.Dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        String endereco,
        @NotBlank
        String telefone
) {

}
