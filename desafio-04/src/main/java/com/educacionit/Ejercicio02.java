package com.educacionit;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {		
		//Programa que muestra cuál es el carácter que más se repite, dándole prioridad al primer carácter si varios lo cumplen.

		Scanner scanner = new Scanner(System.in);
		String oracion;
		char [] caracter;
		int mayorRepeticion = 0;
		char caracterMasRepetido = 0; //null
		char letraActual = 0; //null
		
		do {
			System.out.println("Indique la oración a evaluar (No puede estar vacía): ");
			oracion = scanner.nextLine();
			oracion = oracion.replace(" ",""); //Para ignorar espacio.
			oracion = oracion.replace("\t",""); //Para ignorar TAB.
			caracter = oracion.toCharArray();
						
		    for(int i=0; i<caracter.length; i++){
		    	
		        letraActual = caracter[i];
		        int contador = 0;
		        
		        if (caracterMasRepetido != letraActual) {
		        for (int j =0; j<caracter.length; j++){
		            if (caracter[j] == letraActual)
		                contador++;
		        	}
		        	if(mayorRepeticion < contador) {		        	
		        		mayorRepeticion = contador;
		        		caracterMasRepetido = letraActual;
		        	}
		        }
		    }
		} while (oracion.isEmpty());
		
		System.out.println("\nEl caracter [" + caracterMasRepetido + "] se repite " + mayorRepeticion + " veces.");
		
		scanner.close();
	}
}
