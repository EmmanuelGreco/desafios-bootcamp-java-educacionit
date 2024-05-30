package com.educacionit.ejercicio01.exception;

public class DBManagerException extends Exception {
	
	/*
	 * Error 1: conectar a la db
	 * Error 2: buscar provincias por pais
	 * Error 3: obtener paises
	 * Error 4: cerrar conexion a la db
	 */
	
	public static final int ERROR_1= 1;
	public static final int ERROR_2= 2;
	public static final int ERROR_3= 3;
	public static final int ERROR_4= 4;

	private Integer error;
	
	public DBManagerException(Integer error, String message) {
		super(message);
		this.error = error;
	}

	public DBManagerException(Integer error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public DBManagerException(Integer error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;
	}

	@Override
	public String getMessage() {
		
		switch (error) {		
		case ERROR_1: 
			return "Se produjo un error conectando a la base de datos: " + super.getMessage();
		case ERROR_2: 
			return "Se produjo un error al buscar provincias por pais: " + super.getMessage();
		case ERROR_3: 
			return "Se produjo un error al obtener los paises: " + super.getMessage();
		case ERROR_4: 
			return "Se produjo un error cerrando la conexión a la base de datos: " + super.getMessage();		
		default:
			return super.getMessage();		
		}		
	}
}
