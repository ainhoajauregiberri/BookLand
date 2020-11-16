package swing;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import personas.Persona;
import personas.Usuario;
import productos.libros.Autor;
import productos.libros.Genero;
import sqlite.GestionBD;

public interface IListasProductos {

	public static DefaultListModel<Genero> cargarListaGenero() {
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<Genero>generos=bd.devolverGeneros();
		DefaultListModel<Genero>nombreGeneros=new DefaultListModel<Genero>();
		for(int i=0;i<generos.size();i++){
			Genero genero=(Genero)generos.get(i);
			nombreGeneros.addElement(genero);
		}
		return nombreGeneros;
	}
	public static DefaultListModel<Autor> cargarListaAutor() {
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<Autor>autores=bd.devolverAutores();
		DefaultListModel<Autor>nombreAutores=new DefaultListModel<Autor>();
		for(int i=0;i<autores.size();i++){
			Autor autor=(Autor)autores.get(i);
			nombreAutores.addElement(autor);
		}
		return nombreAutores;
	}
	
	public static DefaultListModel<String> cargarListaTitulos() {
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<String>titulos=bd.obtenerTitulos();
		DefaultListModel<String>nombreTitulos=new DefaultListModel<String>();
		for(int i=0;i<titulos.size();i++){
			String titulo=titulos.get(i);
			nombreTitulos.addElement(titulo);
		}
		return nombreTitulos;
	}
	
	public static DefaultListModel<String> cargarListaTitulosPorGenero(Genero genero) {
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<String>titulosPorGenero=bd.obtenerTitulosPorGenero(genero);
		DefaultListModel<String>nombreTitulosPorGenero=new DefaultListModel<String>();
		for(int i=0;i<titulosPorGenero.size();i++){
			String titulo=titulosPorGenero.get(i);
			nombreTitulosPorGenero.addElement(titulo);
		}
		return nombreTitulosPorGenero;
	}
	
	public static DefaultListModel<String> cargarListaTitulosPorAutor(Autor autor) {
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<String>titulosPorAutor=bd.obtenerTitulosPorAutor(autor);
		DefaultListModel<String>nombreTitulosPorAutor=new DefaultListModel<String>();
		for(int i=0;i<titulosPorAutor.size();i++){
			String titulo=titulosPorAutor.get(i);
			nombreTitulosPorAutor.addElement(titulo);
		}
		return nombreTitulosPorAutor;
	}
	
	public static DefaultListModel<String>cargarListaEjemplares(String titulo){
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<String>ejemplares=bd.obtenerEjemplares(titulo);
		DefaultListModel<String>titulosEjemplares=new DefaultListModel<String>();
			for(int i=0;i<ejemplares.size();i++){
				String tituloEjemplar=ejemplares.get(i);
				titulosEjemplares.addElement(tituloEjemplar);
			}
		
		return titulosEjemplares;
	}
	
	public static DefaultListModel<String>cargarListaProductos(Persona persona){
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<String>productos=bd.obtenerProductosUsuario(persona);
		DefaultListModel<String>titulosProductos=new DefaultListModel<String>();
			for(int i=0;i<productos.size();i++){
				String tituloEjemplar=productos.get(i);
				titulosProductos.addElement(tituloEjemplar);
			}
		
		return titulosProductos;
	}
	
	public static DefaultListModel<Persona>cargarListaUsuarios(Persona persona){
		GestionBD bd=new GestionBD("BookLand.db");
		ArrayList<Persona>todosUsuarios=bd.devolverUsuarios();
		DefaultListModel<Persona>nombresPersonas=new DefaultListModel<Persona>();
			for(int i=0;i<nombresPersonas.size();i++){
				Persona nombreUsuario=todosUsuarios.get(i);
				nombresPersonas.addElement(nombreUsuario);
			}
		
		return nombresPersonas;
	}
	
	
}
