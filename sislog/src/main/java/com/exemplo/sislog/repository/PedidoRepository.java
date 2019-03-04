package com.exemplo.sislog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.sislog.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
//    Optional<Pedido> findById(Long id);
}
