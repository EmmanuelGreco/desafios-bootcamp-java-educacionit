package com.educacionit.ejercicio02.dao.test;

import java.util.List;
import java.util.Scanner;

import com.educacionit.ejercicio02.dao.PaisDAO;
import com.educacionit.ejercicio02.dao.PaisDAOImpl;
import com.educacionit.ejercicio02.dao.ProvinciaDAO;
import com.educacionit.ejercicio02.dao.ProvinciaDAOImpl;
import com.educacionit.ejercicio02.dao.model.Pais;
import com.educacionit.ejercicio02.dao.model.Provincia;

public class Main {
	
	private static final Scanner teclado = new Scanner(System.in);	

	public static void main(String[] args) {
		
		System.out.println("ADMINISTRADOR DE PROVINCIAS POR PAIS \n=====================================");
		
		try {			

			PaisDAO paisDao = new PaisDAOImpl();
			
			List<Pais> paises= paisDao.obtenerTodos();	
			
			//Selecciona el pais sobre el que quiere operar
			Integer idPais  = seleccionarPais(paises);
			
			//Selecciona la operacion a realizar
			Integer operacion = seleccionarOperacion();
						
			ProvinciaDAO provinciaDao = new ProvinciaDAOImpl();
			
			
			switch (operacion) {
            case 1:
            	{
        		    // Buscar provincia por texto para el pais seleccionado
	            	System.out.println("\nIngrese el texto para la búsqueda de provincias: \n");
	            	String textoBusquedaProvincia = teclado.nextLine();
	            	List<Provincia> provincias = provinciaDao.buscarPorPaisYTexto(idPais, textoBusquedaProvincia);
	        		System.out.println("\nResultado de su búsqueda: \n");
	            	imprimirProvincias(provincias);
            	}
                break;
            case 2:            	
            	{
	                // Agregar una provincia al pais seleccionado
	            	System.out.println("\nIngrese el nombre de la provincia a agregar: \n");
	            	
	            	String nombre= teclado.nextLine();
	            	
	            	Provincia provinciaNueva = new Provincia(idPais,nombre);           	
	            	
	            	try {
	            		provinciaDao.insertar(idPais, provinciaNueva);	            		
	            		System.out.println("La provincia fue agregada correctamente \n"); 
	            	} catch (Exception ex) {
	            		System.out.println(ex.getMessage());
	            	}            	         	
            	}
                break;
            case 3:                
            	{
            		// Modificar una provincia del pais seleccionado
	            	System.out.println("\nListado de provincias: \n");
	            	
	            	List<Provincia> provincias = provinciaDao.obtenerTodas(idPais);
	            	
	            	imprimirProvincias(provincias);
	            	
	            	Integer idProvincia = solicitarEnteroValido("\nIngrese el id de la provincia a modificar: \n");
	            	
	            	System.out.println("Ingrese el nuevo nombre para la provincia: ");           	
	            	
	            	String nuevoNombre= teclado.nextLine();
	            	
	            	Provincia provinciaModidicada = new Provincia(idProvincia, idPais,nuevoNombre);           	
	            	            		
            		try {
	            	
            			provinciaDao.modificar(provinciaModidicada);   
            			System.out.println("La provincia fue modificada correctamente \n");
            			
            		} catch (Exception ex) {            			
            			System.out.println(ex.getMessage());
            		}	            		        	
            	}
            	
                break;
            case 4:
            	{
                	// Eliminar una provincia del pais seleccionado
            		System.out.println("\nListado de provincias: \n");
	            	
	            	List<Provincia> provincias = provinciaDao.obtenerTodas(idPais);
	            	
	            	imprimirProvincias(provincias);
	            	
	            	Integer idProvincia = solicitarEnteroValido("\nIngrese el id de la provincia a modificar: \n");
            		
	            	try {
	            		provinciaDao.eliminar(idProvincia, idPais);
	            		System.out.println("La provincia fue eliminada correctamente \n");
	            	} catch (Exception ex) {
	            		System.out.println(ex.getMessage());
	            	}            		
            	}
                break;
			}		
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
		System.out.println("\nFin del programa. ");
		
		teclado.close();
		
	}	
	
	private static Integer seleccionarPais(List<Pais> paises) {
				
	    for (Pais pais : paises) {
	    	System.out.println(pais);
	    }
	    
		Integer idPais = solicitarEnteroValido("\nIngrese el numéro del país sobre el que desea operar: \n" ); 
		
		while (!existePaisConId(paises, idPais)){
			
			System.out.println("El pais seleccionado no existe. \n");
			
			idPais = solicitarEnteroValido("Ingrese el numéro del país sobre el que desea operar: \n" );			
		}
		
		return idPais;
    }
	
	private static Integer seleccionarOperacion() {
		
		Boolean operacionValida = false;
		Integer operacion;
	    
		do {
		
			System.out.println("\nOperaciones disponibles: \n ");
			
			System.out.println("1. Buscar provincias");
			System.out.println("2. Agregar una provincia");
			System.out.println("3. Modificar una provincia");
			System.out.println("4. Eliminar una provincia");
		
			operacion = solicitarEnteroValido("\nIngrese el numéro de la operación a realizar: \n" ); 
			
			operacionValida = (operacion >=1 && operacion <=4);
			
		} while (!operacionValida);
		
		return operacion;        
    }	
	
	public static void imprimirProvincias(List<Provincia> provincias) {
        		
		for (Provincia provincia : provincias) {
            System.out.println(provincia.getId() + ". " + provincia.getDescripcion());
        }
    }
	
	public static boolean existePaisConId(List<Pais> paises, int idBuscado) {
	    for (Pais pais : paises) {
	        if (pais.getId() == idBuscado) {
	            return true;
	        }
	    }
	    return false;
	}

	private static Integer solicitarEnteroValido(String mensaje) {
		
		boolean numeroValido=false;
		Integer numero=0;
		
		while (!numeroValido) {
			
		    System.out.println(mensaje);
		    
		    if (teclado.hasNextInt()) {
		        numero = teclado.nextInt();
		        numeroValido = true;
		    } else {
		        System.out.println("Error: debe ingresar un número entero.");
		        teclado.next();
		    }		    
		}
		
		teclado.nextLine();		
		return numero;
	}
}
