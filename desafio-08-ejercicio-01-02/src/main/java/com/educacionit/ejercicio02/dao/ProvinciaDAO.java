package com.educacionit.ejercicio02.dao;

import java.util.List;

import com.educacionit.ejercicio02.dao.model.Provincia;
import com.educacionit.ejercicio02.exception.DBManagerException;

public interface ProvinciaDAO {
	
	List<Provincia> buscarPorPaisYTexto(Integer idPais, String textoProvincia) throws DBManagerException;
	
	List<Provincia> obtenerTodas(Integer idPais) throws DBManagerException;
	
	void insertar(Integer idPais, Provincia provincia) throws DBManagerException;
	
	void modificar(Provincia provincia) throws DBManagerException;
	
	void eliminar(Integer id, Integer idPais) throws DBManagerException;	
}
