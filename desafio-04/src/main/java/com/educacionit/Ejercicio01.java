package com.educacionit;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero, suma=0, max=0, min=0;
		boolean primerNumero = true;

		do {
			System.out.print("Para Culminar escriba 0, de lo contrario escriba cualquier numero entero: ");
			numero = scanner.nextInt();
			suma += numero;

			if (numero == 0) {
				break;
			}
			//Función por primera vez para guardar max y min. Para no tomar 0 como max y min, y solo utilizarlo para Culminar.
			if (primerNumero == true) {  
				max = numero;
				min = numero;
				primerNumero = false;
			}				
			else {
				if (numero > max) {
				max = numero;
				}			
				else if (numero < min) {
				min = numero;
				}
			}
		} while (numero != 0);
		
		System.out.printf("\nLa suma total es: %d\nEl numero mayor es: %d\nEl numero menor es: %d", suma, max, min);

		scanner.close();
	}
}
