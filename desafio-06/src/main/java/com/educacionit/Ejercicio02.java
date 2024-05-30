package com.educacionit;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		double numA, numB;
		
		System.out.print("Ingrese un número a: ");
		numA = scanner.nextDouble();
		System.out.print("Ingrese un número b: ");
		numB = scanner.nextDouble();
		
		char operacion = caracterOperacion(scanner);
		
		operaciones(numA, numB, operacion);
				
		System.out.print("\nFinalizado.");
		
		scanner.close();
		
		}
		
		private static void operaciones(double numA, double numB, char operacion) {
		
		switch (operacion) {
			case '+':
				System.out.println(numA + " + " + numB + " = " + sumar(numA, numB));
				break;
			case '-':
				System.out.println(numA + " - " + numB + " = " + restar(numA, numB));
				break;
			case '*':
				System.out.println(numA + " * " + numB + " = " + multiplicar(numA, numB));
				break;
			case '/':
				if (numB == 0) {
					System.out.println("Operación inválida. No se puede dividir por 0 (cero).");
					break;
				} else {
					System.out.printf("%.2f / %.2f = %.2f\n", numA, numB, dividir(numA, numB)); // Utilizando printf
					break;
				}
			case '%':
				if (numB == 0) {
					System.out.println("Operación inválida. No se puede calcular el resto de la división por 0 (cero).");
					break;
				} else {
					System.out.printf("%.2f %% %.2f = %.2f\n", numA, numB, resto(numA, numB)); // Utilizando printf
					break;
				}
			}
		}
		
		private static char caracterOperacion(Scanner scanner) {
			
			char operacion;	
			
			do {
				System.out.print("Ingrese la operación que desea realizar [+, -, *, /, %]: ");	
			operacion = scanner.next().charAt(0);
			
			} while (operacion != '+' && operacion != '-' && operacion != '*' && operacion != '/' && operacion != '%');
			// Solo permite ingresar la operacion indicada
			
			return operacion;
		}
	
		private static double sumar(double numA, double numB) {
			return numA + numB;
		}

		private static double restar(double numA, double numB) {
			return numA - numB;
		}

		private static double multiplicar(double numA, double numB) {
			return numA * numB;
		}

		private static double dividir(double numA, double numB) {
			return numA / numB;
		}

		private static double resto(double numA, double numB) {
			return numA % numB;
		}
	}
