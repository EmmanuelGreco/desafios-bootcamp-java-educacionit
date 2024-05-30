package com.educacionit;

import java.util.Scanner;

public class Ejercicio02_02 {

	public static void main(String[] args) {
		
		/*Este programa a diferencia del anterior utiliza
		array de char para convertir el tiempo ingresado
		a minúsculas y poder comparar el string*/
						
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
						
			char [] toLowerCase = new char [tiempo.length()];
			
			for (int contador = 0; contador < tiempo.length(); contador++) {
				char unCaracter = tiempo.charAt(contador);
			
				if (unCaracter >= 'A' && unCaracter <= 'Z') {
					toLowerCase[contador] = (char)(unCaracter +32);
				} else { 
					toLowerCase[contador] = unCaracter;
				}
			}
		
			tiempo = new String (toLowerCase);
			
			if (tiempo.equals("cancelar")) {
				continue;
			
			} if (tiempo.equals("sol")) {
				System.out.println("\nHace " + grados + "°. El tiempo es soleado. Se recomienda salir a caminar con campera gruesa.\n");
			} else if (tiempo.equals("lluvia")) {
				System.out.println("\nHace " + grados + "°. El tiempo es lluvioso. Se sugiere quedarse en casa o salir con paraguas y campera.\n");
			} else if (tiempo.equals("nieve")) {
				System.out.println("\nHace " + grados + "°. El tiempo es nevado. Se sugiere salir a esquiar.\n");
			} 
		} while (!tiempo.equals("cancelar"));
		
		System.out.print("\nFinalizado.");
		
		scanner.close();
	}
}
