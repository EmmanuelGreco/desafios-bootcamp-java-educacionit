package com.educacionit.desafio_java_2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
				
		ArrayList<AterrizableInterface> aeronaves = new ArrayList<AterrizableInterface>();
		Operador operador = new Operador();
		
		Avion Avion1 = new Avion("AR011");
		Avion Avion2 = new Avion("AR02");
		aeronaves.add(Avion1);
		aeronaves.add(Avion2);
		
		Helicoptero Heliceptero1 = new Helicoptero("HR01");
		Helicoptero Heliceptero2 = new Helicoptero("HR01");
		aeronaves.add(Heliceptero1);
		aeronaves.add(Heliceptero2);
		
		aeronaves.add(new Avion("AR03"));
		aeronaves.add(new Helicoptero("HR01"));
		
		TorreDeControl torreDeControl = new TorreDeControl(aeronaves, operador);
		
        torreDeControl.gestionarAterrizaje();
	}
}