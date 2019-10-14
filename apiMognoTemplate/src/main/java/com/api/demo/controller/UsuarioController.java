package com.api.demo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.api.demo.modelo.entidades.Usuario;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private MongoOperations mongoOps;

	@GetMapping("saludo")
	public String saludo() {
		return "hola mundo";
	}

	@GetMapping("mostrar")
	public ResponseEntity<?> mostrar() {
		List<Usuario> people = mongoOps.findAll(Usuario.class);
		return ResponseEntity.ok().body(people);
	}

	@GetMapping("mostrar/{id}")
	public ResponseEntity<?> mostrarById(@PathVariable("id") String id) {
		Usuario user = mongoOps.findById(new ObjectId(id), Usuario.class);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("registrar")
	public ResponseEntity<?> registrar(@RequestBody Usuario user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		mongoOps.insert(user);
		return ResponseEntity.ok().body("{\"registro\":\"ok\"}");
	}

	@PutMapping("actualizar/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") String id, @RequestBody Usuario user) {
		Query query = new Query(new Criteria("id").is(id));
		mongoOps.updateFirst(query, user.generadorUpdate(), Usuario.class);
		return ResponseEntity.ok().body("{\"actualizar\":\"ok\"}");
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") String id) {
		mongoOps.remove(new Query(new Criteria("id").is(id)), Usuario.class);
		return ResponseEntity.ok().body("{\"eliminar\":\"ok\"}");
	}
}