package com.exemplo.sislog.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.sislog.model.Evento;
import com.exemplo.sislog.model.Pedido;
import com.exemplo.sislog.model.TipoEvento;
import com.exemplo.sislog.repository.PedidoRepository;

@Service
@Transactional
public class PedidoService {

	Logger logger = LoggerFactory.getLogger(PedidoService.class);

	@Autowired
	FreteService freteService;
	
	@Autowired
	GoogleMatrixService googleMatrixService;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private EventoService eventoService;
	@Value("${activiti.process.name}")
	private String PROCESS_NAME;

	public void solicitar(Pedido pedido) {
		freteService.calcularFrete(pedido);
		pedido.setEmpresaColeta(empresaService.incluir(pedido.getEmpresaColeta()));
		pedido.setEmpresaEntrega(empresaService.incluir(pedido.getEmpresaEntrega()));
		Evento eventoAbertura = new Evento();
		pedidoRepository.save(pedido);
		eventoAbertura.setPedido(pedido);
		eventoAbertura.setTipoEvento(TipoEvento.SOLICITADO);
		eventoAbertura.setData(new Date());
		eventoAbertura.setDescricao("Pedido recebido. Aguardando para ser expedido");
		eventoService.registrarEvento(eventoAbertura);
	}
	
}
