package com.exemplo.sislog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.sislog.model.Trajeto;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;



@RestController
@RequestMapping("/google")
@CrossOrigin(origins = "*")
public class GoogleMatrix {

	@Value("${api.matrix.key}")
	private String API_KEY;

	@PostMapping("/distancia")
	@ResponseBody
	public String obterDistancia(@RequestBody Trajeto trajeto) throws IOException, ApiException, InterruptedException {
		GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey(API_KEY)
			    .build();
	   	
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins(trajeto.getEnderecoOrigem().getEnderecoSimplificado())
	               .destinations(trajeto.getEnderecoDestino().getEnderecoSimplificado())
	               .mode(TravelMode.DRIVING)
	               //.avoid(RouteRestriction.TOLLS)
	               .language("pt-BR")
	               .await();
	       
				String distApart =String.valueOf(result.rows[0].elements[0].distance.inMeters);
				
		return distApart;
		
	}
}