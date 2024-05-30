package com.educacionit.desafio_java_3;

import com.educacionit.desafio_java_3.CollectionException.CollectionException;

public class CollectionCustom<T> {

	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public CollectionCustom(int capacidad) {
		this.array = (T[]) new Object[capacidad];
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	public void addFirst(T elemento) {
		if (this.size == this.array.length) {
			T[] coleccionAgrandar = (T[]) new Object[array.length + 1];
			System.arraycopy(this.array, 0, coleccionAgrandar, 1, this.size);
			this.array = coleccionAgrandar;
		} else {
			System.arraycopy(array, 0, array, 1, this.size);
		}

		array[0] = elemento;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public void addLast(T elemento) {
		if (this.size == this.array.length) {
			T[] coleccionAgrandar = (T[]) new Object[this.array.length + 1];
			System.arraycopy(this.array, 0, coleccionAgrandar, 0, this.size);
			this.array = coleccionAgrandar;
		}
		this.array[this.size] = elemento;
		size++;
	}

	public void add(T elemento) {
		this.addLast(elemento);
	}

	public T remove(T elemento) throws CollectionException {
		int indice = -1;
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(elemento)) {
				indice = i;
				break;
			}
		}

		if (indice == -1) {
			throw new CollectionException("El elemento no existe!");
		}

		for (int i = indice; i < this.size - 1; i++) {
			this.array[i] = this.array[i + 1];
		}

		this.size--;
		return elemento;
	}

	public void removeAll() throws CollectionException {
		for (int i = 0; i < this.size; i++) {
		
			this.size = 0;
		}
	}

	public boolean empty() {
		return this.size == 0;
	}
}
