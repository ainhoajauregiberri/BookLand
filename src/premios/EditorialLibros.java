package premios;

import java.util.Comparator;

import personas.Persona;
import productos.libros.Editorial;
import sqlite.GestionBD;

/**
 * Este es el objeto EditorialLibros que contiene la editorial y el número de libros que han sido prestados
 * Será empleado para crear un array de este tipo y luego ordenarlo por el número de libros que han sido prestados
 * @author Ainhoa y Lorea
 */


public class EditorialLibros implements Comparator <EditorialLibros>{

	/**
	 * La editorial con todos sus atributos de la clase
	 */
	
	private Editorial editorial;
	
	/**
	 * El número de libros que han sido prestados de esa editorial
	 */
	
	private int numLibros;
	
	/**
	 * Este es el constructor del objeto
	 * Pasandole la editorial que crearemos con la información de la bd,
	 * Obtendremos el número de libros prestados aquí, haciendo una llamada a la clase GestionBD
	 */
	
	
	public EditorialLibros(Editorial editorial) {
		this.editorial = editorial;
		GestionBD bd = new GestionBD("BookLand.db");
		this.numLibros=bd.devolverLibrosEditorial(editorial);
	}

	

	public Editorial getEditorial() {
		return editorial;
	}



	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}



	public int getNumLibros() {
		return numLibros;
	}



	public void setNumLibros(int numLibros) {
		this.numLibros = numLibros;
	}


	/**
	 * Haciendo @override de este método, 
	 * le indicamos el criterio con el que queremos que ordene el array
	 * En este caso el criterio es ordenarnos por el número de libros prestados 
	 * de esa editorial en concreto de mayor a menor
	 * 	 */

	@Override
	public int compare(EditorialLibros ed1, EditorialLibros ed2) {
		//Si numero es mayor tiene que ser 0
				//Sino 1
				if(ed1.getNumLibros()>ed2.getNumLibros()) {
					return 0;
				}else {
					return 1;
	}
	}
	}
