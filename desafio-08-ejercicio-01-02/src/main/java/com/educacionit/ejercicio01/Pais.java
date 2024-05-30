package com.educacionit.ejercicio01;

import java.util.List;

public class Pais {	
	private int id;
	private String descripcion;
    private List<Provincia> provincias;
	
	public Pais(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
	public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

	@Override
	public String toString() {
		return id + ". " + descripcion;
	}
}
