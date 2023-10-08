package com.example.delivery.Dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CategoriaDTO {
        Long id;

        String nomeCategoria;
        List<ProdutoDTO> produtos;


        // Construtor
        public CategoriaDTO() {
        }

        // Getters e setters para todos os campos
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNomeCategoria() {
                return nomeCategoria;
        }

        public void setNomeCategoria(String nomeCategoria) {
                this.nomeCategoria = nomeCategoria;
        }

        public List<ProdutoDTO> getProdutos() {
                return produtos;
        }

        public void setProdutos(List<ProdutoDTO> produtos) {
                this.produtos = produtos;
        }

}
