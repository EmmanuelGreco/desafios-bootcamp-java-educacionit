package com.educacionit;

public class Ejercicio02 {

	public static void main(String[] args) {

		System.out.println("Dados n1=5, n2=10 y n3=20, informar:\n\nA) n1 + n2\nB) n3 - n1\nC) n1 * n3\nD) n3 / n2\n\n");
		System.out.println("Respuestas:\n");
		
		int n1 = 5;
		int n2 = 10;
		int n3 = 20;
		
		int suma = n1 + n2;
		int resta = n3 - n1;
		int multiplicacion = n1 * n3;
		int division = n3 / n2;
		
		System.out.println("A) La suma de " + n1 + " más " + n2 + " da como resultado " + suma + ".");
		System.out.println("B) La resta de " + n3 + " menos " + n1 + " da como resultado " + resta + ".");
		System.out.println("C) La multiplicación de " + n1 + " por " + n3 + " da como resultado " + multiplicacion + ".");
		System.out.println("D) La división de " + n3 + " dividido " + n2 + " da como resultado " + division + ".");
		
		System.out.println();
		
		// Resuelto utilizando Math class y utilizando diferente formato de output
		
		int sumado = Math.addExact(n1,n2);
		int restado = Math.subtractExact(n3,n1);
		int multiplicado = Math.multiplyExact(n1, n3);
		int dividido = Math.divideExact(n3,n2);
		
		System.out.println("A) " + n1 + " + " + n2 + " = " + sumado);
		System.out.println("B) " + n3 + " - " + n1 + " = " + restado);
		System.out.println("C) " + n1 + " * " + n3 + " = " + multiplicado);
		System.out.println("D) " + n3 + " / " + n2 + " = " + dividido);
		
		System.out.println();
		
		System.out.println("A) n1 + n2 = " + sumado);
		System.out.println("B) n3 - n1 = " + restado);
		System.out.println("C) n1 * n3 = " + multiplicado);
		System.out.println("D) n3 / n2 = " + dividido);
		
		// Incorporando printf
		
		System.out.printf("\n");
		
		System.out.printf("A) %d + %d = %d\n", n1, n2, sumado);
		System.out.printf("B) %d - %d = %d\n", n3, n1, restado);
		System.out.printf("C) %d * %d = %d\n", n1, n3, multiplicado);
		System.out.printf("D) %d / %d = %d", n3, n2, dividido);
			
	}
}
