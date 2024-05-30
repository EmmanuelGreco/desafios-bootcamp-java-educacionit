package com.educacionit.desafio_java_1;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private String apellido;
	private ArrayList<Examen> examenes;

	public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.examenes = new ArrayList<Examen>();
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

	public ArrayList<Examen> getExamenes() {
		return examenes;
	}

	public void agregarExamen(Examen examen) {
		this.examenes.add(examen);
	}

	public double getPromedio() {
		double sumatotal = 0;
		for (Examen examen : this.examenes) {
			sumatotal += examen.getNotaExamen();
		}

		return (sumatotal / this.examenes.size());
	}
}