package com.educacionit.ejercicio02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.ejercicio02.dao.ds.ConnectionDB;
import com.educacionit.ejercicio02.dao.model.Provincia;
import com.educacionit.ejercicio02.exception.DBManagerException;

public class ProvinciaDAOImpl implements ProvinciaDAO, ConnectionDB {

	@Override
	public List<Provincia> buscarPorPaisYTexto(Integer idPais, String textoProvincia) throws DBManagerException {
		List<Provincia> provincias = new ArrayList<>();
	    String query = "SELECT p.id AS pais_id, pr.descripcion AS provincia_descripcion, pr.id AS provincia_id "
	            + "FROM paises p "
	            + "JOIN provincias pr ON p.id = pr.pais_id "
	            + "WHERE p.id = ? AND pr.descripcion LIKE ?";

	    try (
	    		Connection conn = getConnection();
	    		PreparedStatement statement = conn.prepareStatement(query)
	    	) {
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

	@Override
	public List<Provincia> obtenerTodas(Integer idPais) throws DBManagerException {
		List<Provincia> provincias = new ArrayList<>();
	    String query = "SELECT p.id AS pais_id, pr.descripcion AS provincia_descripcion, pr.id AS provincia_id "
	            + "FROM paises p "
	            + "JOIN provincias pr ON p.id = pr.pais_id "
	            + "WHERE p.id = ?";

	    try (
	    		Connection conn = getConnection();
	    		PreparedStatement statement = conn.prepareStatement(query)
	    	) {
	        statement.setInt(1, idPais);

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

	@Override
	public void insertar(Integer idPais, Provincia provincia) throws DBManagerException {
		
		//TODO: deberia chequear si existe la provincia con la descripcion para el pais antes de insertar
		
		String query = "INSERT INTO provincias (pais_id, descripcion) VALUES (?,?)";
		
		try (		
				Connection conn = getConnection();
				PreparedStatement statement= conn.prepareStatement(query);
			) {
			
			statement.setInt(1, idPais);
			statement.setString(2, provincia.getDescripcion());
			
			int rowsAffected =statement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_4,"No se pudo insertar la provincia " + provincia.getDescripcion());
			} 			
			
		} catch (SQLException ex) {			
			throw new DBManagerException(DBManagerException.ERROR_4,"No se pudo insertar la provincia " + provincia.getDescripcion());
		}
	}

	@Override
	public void modificar(Provincia provincia) throws DBManagerException {
		
		//TODO: deberia chequear si ya existe la provincia con la nueva descripcion antes de modificar
		
		String query = "UPDATE provincias SET descripcion= ? WHERE id = ? AND pais_id = ?";
		
		try (		
				Connection conn = getConnection();
				PreparedStatement statement= conn.prepareStatement(query);
			) {
			
			statement.setString(1, provincia.getDescripcion());
			statement.setInt(2, provincia.getId());
			statement.setInt(3, provincia.getIdPais());
			
			int rowsAffected =statement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_5,"No se pudo modificar la provincia " + provincia.getDescripcion());
			} 			
			
		} catch (SQLException ex) {			
			throw new DBManagerException(DBManagerException.ERROR_5,"No se pudo modificar la provincia " + provincia.getDescripcion());
		}
	}

	@Override
	public void eliminar(Integer id, Integer idPais) throws DBManagerException {

		String query = "DELETE FROM provincias WHERE id = ? AND pais_id = ?";
		
		try (		
				Connection conn = getConnection();
				PreparedStatement statement= conn.prepareStatement(query);
			) {
			
			statement.setInt(1, id);
			statement.setInt(2,idPais);
			
			int rowsAffected =statement.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_6,"No se pudo eliminar la provincia con id " + id);
			} 			
			
		} catch (SQLException ex) {			
			throw new DBManagerException(DBManagerException.ERROR_6,"No se pudo eliminar la provincia con id " + id);
		}		
	}
}
