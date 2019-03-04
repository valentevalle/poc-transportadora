package com.exemplo.sislog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.sislog.model.Evento;
import com.exemplo.sislog.service.EventoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/evento")
public class EventoController {
	
	Logger logger = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	EventoService eventoService;

	@RequestMapping(value = "/incluir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> registrarEvento(@RequestBody Evento evento) {
		eventoService.registrarEvento(evento);
		return new ResponseEntity<String>("Evento registrado com sucesso", HttpStatus.OK);
	}
	
	
	

}
