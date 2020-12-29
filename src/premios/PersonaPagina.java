package premios;

import java.util.Comparator;

import personas.Persona;
import sqlite.GestionBD;

public class PersonaPagina implements Comparator <PersonaPagina>{

	private Persona persona;
	private int numPagTotal;
	
	public PersonaPagina(Persona persona) {
		this.persona = persona;
		GestionBD bd = new GestionBD("BookLand.db");
		this.numPagTotal=bd.devolverNumPagTotal(persona);
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getNumPagTotal() {
		return numPagTotal;
	}

	public void setNumPagTotal(int numPagTotal) {
		this.numPagTotal = numPagTotal;
	}

	@Override
	public int compare(PersonaPagina pg1, PersonaPagina pg2) {
		//Si numero es mayor tiene que ser 0
				//Sino 1
				if(pg1.getNumPagTotal()>pg2.getNumPagTotal()) {
					return 0;
				}else {
					return 1;
	}
	}
	}
