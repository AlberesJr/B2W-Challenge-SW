package com.b2w.challenge.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.challenge.B2WChallengeApplication;
import com.b2w.challenge.exception.BadRequestException;
import com.b2w.challenge.exception.ObjectNotFoundException;
import com.b2w.challenge.model.Planet;
import com.b2w.challenge.repository.PlanetRepository;
import com.b2w.challenge.service.PlanetService;
import com.b2w.challenge.util.Util;

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
				.orElseThrow(() -> new ObjectNotFoundException("Planeta não encontrado."));
	}

	@Override
	public Planet findByName(String name) {
		return this.planetRepository.findByName(name);
	}

	@Override
	public Planet create(Planet planet) {
		verifyPlanetFields(planet);
		
		if(Util.planetsList != null) {
			planet.setCountFilms(
					Util.planetsList.getBody().getResults()
					.stream()
					.filter(c -> c.getName().equalsIgnoreCase(planet.getName()))
					.collect(Collectors.toList()).get(0).getFilms().size());
		} else {
			planet.setCountFilms(0);
		}
		
		return this.planetRepository.save(planet);
	}

	@Override
	public void remove(String id) {
		this.planetRepository.findById(id)
			.orElseThrow(() -> new ObjectNotFoundException("Planeta não encontrado."));
		
		this.planetRepository.deleteById(id);
		
	}
	
	private Planet verifyPlanetFields(Planet planet) {
		if (planet.getName() == null || planet.getName().isBlank()) {
			throw new BadRequestException("Nome não pode ser nulo ou vazio");
		} else if (planet.getClimate() == null || planet.getClimate().isBlank()) {
			throw new BadRequestException("Clima não pode ser nulo ou vazio");
		}else if (planet.getTerrain() == null || planet.getTerrain().isBlank()) {
			throw new BadRequestException("Terreno não pode ser nulo ou vazio");
		}
		
		return planet;
	}

}
