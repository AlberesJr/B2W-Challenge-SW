package com.b2w.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.challenge.model.Planet;
import com.b2w.challenge.service.PlanetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/planets")
@Api(tags = "Planet")
public class PlanetController {
	
	@Autowired
	private PlanetService planetService;
	
	@GetMapping
    @ApiOperation(tags = {"Planet"}, value = "Listar todos Planetas cadastrados")
	public ResponseEntity<List<Planet>> findAll(){
		return ResponseEntity.ok().body(this.planetService.findAll());
	}
	
	@PostMapping
    @ApiOperation(tags = {"Planet"}, value = "Cadastrar um novo Planeta")
	public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) {
		return ResponseEntity.ok().body(this.planetService.create(planet));
	}
	
	@GetMapping("/id")
    @ApiOperation(tags = {"Planet"}, value = "Buscar um Planeta pelo Id")
	public ResponseEntity<Planet> findById(@RequestParam String id){
		return ResponseEntity.ok().body(this.planetService.findById(id));
	}
	
	@GetMapping("/name")
    @ApiOperation(tags = {"Planet"}, value = "Buscar um Planeta pelo Nome")
	public ResponseEntity<Planet> findByName(@RequestParam String name){
		return ResponseEntity.ok().body(this.planetService.findByName(name));
	}
	
	@DeleteMapping
    @ApiOperation(tags = {"Planet"}, value = "Remover um planeta pelo Id")
	public ResponseEntity<Void> removeById(@RequestParam String id){
		this.planetService.remove(id);
		return ResponseEntity.noContent().build();
	}

}
