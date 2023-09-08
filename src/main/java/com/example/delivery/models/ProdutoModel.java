package com.example.delivery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Integer precoEmCentavos;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private CategoriaModel nomeCategoria;


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

    public Integer getPrecoEmCentavos() {
        return precoEmCentavos;
    }

    public void setPrecoEmCentavos(Integer precoEmCentavos) {
        this.precoEmCentavos = precoEmCentavos;
    }

    public CategoriaModel getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(CategoriaModel nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
