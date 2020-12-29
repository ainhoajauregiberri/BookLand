package premios;

import java.util.Comparator;

import personas.Persona;
import productos.libros.Editorial;
import sqlite.GestionBD;

public class EditorialLibros implements Comparator <EditorialLibros>{

	private Editorial editorial;
	private int numLibros;
	
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
