package com.example.delivery.controllers;

import com.example.delivery.Dto.ProdutoDTO;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        ProdutoDTO produtoCriado = produtoService.criarProduto(produtoDTO);
        String mensagem = "Produto " + produtoCriado.getNome() + " criado com sucesso.";
        return ResponseEntity.status(HttpStatus.CREATED).header("Mensagem", mensagem).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        String mensagem = "Produtos listados com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> listarProdutoId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.listarProdutoId(id);
        String mensagem = "Produto listado com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarProduto(@PathVariable Long id) {
        produtoService.apagarProduto(id);
        String mensagem = "Produto apagado com sucesso.";
        return ResponseEntity.noContent().header("Mensagem", mensagem).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAlterado = produtoService.alterarProduto(id, produtoDTO);
        String mensagem = "Produto alterado com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(produtoAlterado);
    }
}

