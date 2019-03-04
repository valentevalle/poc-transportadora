package com.exemplo.sislog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.sislog.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {
	Empresa findByCnpj(String cnpj);
}
