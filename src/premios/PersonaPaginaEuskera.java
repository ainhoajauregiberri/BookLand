package premios;

import java.util.Comparator;

import personas.Persona;
import sqlite.GestionBD;

/**
 * Este es el objeto PersonaPaginaEuskera que contiene las personas y el número de páginas que ha leído cada una en euskera
 * Será empleado para crear un array de este tipo y luego ordenarlo por el número de páginas leídas
 * @author Ainhoa y Lorea
 */

public class PersonaPaginaEuskera implements Comparator <PersonaPaginaEuskera>{

	/**
	 * La persona, con todos los atributos que tiene la clase persona
	 * Los atributos son: nombre, usuario, contrasenya, fecNac y sexo
	 */
	
	private Persona persona;
	
	/**
	 * El número de páginas que ha leído esa persona en euskera
	 * Se calculará sumando el número de páginas de cada libro en euskera que ha leído
	 */
	
	private int numPagTotalEuskera;
	
	/**
	 * Este es el constructor del objeto
	 * Pasandole la persona que crearemos con la información de la bd,
	 * Obtendremos el número de páginas totales leídas en euskera aquí, haciendo una llamada a la clase GestionBD
	 */
	
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

	
	/**
	 * Haciendo @override de este método, 
	 * le indicamos el criterio con el que queremos que ordene el array
	 * En este caso el criterio es ordenarnos por el número de páginas leídas en euskera de mayor a menor
	 */
	
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
