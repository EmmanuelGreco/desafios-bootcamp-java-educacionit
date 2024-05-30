package com.educacionit.desafio_java_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		System.out.print("Ingrese la cantidad de alumnos a procesar: ");
		int cantAlumnos = scanner.nextInt();
				
		for (int i = 0; i < cantAlumnos; i++) {
			System.out.print("\nIngrese el nombre del alumno Nº" + (i+1) + ": ");
			String nombre = scanner.next();
			System.out.print("Ingrese el apellido del alumno Nº" + (i+1) + ": ");
			String apellido = scanner.next();
			
			Alumno alumno = new Alumno(nombre, apellido);
			int numExamen;
			double notaExamen;
						
			do {
				System.out.print("Ingrese el número de examen (0 para finalizar): ");
				numExamen = scanner.nextInt();
				
				if (numExamen == 0) {
					break;
					
				} else { 
						do {
							System.out.print("Ingrese la nota del examen Nª" + numExamen + " numérico >=0 <=10: ");
							notaExamen = scanner.nextDouble();
							if (notaExamen < 0 || notaExamen >10) {
								System.out.print("La nota debe ser un valor numérico >=0 <=10!\n");
						
							} else { Examen examen = new Examen(numExamen, notaExamen);
									alumno.agregarExamen(examen);
									}						
						
						} while (notaExamen < 0 || notaExamen > 10);								
					}
			} while (numExamen !=0);
			alumnos.add(alumno);
			
		}
		
		calificacionAlta(alumnos);
		calificacionBaja(alumnos);
			
		obtenerPromocionan(alumnos);
		obtenerRecursan(alumnos);
	
		scanner.close();
				
	}
	private static void calificacionAlta(ArrayList<Alumno> alumnos) {
		double notaMasAlta = -1;
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNotaExamen() > notaMasAlta) {
		        	notaMasAlta = examen.getNotaExamen();
		        }
		    }
		}		
		
		System.out.print("\nAlumno/s con la calificación más alta son:\n");		
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNotaExamen() == notaMasAlta) {
		        	System.out.println(alumno.getNombre() + " " + alumno.getApellido());
		        }
		    }		  
		}	
		System.out.print("La calificación mas alta fue: " + notaMasAlta +  "\n");
	}
	
	private static void calificacionBaja(ArrayList<Alumno> alumnos) {
		double notaMasBaja = 11;
		
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNotaExamen() < notaMasBaja) {
		        	notaMasBaja = examen.getNotaExamen();
		        }
		    }
		}	
		
		System.out.println("\nAlumno/s con la calificación más baja son:");
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNotaExamen() == notaMasBaja) {
		        	System.out.println(alumno.getNombre() + " " + alumno.getApellido());
		        }
		    }
		}
		System.out.print("La calificación más baja fue: " + notaMasBaja + "\n");
	}

	private static void obtenerPromocionan(ArrayList<Alumno> alumnos) {
		System.out.println("\nAlumno/s que promocionan con promedio >= 7 son:");
		for (Alumno alumno : alumnos) {
		   if (alumno.getPromedio() >= 7) {
			   System.out.format("%s %s, con promedio: %.2f%n", alumno.getNombre(), alumno.getApellido(), alumno.getPromedio());
		   }
		}		
	}
	
	private static void obtenerRecursan(ArrayList<Alumno> alumnos) {
		System.out.println("\nAlumno/s que deben recursan con promedio <7 son:");
		for (Alumno alumno : alumnos) {
		   if (alumno.getPromedio() < 7) {
			   System.out.format("%s %s, con promedio: %.2f%n", alumno.getNombre(), alumno.getApellido(), alumno.getPromedio());
		   }
		}			
	}
}