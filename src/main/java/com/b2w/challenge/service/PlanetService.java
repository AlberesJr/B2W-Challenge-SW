package com.b2w.challenge.service;

import java.util.List;

import com.b2w.challenge.model.Planet;

public interface PlanetService {
	
	public List<Planet> findAll();
	
	public Planet findById(String id);
	
	public Planet findByName(String name);
	
	public Planet create(Planet planet);
	
	public void remove(String id);
	
}
