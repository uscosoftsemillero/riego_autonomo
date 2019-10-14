package com.api.demo.modelo.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javassist.expr.NewArray;

@Document(collection="usuario")
public class Usuario {
	@Id
	private String id;
	
	private String password;
	private String persona;
	private String user;
	
	private String estado;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Update generadorUpdate() {
		Update update = new Update();
		update.set("user",this.user);
		update.set("password",new BCryptPasswordEncoder().encode(this.password));
		update.addToSet("estado",this.estado);
		return update;
	}
	
	
/*
	public Update generadorUpdate() {
		Update update = new Update();
		update.set("nombres", this.getNombres());
		update.set("apellidos", this.getApellidos());
		update.set("clave", new BCryptPasswordEncoder().encode(this.getClave()));
		update.set("username", this.getUsername());
		update.set("rol",this.getRol());
		return update;
	}
	*/
}