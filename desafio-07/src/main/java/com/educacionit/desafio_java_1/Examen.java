package com.educacionit.desafio_java_1;

public class Examen {
	private int numExamen;
	private double notaExamen;

	public Examen(int numExamen, double notaExamen) {
		this.numExamen = numExamen;
		this.notaExamen = notaExamen;
	}

	public int getNumExamen() {
		return numExamen;
	}

	public void setNumExamen(int numExamen) {
		this.numExamen = numExamen;
	}

	public double getNotaExamen() {
		return notaExamen;
	}

	public void setNotaExamen(double notaExamen) {
		this.notaExamen = notaExamen;
	}	
}