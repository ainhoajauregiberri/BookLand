package premios;

import java.util.Comparator;

import personas.Persona;
import sqlite.GestionBD;

public class PersonaPaginaEuskera implements Comparator <PersonaPaginaEuskera>{

	private Persona persona;
	private int numPagTotalEuskera;
	
	public PersonaPaginaEuskera(Persona persona) {
		this.persona = persona;
		GestionBD bd = new GestionBD("BookLand.db");
		this.numPagTotalEuskera=bd.devolverNumPagTotalEuskera(persona);
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getNumPagTotalEuskera() {
		return numPagTotalEuskera;
	}

	public void setNumPagTotalEuskera(int numPagTotal) {
		this.numPagTotalEuskera = numPagTotal;
	}

	@Override
	public int compare(PersonaPaginaEuskera pg1, PersonaPaginaEuskera pg2) {
		//Si numero es mayor tiene que ser 0
				//Sino 1
				if(pg1.getNumPagTotalEuskera()>pg2.getNumPagTotalEuskera()) {
					return 0;
				}else {
					return 1;
	}
	}
	}
