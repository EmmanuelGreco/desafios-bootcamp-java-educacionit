package com.educacionit.desafio_java_2;

public class Avion extends Volador {
	
	private String nombre;
	
	public Avion(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public boolean puedeAterrizar() {
		return true;
	}
}