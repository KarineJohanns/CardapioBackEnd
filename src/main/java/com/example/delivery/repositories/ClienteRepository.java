package com.example.delivery.repositories;

import com.example.delivery.models.CategoriaModel;
import com.example.delivery.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    ClienteModel findByNome(String nome);
    ClienteModel findByTelefone(String telefone);
}
