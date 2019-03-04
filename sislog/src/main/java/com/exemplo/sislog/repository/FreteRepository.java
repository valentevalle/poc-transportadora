package com.exemplo.sislog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.sislog.model.ModalTransporte;
import com.exemplo.sislog.model.TabelaFrete;
import com.exemplo.sislog.model.TipoCarga;

public interface FreteRepository extends JpaRepository<TabelaFrete, Long> {
	TabelaFrete findByTipoCargaAndModalTransporte(TipoCarga tipoCarga, ModalTransporte modalTransporte);
}
