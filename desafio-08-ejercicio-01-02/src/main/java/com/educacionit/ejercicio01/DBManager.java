package com.educacionit.ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.ejercicio01.exception.DBManagerException;

public class DBManager {
	
	private Connection conn;
	
	private static final String DBURL = "jdbc:mysql://localhost/desafio_08";
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "admin";
	
	public void conectar() throws DBManagerException{
		try {
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (SQLException ex) {
			throw new DBManagerException(DBManagerException.ERROR_1, "No se pudo conectar con la base de datos", ex);
		}
	}	
	
	public List<Provincia> buscarProvinciasPorPais(Integer idPais, String textoProvincia) throws DBManagerException {
	    
		List<Provincia> provincias = new ArrayList<>();
	    String query = "SELECT p.id AS pais_id, pr.descripcion AS provincia_descripcion, pr.id AS provincia_id "
	            + "FROM paises p "
	            + "JOIN provincias pr ON p.id = pr.pais_id "
	            + "WHERE p.id = ? AND pr.descripcion LIKE ?";

	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, idPais);
	        statement.setString(2, "%" + textoProvincia + "%");

	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                Integer provinciaId = resultSet.getInt("provincia_id");
	                Integer paisId = resultSet.getInt("pais_id");
	                String provinciaDescripcion = resultSet.getString("provincia_descripcion");
	                Provincia provincia = new Provincia(provinciaId, paisId, provinciaDescripcion);
	                provincias.add(provincia);
	            }
	        }

	        if (provincias.isEmpty()) {
	            throw new DBManagerException(DBManagerException.ERROR_2, "No se encontraron provincias para el país indicado.");
	        }

	    } catch (SQLException ex) {
	        throw new DBManagerException(DBManagerException.ERROR_2, "No se pudo realizar la consulta de provincias por la siguiente razón: " + ex.getMessage(), ex);
	    }

	    return provincias;
	}	
	
	public List<Pais> obtenerPaises() throws DBManagerException {
	    List<Pais> paises = new ArrayList<>();        
	    String query = "SELECT id, descripcion FROM paises";

	    try (Statement statement = conn.createStatement();
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
	
	public void cerrarConexion() throws DBManagerException{
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new DBManagerException(DBManagerException.ERROR_4,"No se pudo cerrar la conexión : " + ex.getMessage(), ex);
		}
	}
}
