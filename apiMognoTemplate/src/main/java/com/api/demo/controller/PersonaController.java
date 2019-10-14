package com.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.demo.modelo.entidades.Persona;

@RestController
@RequestMapping("persona")
public class PersonaController {

	
	@Autowired
	private MongoOperations mongoOps;

	
	@PostMapping("registrar")
	public ResponseEntity<?> registrar(@RequestBody Persona persona){
		mongoOps.insert(persona);
		return ResponseEntity.ok().body("{\"registro\":\"ok\"}");
	}
	
	@GetMapping("mostrar")
	public ResponseEntity<?> mostrar(){
		return ResponseEntity.ok().body(mongoOps.findAll(Persona.class));
	}
	
	@GetMapping("mostrar/{id}")
	public ResponseEntity<?> mostrar(@PathVariable("id") String id){
		return ResponseEntity.ok().body(mongoOps.find(new Query( new Criteria("id").is(id)), Persona.class));
	}
	
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") String id,@RequestBody Persona persona){
		Query query = new Query(new Criteria("id").is(id));
		mongoOps.updateFirst(query, persona.generadorUpdate(), Persona.class);
		return ResponseEntity.ok().body("{\"actualizar\":\"ok\"}");
	}	
}