package com.example.delivery.repositories;

import com.example.delivery.models.HistoricoPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoPedidoRepository extends JpaRepository<HistoricoPedidoModel, Long> {

}
