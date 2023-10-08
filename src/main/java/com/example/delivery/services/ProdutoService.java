package com.example.delivery.services;

import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.Dto.ClienteDTO;
import com.example.delivery.Dto.ProdutoDTO;
import com.example.delivery.exceptions.NotFoundException;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ClienteModel;
import com.example.delivery.models.ProdutoModel;
import com.example.delivery.repositories.CategoriaRepository;
import com.example.delivery.repositories.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaService categoriaService, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
        this.modelMapper = modelMapper;
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        String nomeCategoria = produtoDTO.getNomeCategoria();
        CategoriaModel categoria = categoriaService.buscarCategoriaPorNome(nomeCategoria);


        ProdutoModel novoProduto = new ProdutoModel(
                produtoDTO.getNome(),
                produtoDTO.getDescricao(),
                produtoDTO.getPreco(),
                categoria
        );

        ProdutoModel produtoCriado = produtoRepository.save(novoProduto);

        return modelMapper.map(produtoCriado, ProdutoDTO.class);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produtoModel -> modelMapper.map(produtoModel, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    public ProdutoDTO listarProdutoId(Long id) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID " + id));
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public void apagarProduto(Long id) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID " + id));

        produtoRepository.delete(produto);
    }

    public ProdutoDTO alterarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoModel produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID " + id));

        String nomeCategoria = produtoDTO.getNomeCategoria();
        CategoriaModel categoria = categoriaService.buscarCategoriaPorNome(nomeCategoria);

        if (categoria == null) {
            throw new NotFoundException("Categoria", "Nome '" + nomeCategoria + "' não encontrada.");
        }
        modelMapper.map(produtoDTO, produtoExistente);
        produtoExistente.setNomeCategoria(categoria);
        ProdutoModel produtoAlterado = produtoRepository.save(produtoExistente);

        return modelMapper.map(produtoAlterado, ProdutoDTO.class);
    }



}

