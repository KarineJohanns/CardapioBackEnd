package com.example.delivery.Dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(
        @NotBlank
        String nome
) {

}
