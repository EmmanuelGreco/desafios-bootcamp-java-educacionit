package com.educacionit.ejercicio02.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.ejercicio02.dao.ds.ConnectionDB;
import com.educacionit.ejercicio02.dao.model.Pais;
import com.educacionit.ejercicio02.exception.DBManagerException;

public class PaisDAOImpl implements PaisDAO, ConnectionDB {

	@Override
	public List<Pais> obtenerTodos() throws DBManagerException {
		
		List<Pais> paises = new ArrayList<>();        
	    String query = "SELECT id, descripcion FROM paises";

	    try (
	    	
	    	Connection conn = getConnection();
	    	Statement statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(query)) {
	    	
	        while (resultSet.next()) {
	            Integer id = resultSet.getInt("id");
	            String descripcion = resultSet.getString("descripcion");
	            Pais pais = new Pais(id, descripcion);
	            paises.add(pais);
	        }        

	        if (paises.isEmpty()) {
	            throw new DBManagerException(DBManagerException.ERROR_3, "No se encontraron países en la base de datos.");
	        }
	    } catch(SQLException ex) {  
	        throw new DBManagerException(DBManagerException.ERROR_3, "No se pudo obtener paises por la siguiente razón: " + ex.getMessage(), ex);
	    }   
	    return paises;		
		
	}
}
