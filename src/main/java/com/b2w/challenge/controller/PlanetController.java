package com.b2w.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.challenge.model.Planet;
import com.b2w.challenge.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired
	private PlanetService planetService;
	
	@GetMapping
	public ResponseEntity<List<Planet>> findAll(){
		return ResponseEntity.ok().body(this.planetService.findAll());
	}
	
	@PostMapping 
	public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
		return ResponseEntity.ok().body(this.planetService.create(planet));
	}
	
	@GetMapping("/id")
	public ResponseEntity<Planet> findById(@RequestParam String id){
		return ResponseEntity.ok().body(this.planetService.findById(id));
	}
	
	@GetMapping("/name")
	public ResponseEntity<Planet> findByName(@RequestParam String name){
		return ResponseEntity.ok().body(this.planetService.findByName(name));
	}
	
	@DeleteMapping
	public ResponseEntity<Void> removeById(@RequestParam String id){
		this.planetService.remove(id);
		return ResponseEntity.noContent().build();
	}

}
