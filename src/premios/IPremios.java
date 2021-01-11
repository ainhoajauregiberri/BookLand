package premios;

import java.util.ArrayList;

import personas.Persona;
import productos.libros.Editorial;
import sqlite.GestionBD;

/**
 * Esta es la interfaz con los m�todos para crear los arrays que luego deber�n ser ordenados para hacer el ranking
 * @author Ainhoa y Lorea
 */

public interface IPremios {
	
	/**
	 * Este m�todo crear� el array con el objeto PersonaPagina
	 * Este objeto contiene el la persona y el n�mero de p�ginas que ha le�do
	 * @param bd La clase de gesti�n BD, para poder acceder a la base de datos
	 * @return devuelve el array de tipo PersonaPagina
	 */

	public static PersonaPagina[] cargarPersonasPaginas() {
		GestionBD bd = new GestionBD("BookLand.db");
		PersonaPagina[] personaPagina = new PersonaPagina[bd.codigoMaximo()-4];
		ArrayList<Persona>todosUsuarios=bd.devolverUsuarios();
		for(int i=0; i<todosUsuarios.size();i++) {
			PersonaPagina pp= new PersonaPagina(todosUsuarios.get(i));
			personaPagina[i]=pp;
		}
		return personaPagina;
	}
	
	/**
	 * Este m�todo crear� el array con el objeto PersonaPaginaEuskera
	 * Este objeto contiene el la persona y el n�mero de p�ginas que ha le�do en euskera
	 * @param bd La clase de gesti�n BD, para poder acceder a la base de datos
	 * @return devuelve el array de tipo PersonaPaginaEuskera
	 */
	
	public static PersonaPaginaEuskera[] cargarPersonasPaginasEuskera() {
		GestionBD bd = new GestionBD("BookLand.db");
		PersonaPaginaEuskera[] personaPaginaEuskera = new PersonaPaginaEuskera[bd.codigoMaximo()-4];
		ArrayList<Persona>todosUsuarios=bd.devolverUsuarios();
		for(int i=0; i<todosUsuarios.size();i++) {
			PersonaPaginaEuskera ppe= new PersonaPaginaEuskera(todosUsuarios.get(i));
			personaPaginaEuskera[i]=ppe;
		}
		return personaPaginaEuskera;
	}
	
	/**
	 * Este m�todo crear� el array con el objeto EditorialLibros
	 * Este objeto contiene la editorial y las veces que libros de esa editorial que han sido prestados
	 * @param bd La clase de gesti�n BD, para poder acceder a la base de datos
	 * @return devuelve el array de tipo EditorialLibros
	 */
	
	public static EditorialLibros[] cargarEditorialLibros() {
		GestionBD bd = new GestionBD("BookLand.db");
		EditorialLibros[] editorialLibros = new EditorialLibros[2];
		ArrayList<Editorial>todosEditoriales=new ArrayList<Editorial>();
		Editorial ed1 = new Editorial("Planetadelibros");
		Editorial ed2 = new Editorial("Erein");
		todosEditoriales.add(ed1);
		todosEditoriales.add(ed2);
		for(int i=0; i<todosEditoriales.size();i++) {
			EditorialLibros el= new EditorialLibros(todosEditoriales.get(i));
			editorialLibros[i]=el;
		}
		return editorialLibros;
	}
	
	
}
