package com.b2w.challenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.b2w.challenge.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	public Planet findByName(String name);

}
