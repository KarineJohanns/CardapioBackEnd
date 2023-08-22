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


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaCriada = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCriada);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        List<CategoriaModel> categorias = categoriaService.listarCategorias();
        String mensagem = "Categoria listada com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(categorias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaModel> listarCategoriaId(@PathVariable Long id) {
        CategoriaModel categoria = categoriaService.listarCategoriaId(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaModel> alterarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaAlterada = categoriaService.alterarCategoria(id, categoriaDTO);
        String mensagem = "Categoria " + categoriaAlterada.getNome() + " alterada com sucesso.";
        return ResponseEntity.status(HttpStatus.OK).header("Mensagem", mensagem).body(categoriaAlterada);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> apagarCategoria(@PathVariable Long id) {
        categoriaService.apagarCategoria(id);
        String mensagem = "Produto  " + id + " apagado com sucesso.";
        return ResponseEntity.noContent().header("Mensagem", mensagem).build();
    }

}
