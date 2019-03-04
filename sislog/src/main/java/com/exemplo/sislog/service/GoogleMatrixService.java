package com.exemplo.sislog.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.exemplo.sislog.model.Empresa;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;


@Service
public class GoogleMatrixService {
	Logger logger = LoggerFactory.getLogger(GoogleMatrixService.class);
	
	@Value("${api.matrix.key}")
	private String API_KEY;

	@SuppressWarnings("finally")
	public Long calcularDistancia(Empresa coleta, Empresa entrega) {
		GeoApiContext distCalcer = new GeoApiContext.Builder().apiKey(API_KEY).build();
	   	DistanceMatrixApiRequest req = null; 
	    DistanceMatrix result = null;
	    
		try {
			if((coleta.getEndereco()!=null)&&(entrega.getEndereco()!=null)) {
			
			req = DistanceMatrixApi.newRequest(distCalcer); 
			result = req.origins(coleta.getEndereco().getEnderecoSimplificado())
			           .destinations(entrega.getEndereco().getEnderecoSimplificado())
			           .mode(TravelMode.DRIVING)
			           //.avoid(RouteRestriction.TOLLS)
			           .language("pt-BR")
			           .await();
			return result.rows[0].elements[0].distance.inMeters;
			}else {
				return null;
			}
		} catch (ApiException | InterruptedException | IOException e) {
			logger.error("Não foi possível acessar a API google", e);
		}finally {
			if(result!=null) {
				return result.rows[0].elements[0].distance.inMeters;
			}else {
				return null;
			}
		}
		
	}
}