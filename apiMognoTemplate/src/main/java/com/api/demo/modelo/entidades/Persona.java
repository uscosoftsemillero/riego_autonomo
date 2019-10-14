package com.api.demo.modelo.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;

@Document(collection="personas")
public class Persona {
	@Id
	private String id;
	private String identificacionTipo;
	private String numeroIdentificacion;
	private String nombre;
	private String apellido;
	private String celular;
	private String genero;
	private String fechaNacimiento;
	private String correo;
	private String estado;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdentificacionTipo() {
		return identificacionTipo;
	}
	public void setIdentificacionTipo(String identificacionTipo) {
		this.identificacionTipo = identificacionTipo;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Update generadorUpdate() {
		Update update = new Update();
		update.set("nombre",this.nombre);
		update.set("apellido",this.apellido);
		update.set("celular",this.celular);
		update.set("genero",this.genero);
		update.set("fechaNacimiento",this.fechaNacimiento);
		update.set("correo",this.correo);
		update.set("estado",this.estado);
		return update;
	}
	
	
}
