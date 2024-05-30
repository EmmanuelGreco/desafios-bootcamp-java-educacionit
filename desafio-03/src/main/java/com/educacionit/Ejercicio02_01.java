package com.educacionit;

import java.util.Scanner;

public class Ejercicio02_01 {

	public static void main(String[] args) {
		
		/* Debido a que solo los grados inferiores a 10 tiene dos opciones de tiempo
		hice un programa que solo solicite el tiempo cuando los grados sean menores a 10
		independientemente de que se escriba en mayúsculas o minúsculas */
		
		Scanner scanner = new Scanner(System.in);
		
		float grados;
		String tiempo;
						
		do {
			do {
				System.out.print("Ingrese la temperatura en °: ");
				grados = scanner.nextFloat();
		
				if (grados <=10) {
					continue;
		
				} if (grados > 25) {
					System.out.println("\nHace " + grados + "°. El tiempo es soleado. Se recomienda salir a caminar y tomar sol.\n");
				} else if (grados > 15 && grados <=25) {
					System.out.println("\nHace " + grados + "°. El tiempo es soleado. Se recomienda salir a caminar.\n");
				} else if (grados > 10 && grados <=15) {
					System.out.println("\nHace " + grados + "°. El tiempo es soleado. Se recomienda salir a caminar con campera.\n");
				}
			} while (grados > 10);
		
			System.out.print("Ingrese el tiempo: Sol, Lluvia o Nieve (Cancelar para finalizar): ");
			tiempo = scanner.next();
						
			if (tiempo.equalsIgnoreCase("cancelar")) {
				continue;
			
			} if (tiempo.equalsIgnoreCase("sol")) {
				System.out.println("\nHace " + grados + "°. El tiempo es soleado. Se recomienda salir a caminar con campera gruesa.\n");
			} else if (tiempo.equalsIgnoreCase("lluvia")) {
				System.out.println("\nHace " + grados + "°. El tiempo es lluvioso. Se sugiere quedarse en casa o salir con paraguas y campera.\n");
			} else if (tiempo.equalsIgnoreCase("nieve")) {
				System.out.println("\nHace " + grados + "°. El tiempo es nevado. Se sugiere salir a esquiar.\n");
			} 
		} while (!tiempo.equalsIgnoreCase("cancelar"));
		
		System.out.print("\nFinalizado.");
		
		scanner.close();
	}
}
