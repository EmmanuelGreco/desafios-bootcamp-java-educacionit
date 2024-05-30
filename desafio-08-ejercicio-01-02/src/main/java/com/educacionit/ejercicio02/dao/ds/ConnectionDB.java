package com.educacionit.ejercicio02.dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionit.ejercicio02.exception.DBManagerException;

public interface ConnectionDB {	
	
	default Connection getConnection() throws DBManagerException {
		try {
			
			final String DBURL = "jdbc:mysql://localhost/desafio_08";
		    final String DBUSER = "root";
		    final String DBPASSWORD = "admin";
		    
			Connection conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			
			return conn;		
		
		} catch (SQLException ex) {			
			throw new DBManagerException(DBManagerException.ERROR_1, "No se pudo conectar a la base de datos", ex);			
		}
	}
}
