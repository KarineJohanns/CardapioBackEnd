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
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        ProdutoModel produtoCriado = produtoService.criarProduto(produtoDTO);
        String mensagem = "Produto criado com sucesso.";
        return ResponseEntity.status(HttpStatus.CREATED).header("Mensagem", mensagem).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<ProdutoModel> produtos = produtoService.listarProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoModel> listarProdutoId(@PathVariable Long id) {
        ProdutoModel produtoId = produtoService.listarProdutoId(id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoId);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarProduto(@PathVariable Long id) {
        produtoService.apagarProduto(id);
        String mensagem = "Produto  " + id + " apagado com sucesso.";
        return ResponseEntity.noContent().header("Mensagem", mensagem).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoModel> alterarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoDTO produtoDTO) {
        ProdutoModel produtoAlterado = produtoService.alterarProduto(id, produtoDTO);
        String mensagem = "Produto  " + id + " alterado com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).body(produtoAlterado);
    }
}

