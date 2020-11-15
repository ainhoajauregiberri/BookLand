package swing;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

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
	
	
}
