package com.example.delivery.Dto;

import com.example.delivery.models.ProdutoModel;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CategoriaDTO(
        Long id,
        @NotBlank
        String nome,
        List<ProdutoModel> produtos
) {

}
