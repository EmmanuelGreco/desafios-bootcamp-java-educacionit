package com.educacionit;

import java.util.Scanner;

public class Ejercicio01_02 {

	public static void main(String[] args) {

		/* Este programa a diferencia del anterior no indica que es lo incorrecto,
		se podría considerar más seguro, ya que con el otro programa podes ir
		adivinando el usuario y solo resta la contraseña*/
		
		Scanner scanner = new Scanner(System.in);
		
		String usuario;
		String usuario1 = "Emma";
		String contraseña;
		String contraseña1 = "1234";
		
		do {
			System.out.print("Ingrese el usuario: ");
			usuario = scanner.next();
			
			System.out.print("Ingrese la contraseña: ");
			contraseña = scanner.next();
			
			if (usuario.equals(usuario1) && contraseña.equals(contraseña1)){
				continue;
		
			} if (!usuario.equals(usuario1) || !contraseña.equals(contraseña1)){
				System.out.println("\nCredenciales incorrectas.\n");
		}
			
			/*if (usuario.equals(usuario1) && contrasena.equals(contrasena1)) {
				System.out.print("\nBienvenido al sistema!");
			break;
			}else
			System.out.println("\nCredenciales incorrectas.\n");*/
			
		} while (!usuario.equals(usuario1) || !contraseña.equals(contraseña1));
		
		System.out.print("\nBienvenido al sistema!");
		
		scanner.close();
	}

}
