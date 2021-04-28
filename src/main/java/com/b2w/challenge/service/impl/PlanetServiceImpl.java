package com.b2w.challenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.challenge.B2WChallengeApplication;
import com.b2w.challenge.model.Planet;
import com.b2w.challenge.repository.PlanetRepository;
import com.b2w.challenge.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {
	
	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public List<Planet> findAll() {
		return this.planetRepository.findAll();
	}

	@Override
	public Planet findById(String id) {
		return this.planetRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Código não encontrado."));
	}

	@Override
	public Planet findByName(String name) {
		return this.planetRepository.findByName(name);
	}

	@Override
	public Planet create(Planet planet) {
		planet.setCountFilms(
			B2WChallengeApplication.planetsList.getBody().getResults()
				.stream()
				.filter(c -> c.getName().equalsIgnoreCase(planet.getName()))
				.collect(Collectors.toList()).get(0).getFilms().size());
		return this.planetRepository.save(planet);
	}

	@Override
	public void remove(String id) {
		this.planetRepository.deleteById(id);
		
	}

}
