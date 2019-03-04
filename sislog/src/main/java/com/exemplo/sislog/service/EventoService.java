package com.exemplo.sislog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.sislog.model.Evento;
import com.exemplo.sislog.repository.EventoRepository;

@Service
@Transactional
public class EventoService {

	Logger logger = LoggerFactory.getLogger(EventoService.class);

	
	@Autowired
	private EventoRepository eventoRepository;
		
    public void registrarEvento(Evento evento) {
    	eventoRepository.save(evento);
    }

   

}
