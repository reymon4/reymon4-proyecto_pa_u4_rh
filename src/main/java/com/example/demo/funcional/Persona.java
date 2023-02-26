package com.example.demo.funcional;

public class Persona { 
	
	private String apellido;
	private String nombre;
	
	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombre=" + nombre + "]";
	}
	
	///
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
