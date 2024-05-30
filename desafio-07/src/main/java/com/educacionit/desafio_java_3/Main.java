package com.educacionit.desafio_java_3;

import com.educacionit.desafio_java_3.CollectionException.CollectionException;

public class Main {

	public static void main(String[] args) throws CollectionException {
		
		CollectionCustom<Integer> coleccion = new CollectionCustom<>(1);

		System.out.println("Tamaño: " + coleccion.size());
		
		coleccion.addFirst(1);
		coleccion.add(2);
		coleccion.add(3);
		coleccion.add(4);
		coleccion.addLast(5);

		System.out.println("Tamaño: " + coleccion.size());

		Integer remover = coleccion.remove(5);
		System.out.println("Elemento removido: " + remover);
		
		System.out.println("Tamaño: " + coleccion.size());
		
		try {
			remover = coleccion.remove(5); // Ya fue removido

		} catch (CollectionException e) {
			System.out.println(e.getMessage());
		}

		if (coleccion.empty()) {
			System.out.println("La coleccion está vacía.");
		} else {
			System.out.println("La coleccion no está vacía.");
		}
		
		try {
			coleccion.removeAll();

		} catch (CollectionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Tamaño: " + coleccion.size());
		
		if (coleccion.empty()) {
			System.out.println("La coleccion está vacía.");
		} else {
			System.out.println("La coleccion no está vacía.");
		}
	}
}