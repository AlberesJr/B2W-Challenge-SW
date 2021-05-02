package com.b2w.challenge.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.b2w.challenge.exception.ServiceUnavailableException;
import com.b2w.challenge.model.ResultApiSW;

@Service
public class SWApiServiceImpl {
	
	private RestTemplate rest = new RestTemplate();
	private UriComponents uri;
	private ResponseEntity<ResultApiSW> aux = null, entity = null;
	
	public ResponseEntity<ResultApiSW> makeSWApiRequest(){
		try {
			uri = UriComponentsBuilder
					.newInstance()
					.scheme("https")
					.host("swapi.dev")
					.path("/api/planets/")
					.build();
			
			
			
			entity = rest.getForEntity(uri.toUriString(), ResultApiSW.class);
			aux = entity;
			
			while (aux.getBody().getNext() != null) {
				uri = UriComponentsBuilder
						.newInstance()
						.scheme("https")
						.host("swapi.dev")
						.path("/api/planets/")
						.queryParam("page", aux.getBody().getNext()
												.substring(aux.getBody()
												.getNext().length() - 1))
						.build();
				
				aux = rest.getForEntity(uri.toUriString(), ResultApiSW.class);
				entity.getBody().getResults().addAll(aux.getBody().getResults());
			}
		} catch (ServiceUnavailableException e) {
			throw new ServiceUnavailableException("Star Wars Api unavailable.");
		}
		return entity;
	}
		
}