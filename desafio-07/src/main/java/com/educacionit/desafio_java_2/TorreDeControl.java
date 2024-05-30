package com.educacionit.desafio_java_2;

import java.util.ArrayList;

public class TorreDeControl {
	private Operador operador;
	private ArrayList<AterrizableInterface> voladores;

	public TorreDeControl(ArrayList<AterrizableInterface> voladores, Operador operador) {
		this.voladores = voladores;
		this.operador = operador;
	}

	public void gestionarAterrizaje() {
		for (AterrizableInterface volador : voladores) {
			if (volador.puedeAterrizar()) {
				System.out.println("Puede aterrizar en Pista 1.\n");
			
			} else {
				System.out.println("No cumple contrato para autorizar aterrizaje.");
				System.out.println("Solicitar autorizacion adicional al operador.");
				if (operador.autorizarAterrizaje()) {
					System.out.println("Puede aterrizar en Pista 2.\n");
				
				} else {
					System.out.println("No se autoriza aterrizaje.\n");
				}
			}
		}
	}
}