package com.educacionit.ejercicio01;

import java.util.List;
import java.util.Scanner;

import com.educacionit.ejercicio01.exception.DBManagerException;

public class Main {

	public static void main(String[] args) {

		System.out.println("BUSCADOR DE PROVINCIAS POR PAIS \n===============================");
		DBManager dbmanager = new DBManager();
		
		try {		
			
			dbmanager.conectar();
			
			List<Pais> paises= dbmanager.obtenerPaises();
			
			imprimirMenuPaises(paises);
			
			Scanner scanner = new Scanner(System.in);
			
			boolean paisValido = false;
			
			do {
				
				 int idPais = solicitarEnteroValido(scanner, "\nIngrese el código numérico del país en que desea buscar: \n" ); 
				
				 if (existePaisConId(paises, idPais)) {
			         
			        System.out.println("\nIngrese el texto para la búsqueda de provincias: \n");
			         
			        String textoBusquedaProvincia = scanner.next();
			         
			        List<Provincia> provincias = dbmanager.buscarProvinciasPorPais(idPais, textoBusquedaProvincia);
					
					imprimirProvincias(provincias);
					       
			        paisValido=true;
			         
			     } else {
			         System.out.println("\nEl código de país ingresado no es válido.\n");
			     }
				
			} while (!paisValido);
			
			dbmanager.cerrarConexion();
			
		} catch (DBManagerException ex) {
			
			System.out.println(ex.getMessage());			
		}		
	}
	
	public static void imprimirMenuPaises(List<Pais> paises) {
		
		System.out.println("\nListado de países disponibles \n--------------------------------\n");
		
	    for (Pais pais : paises) {
	    	System.out.println(pais);
	    }        
    }
	
	public static void imprimirProvincias(List<Provincia> provincias) {
        
		System.out.println("\nResultado de su búsqueda: \n");
		
		for (Provincia provincia : provincias) {
            System.out.println(provincia.getDescripcion());
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

	private static int solicitarEnteroValido(Scanner teclado, String mensaje) {
		
		boolean numeroValido=false;
		int numero=0;
		
		while (!numeroValido) {
			
		    System.out.println(mensaje);
		    
		    if (teclado.hasNextInt()) {
		        numero = teclado.nextInt();
		        numeroValido = true;
		    } else {
		        System.out.println("Error: Ingrese un número entero válido.");
		        teclado.next();
		    }
		    
		}		
		teclado.nextLine();
		
		return numero;
	}
}
