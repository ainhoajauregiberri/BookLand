package premios;

import java.util.Comparator;

import personas.Persona;
import sqlite.GestionBD;

/**
 * Este es el objeto PersonaPagina que contiene las personas y el número de páginas que ha leído cada una
 * Será empleado para crear un array de este tipo y luego ordenarlo por el número de páginas leídas
 * @author Ainhoa y Lorea
 */

public class PersonaPagina implements Comparator <PersonaPagina>{

	/**
	 * La persona, con todos los atributos que tiene la clase persona
	 * Los atributos son: nombre, usuario, contrasenya, fecNac y sexo
	 */
	
	private Persona persona;
	
	/**
	 * El número de páginas que ha leído esa persona
	 * Se calculará sumando el número de páginas de cada libro que ha leído
	 */
	
	private int numPagTotal;
	
	/**
	 * Este es el constructor del objeto
	 * Pasandole la persona que crearemos con la información de la bd,
	 * Obtendremos el número de páginas totales leídas aquí, haciendo una llamada a la clase GestionBD
	 */
	
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

	
	/**
	 * Haciendo @override de este método, 
	 * le indicamos el criterio con el que queremos que ordene el array
	 * En este caso el criterio es ordenarnos por el número de páginas leídas de mayor a menor
	 */
	
	
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
