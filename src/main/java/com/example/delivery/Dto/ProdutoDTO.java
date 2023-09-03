package com.example.delivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(

        Long id,
        @NotBlank
        String nome,
        String descricao,
        @NotNull
        Integer precoEmCentavos,
        String nomeCategoria
) {

    public String getNomeCategoria() {
        return this.nomeCategoria();
    }

    public String getDescricao() {
        return this.descricao();
    }

    public String getNome() {
        return this.nome();
    }

    public Integer getPrecoEmCentavos() {
        return this.precoEmCentavos();
    }
}
