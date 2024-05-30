package com.educacionit;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		// Programa que al ingresar una oración no vacía, realiza las siguientres operaciones:
		// Cuenta las palabras.
		// Indica si hay palabras repetidas y muestra el resultado. *(agregado por mí)*
		// Ordena las palabras de forma ascendente y muestra el resultado.
		// Ordena las letras de forma ascendente y muestra el resultado.
		
		Scanner scanner = new Scanner(System.in);
		String cadenaInicial;
		
		do {
			System.out.println("Indique la oración a evaluar (No puede estar vacía): ");
			cadenaInicial = scanner.nextLine();
			String[] cadenaInicialContador = cadenaInicial.trim().split("\\s+"); //Para usar en contador.
			String[] cadenaInicialSort = cadenaInicial.trim().split("\\s+"); //Para usar en sort, ya que contador reemplaza palabras por "".
			cadenaInicial = cadenaInicial.replaceAll("\\s+",""); //Para ignorar TAB y espacio en ciclo do while.
			char[] arraycaracter = cadenaInicial.toCharArray(); //Para usar en sort caracter.
			
			if (cadenaInicial.isEmpty()) {
				continue;
			}
			
			// Contador de palabras.
			System.out.println("La cantidad de palabras que contiene la oración es: " + cadenaInicialContador.length);
			
			// Contador de palabras repetidas.
			boolean palabrasRepetidas = false; // Para imprimir si la palabra no es repetida.
			boolean primerPalabra = false; // Para imprimir a un print diferente.
			for (int i = 0; i < cadenaInicialContador.length; i++) {
				int contar = 1;
				for (int j = i+1; j < cadenaInicialContador.length; j++) {
					if (cadenaInicialContador[i].equals(cadenaInicialContador[j])) {
						contar++;
						cadenaInicialContador[j] = "";		                   
					}
				}
				if (contar > 1 && cadenaInicialContador[i] != "" && primerPalabra == false) {
					System.out.print("Palabras que se repiten:\n[" + cadenaInicialContador[i]);
					primerPalabra = true;
					palabrasRepetidas = true;
				}
				else if (contar > 1 && cadenaInicialContador[i] != "" && primerPalabra == true) {
					System.out.print(", " + cadenaInicialContador[i]);
				}
			} 
			if (palabrasRepetidas == true) {
				System.out.print("]\n");
			}		        
			if (palabrasRepetidas == false) {
				System.out.println("Ninguna palabra se repite.");
			}
			
			// Ordena las palabras.
			Arrays.sort(cadenaInicialSort);
			System.out.println("Palabras ordenadas de forma ascendente:\n" + Arrays.toString(cadenaInicialSort));
			
			// Ordena los caracteres.
			Arrays.sort(arraycaracter);
			System.out.println("Letras ordenadas de forma ascendente:\n" + Arrays.toString(arraycaracter));
								    
		} while (cadenaInicial.isEmpty());
		
		scanner.close();
	}
}
