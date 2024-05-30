package com.educacionit.desafio_java_2;

import java.util.Scanner;

public class Operador {
	Scanner scanner = new Scanner(System.in);
    public boolean autorizarAterrizaje() {
    	        
        boolean autorizar = false;
        System.out.println("¿Autorizar aterrizaje en la Pista 2? Indique SI o NO:");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("SI")) {
        	autorizar = true;
        
        } else if (opcion.equalsIgnoreCase("NO")) {
        	autorizar = false;
        }
        
        return autorizar;
    }
}	