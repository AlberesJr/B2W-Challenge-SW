package com.b2w.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.b2w.challenge.model.ResultApiSW;
import com.b2w.challenge.service.impl.SWApiService;


@SpringBootApplication
public class B2WChallengeApplication implements CommandLineRunner{
	
	@Autowired
	private SWApiService service;
	
	public static ResponseEntity<ResultApiSW> planetsList;

	public static void main(String[] args) {
		SpringApplication.run(B2WChallengeApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		planetsList = service.makeRequest();
	}

}
