package com.educacionit.desafio_java_2;

public class Helicoptero extends Volador {
	
	private String nombre;
		
	public Helicoptero(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public boolean puedeAterrizar() {
		return false;
	} 
}