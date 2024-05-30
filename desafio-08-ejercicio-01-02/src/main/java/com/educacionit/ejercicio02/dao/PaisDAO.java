package com.educacionit.ejercicio02.dao;

import java.util.List;

import com.educacionit.ejercicio02.dao.model.Pais;
import com.educacionit.ejercicio02.exception.DBManagerException;

public interface PaisDAO {
	
	List<Pais> obtenerTodos() throws DBManagerException;

}
