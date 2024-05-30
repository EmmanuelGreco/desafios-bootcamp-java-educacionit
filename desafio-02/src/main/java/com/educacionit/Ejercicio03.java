package com.educacionit;

public class Ejercicio03 {

	public static void main(String[] args) {

		System.out.println("Dados n1=10, n2=20 y n3=30, informar:\n\nA) El total.\nB) El promedio.\nC) El resto entre n2 y n1.\n\n");
		System.out.println("Respuestas:\n");
		
		int n1 = 10;
		int n2 = 20;
		int n3 = 30;
		
		int total = n1 + n2 + n3;
		int promedio = total / 3;
		int resto = n2 % n1;
		
		System.out.println("A) El total es " + total + ".");
		System.out.println("B) El promedio es " + promedio + ".");
		System.out.println("C) El resto es " + resto + ".");
		
		System.out.println();
				
		// Resuelto utilizando array e incorporando printf
		
		int [] array = {10,20,30};
		int length = array.length;
		int suma = 0;
		
		for (int indice=0; indice<length; indice++) {
			suma = suma + array [indice];}
		System.out.printf("A) El total es %d.\n", suma);
		
		int prom = suma / length;
		System.out.printf("B) El promedio es %d.\n", prom);
		
		int restoarray = array [1] % array [0];
		System.out.printf("C) El resto es %d.", restoarray);
		
	}
}
