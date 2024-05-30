package com.educacionit.ejercicio01;

public class Provincia {
	private Integer id;
	private Integer idPais;
	private String descripcion;
	
	public Provincia(Integer idPais, String descripcion) {
		this.idPais = idPais;
		this.descripcion = descripcion;
	}
	
	public Provincia(Integer id, Integer idPais, String descripcion) {
		this.id = id;
		this.idPais = idPais;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
