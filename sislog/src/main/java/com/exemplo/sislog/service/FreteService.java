package com.exemplo.sislog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.sislog.model.Pedido;
import com.exemplo.sislog.model.TabelaFrete;
import com.exemplo.sislog.repository.FreteRepository;

@Service
@Transactional
public class FreteService {

	Logger logger = LoggerFactory.getLogger(FreteService.class);

	@Autowired
    private GoogleMatrixService googleMatrixService;
	
	@Autowired
	private FreteRepository freteRepository;
		
    public void calcularFrete(Pedido pedido) {
    	Long distancia = googleMatrixService.calcularDistancia(pedido.getEmpresaColeta(), pedido.getEmpresaEntrega());
    	if((pedido!=null) &&( pedido.getModalTransporte()!=null) && (pedido.getCarga()!=null) &&(pedido.getCarga().getTipoCarga()!=null) && (distancia!=null)) {
    		TabelaFrete frete = freteRepository.findByTipoCargaAndModalTransporte(pedido.getCarga().getTipoCarga(), pedido.getModalTransporte());
    		if (frete==null) throw new RuntimeException("Não foi possível encontrar tarifa de frete com o modal:"+pedido.getModalTransporte()+" e tipo de carga:"+pedido.getCarga().getTipoCarga());
    		pedido.setTotal(frete.getValor()*distancia);
    	}else {
    		pedido.setTotal(null);
    	}
    }
    
    public void incluir(TabelaFrete frete) {
    	freteRepository.save(frete);
    }

}
