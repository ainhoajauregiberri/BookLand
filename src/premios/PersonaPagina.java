package premios;

import java.util.Comparator;

import personas.Persona;
import sqlite.GestionBD;

/**
 * Este es el objeto PersonaPagina que contiene las personas y el n�mero de p�ginas que ha le�do cada una
 * Ser� empleado para crear un array de este tipo y luego ordenarlo por el n�mero de p�ginas le�das
 * @author Ainhoa y Lorea
 */

public class PersonaPagina implements Comparator <PersonaPagina>{

	/**
	 * La persona, con todos los atributos que tiene la clase persona
	 * Los atributos son: nombre, usuario, contrasenya, fecNac y sexo
	 */
	
	private Persona persona;
	
	/**
	 * El n�mero de p�ginas que ha le�do esa persona
	 * Se calcular� sumando el n�mero de p�ginas de cada libro que ha le�do
	 */
	
	private int numPagTotal;
	
	/**
	 * Este es el constructor del objeto
	 * Pasandole la persona que crearemos con la informaci�n de la bd,
	 * Obtendremos el n�mero de p�ginas totales le�das aqu�, haciendo una llamada a la clase GestionBD
	 */
	
	public PersonaPagina(Persona persona) {
		this.persona = persona;
		GestionBD bd = new GestionBD("BookLand.db");
		this.numPagTotal=bd.devolverNumPagTotal(persona);
	}
	
	public PersonaPagina(String nombrePersona,int numPag) {
		this.persona=persona;
		this.numPagTotal=numPag;
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
	 * Haciendo @override de este m�todo, 
	 * le indicamos el criterio con el que queremos que ordene el array
	 * En este caso el criterio es ordenarnos por el n�mero de p�ginas le�das de mayor a menor
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
