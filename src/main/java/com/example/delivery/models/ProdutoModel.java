package com.example.delivery.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Integer preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel nomeCategoria;

    // Construtores, getters e setters

    public ProdutoModel() {
    }

    public ProdutoModel(String nome, String descricao, Integer preco, CategoriaModel nomeCategoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public CategoriaModel getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(CategoriaModel nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}