package com.example.delivery.repositories;


import com.example.delivery.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    CategoriaModel findByNome(String nome);
}
