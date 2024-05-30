package com.educacionit;

import java.util.Scanner;

public class Ejercicio01_01 {

	public static void main(String[] args) {

		/* Este programa identifica si el usuario o la contraseña
	 	por separados son incorrectos*/
		
		Scanner scanner = new Scanner(System.in);
		
		String usuario;
		String usuario1 = "Emma";
		String contraseña;
		String contraseña1 = "1234";
		
		do {
			do {
				System.out.print("Ingrese el usuario: ");
				usuario = scanner.next();
			
				if (usuario.equals(usuario1)){
					continue;
		
				} if (!usuario.equals(usuario1)){
					System.out.println("\nUsuario Incorrecto.\n");
				}
			} while (!usuario.equals(usuario1));
			
			System.out.print("Ingrese la contraseña: ");
			contraseña = scanner.next();
			
			if (contraseña.equals(contraseña1)){
				continue;
	
			} if (!contraseña.equals(contraseña1)){
				System.out.println("\nContraseña Incorrecta.\n");
			}
		} while (!contraseña.equals(contraseña1));
		
		System.out.print("\nBienvenido al sistema!");
		
		scanner.close();
	}
}
