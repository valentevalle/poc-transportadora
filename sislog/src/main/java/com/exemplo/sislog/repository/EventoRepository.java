package com.exemplo.sislog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.sislog.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
}
