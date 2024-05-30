package com.educacionit;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		//Resuelvo agregando 0 finaliza
		
		Scanner scanner = new Scanner(System.in);
		int horastotales;
		
		do {
		System.out.print("Introduce cantidad de horas totales (0 finaliza): ");
		horastotales = scanner.nextInt();
		
		if (horastotales < 0) {
			continue;
		
		} if (horastotales > 0) {
			
		int semanas = horastotales / 168;
		int dias =  horastotales % 168 / 24;
		int horas = (horastotales % 168) % 24;
		
		System.out.println();
		System.out.println("Semanas: " + semanas);
		System.out.println("Días: " + dias);
		System.out.println("Horas: " + horas);
		System.out.println();}
		
		}while (horastotales !=0);
		System.out.println("Fin");
				
		scanner.close();
	}	
}
