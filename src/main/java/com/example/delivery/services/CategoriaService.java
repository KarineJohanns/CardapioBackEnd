package com.example.delivery.services;

import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.exceptions.NotFoundException;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.repositories.CategoriaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    public CategoriaModel criarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = new CategoriaModel();

        categoriaModel.setNome(categoriaDTO.nome());

        return categoriaRepository.save(categoriaModel);
    }

    public List<CategoriaModel> listarCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias;
    }

    public CategoriaModel listarCategoriaId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID" + id));
    }

    public CategoriaModel alterarCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID" + id));
        categoriaExistente.setNome(categoriaDTO.nome());

        return categoriaRepository.save(categoriaExistente);
    }

    public void apagarCategoria(Long id) {
        CategoriaModel categoriaApagada = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID: " + id));
        categoriaRepository.delete(categoriaApagada);
    }

    public List<CategoriaModel> listarCategoriasComProdutos() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();

        return categorias.stream()
                .collect(Collectors.toList());
    }

    private CategoriaDTO convertToDTO(CategoriaModel categoria) {
        List<ProdutoModel> produtos = categoria.getProdutos();
        return new CategoriaDTO(categoria.getId(), categoria.getNome(), produtos);
    }
}


