package premios;

import java.util.ArrayList;

import personas.Persona;
import productos.libros.Editorial;
import sqlite.GestionBD;

public interface IPremios {

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
