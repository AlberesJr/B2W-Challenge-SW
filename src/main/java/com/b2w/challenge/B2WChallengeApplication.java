package com.b2w.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.b2w.challenge.service.impl.SWApiServiceImpl;
import com.b2w.challenge.util.Util;

@SpringBootApplication
@EnableScheduling
public class B2WChallengeApplication implements CommandLineRunner{
	
	@Autowired
	private SWApiServiceImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(B2WChallengeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Util.planetsList = service.makeSWApiRequest();
	}

}
