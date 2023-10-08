package com.example.delivery.repositories;


import com.example.delivery.Dto.CategoriaDTO;
import com.example.delivery.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    @Query("SELECT c FROM CategoriaModel c WHERE c.nome = ?1")
    CategoriaModel findByNome(String nome);
}
