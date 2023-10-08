package com.example.delivery.config;

import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.Dto.ProdutoDTO;
import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ProdutoModel;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(CategoriaDTO.class, CategoriaModel.class)
                .addMapping(CategoriaDTO::getNomeCategoria, CategoriaModel::setNome);

        modelMapper.createTypeMap(ProdutoDTO.class, ProdutoModel.class)
                .addMapping(ProdutoDTO::getPreco, ProdutoModel::setPreco);


        return modelMapper;
    }
}
