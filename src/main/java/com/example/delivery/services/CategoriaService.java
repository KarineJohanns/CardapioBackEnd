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

    public CategoriaDTO mapToDTO(CategoriaModel categoriaModel) {
        return modelMapper.map(categoriaModel, CategoriaDTO.class);
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = modelMapper.map(categoriaDTO, CategoriaModel.class);

        categoriaModel = categoriaRepository.save(categoriaModel);

        return modelMapper.map(categoriaModel, CategoriaDTO.class);
    }

    public List<CategoriaDTO> listarCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    public CategoriaDTO listarCategoriaPorId(Long id) {
        CategoriaModel categoriaModel = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID " + id));

        return modelMapper.map(categoriaModel, CategoriaDTO.class);
    }

    public CategoriaDTO alterarCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID " + id));

        categoriaExistente.setNome(categoriaDTO.getNomeCategoria());

        categoriaExistente = categoriaRepository.save(categoriaExistente);

        return modelMapper.map(categoriaExistente, CategoriaDTO.class);
    }

    public void apagarCategoria(Long id) {
        CategoriaModel categoriaApagada = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID " + id));

        categoriaRepository.delete(categoriaApagada);
    }

    public CategoriaModel listarCategoriaId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria", "ID " + id));
    }

    public CategoriaModel buscarCategoriaPorNome(String nomeCategoria) {
        return categoriaRepository.findByNome(nomeCategoria);
    }
}


