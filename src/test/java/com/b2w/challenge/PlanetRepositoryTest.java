package com.b2w.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.b2w.challenge.model.Planet;
import com.b2w.challenge.repository.PlanetRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PlanetRepositoryTest {
	
	@Autowired
	private PlanetRepository planetRepository;
	private Planet planet = new Planet("Name Test", "Climate Test", "Terrain Test", 0);
	
	@Test
	public void shouldReturnAllPlanets() {
		List<Planet> planets = planetRepository.findAll();
		//Desde que exista pelo menos uma Planeta cadastrado no Banco de Dados
		assertThat(planets).isNotNull();
	}
	
	@Test
	public void createShouldPersistData() {
		
		this.planetRepository.save(planet);
		
		assertThat(planet.getId()).isNotNull();
		assertThat(planet.getName()).isEqualTo("Name Test");
		assertThat(planet.getClimate()).isEqualTo("Climate Test");
		assertThat(planet.getTerrain()).isEqualTo("Terrain Test");
		this.planetRepository.deleteById(planet.getId());
	}
	
	@Test
	public void findByNameShouldReturnData() {
		this.planetRepository.save(planet);
		Planet findedByName = this.planetRepository.findByName("Name Test");
		assertThat(findedByName.getName()).isEqualTo("Name Test");
		this.planetRepository.deleteById(findedByName.getId());
	}
	
	@Test
	public void findByIdShouldReturnData() {
		this.planetRepository.save(planet);
		Optional<Planet> findedById = this.planetRepository.findById(planet.getId());
		assertThat(findedById.get().getName()).isEqualTo("Name Test");
		assertThat(findedById.get().getClimate()).isEqualTo("Climate Test");
		assertThat(findedById.get().getTerrain()).isEqualTo("Terrain Test");
		this.planetRepository.deleteById(findedById.get().getId());
		
	}
	
	@Test
	public void deleteShouldRemoveData() {
		this.planetRepository.save(planet);
		this.planetRepository.deleteById(planet.getId());
		Optional<Planet> planetFinded = planetRepository.findById(planet.getId());
		assertThat(planetFinded.isEmpty()).isTrue();	
	}
	
	
	
}
