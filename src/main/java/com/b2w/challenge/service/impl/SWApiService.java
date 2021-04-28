package com.b2w.challenge.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.b2w.challenge.model.ResultApiSW;

@Service
public class SWApiService {
	
	private RestTemplate rest = new RestTemplate();
	
	public ResponseEntity<ResultApiSW> makeRequest(){
				
		UriComponents uri = UriComponentsBuilder
				.newInstance()
				.scheme("https")
				.host("swapi.dev")
				.path("/api/planets/")
				.build();
		
		ResponseEntity<ResultApiSW> entity = rest.getForEntity(uri.toUriString(), ResultApiSW.class);
		
		return findSWApiPageables(entity);
	}
	
	private ResponseEntity<ResultApiSW> findSWApiPageables(ResponseEntity<ResultApiSW> entity){
		
		ResponseEntity<ResultApiSW> aux = entity;
		
		while (aux.getBody().getNext() != null) {
			UriComponents uri = UriComponentsBuilder
					.newInstance()
					.scheme("https")
					.host("swapi.dev")
					.path("/api/planets/")
					.queryParam("page", aux.getBody().getNext().substring(aux.getBody().getNext().length() - 1))
					.build();
			
			aux = rest.getForEntity(uri.toUriString(), ResultApiSW.class);
			entity.getBody().getResults().addAll(aux.getBody().getResults());
			
		}
		
		return entity;
	}
	
}