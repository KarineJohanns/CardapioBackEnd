package com.example.delivery.controllers;

import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.repositories.CategoriaRepository;
import com.example.delivery.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaCriada = categoriaService.criarCategoria(categoriaDTO);
        String mensagem = "Categoria criada com sucesso.";
        return ResponseEntity.status(HttpStatus.CREATED).header("Mensagem", mensagem).body(categoriaCriada);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaService.listarCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> listarCategoriaId(@PathVariable Long id) {
        CategoriaDTO categoria = categoriaService.listarCategoriaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> alterarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaAlterada = categoriaService.alterarCategoria(id, categoriaDTO);
        String mensagem = "Categoria " + categoriaAlterada.getNomeCategoria() + " alterada com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(categoriaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCategoria(@PathVariable Long id) {
        categoriaService.apagarCategoria(id);
        String mensagem = "Categoria ID " + id + " apagada com sucesso.";
        return ResponseEntity.noContent().header("Mensagem", mensagem).build();
    }

}
