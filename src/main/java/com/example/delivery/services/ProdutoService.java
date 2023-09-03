package com.example.delivery.services;

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

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    public ProdutoModel criarProduto(ProdutoDTO produtoDTO) {
        CategoriaModel categoria = categoriaRepository.findByNome(produtoDTO.getNomeCategoria());

        if (categoria == null) {
            throw new NotFoundException("Categoria", "Nome: " + produtoDTO.getNomeCategoria());
        }

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setDescricao(produtoDTO.getDescricao());
        produtoModel.setNome(produtoDTO.getNome());
        produtoModel.setPrecoEmCentavos(produtoDTO.getPrecoEmCentavos());
        produtoModel.setNomeCategoria(categoria);

        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarProdutos() {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        return produtos;
    }

    public ProdutoModel listarProdutoId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID" + id));
    }

    public void apagarProduto(Long id) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID: " + id));

        produtoRepository.delete(produto);
    }

    public ProdutoModel alterarProduto(Long id, ProdutoDTO produtoDTO) {
        CategoriaModel categoria = categoriaRepository.findByNome(produtoDTO.getNomeCategoria());

        if (categoria == null) {
            throw new NotFoundException("Categoria", "Nome: " + produtoDTO.getNomeCategoria());
        }

        ProdutoModel produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto", "ID" + id));

        produtoExistente.setDescricao(produtoDTO.getDescricao());
        produtoExistente.setNome((produtoDTO.getNome()));
        produtoExistente.setPrecoEmCentavos((produtoDTO.getPrecoEmCentavos()));
        produtoExistente.setNomeCategoria(categoria);

        return produtoRepository.save(produtoExistente);
    }



}

