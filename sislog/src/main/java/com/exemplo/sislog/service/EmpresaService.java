package com.exemplo.sislog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.sislog.model.Empresa;
import com.exemplo.sislog.repository.EmpresaRepository;

@Service
@Transactional
public class EmpresaService {

	Logger logger = LoggerFactory.getLogger(EmpresaService.class);

	@Autowired
	private EmpresaRepository empresaRepository;
    
    public Empresa incluir(Empresa empresa) {
    	return empresaRepository.save(empresa);
//    	if(empresaRepository.findByCnpj(empresa.getCnpj()))
    	
//    	empresaRepository.find(empresa);
//    	empresaRepository.
    }

}
