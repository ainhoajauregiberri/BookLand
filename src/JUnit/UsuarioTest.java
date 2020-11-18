package JUnit;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Persona;
import personas.Usuario;
import productos.Libro;
import productos.libros.Autor;
import productos.libros.EjemplarLibro;
import productos.libros.Genero;
import servicios.MultasPersona;
import sqlite.GestionBD;

public class UsuarioTest {
	
	private Usuario usuario;

	@Before
	public void setUp(){
		
		usuario = new Usuario("Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica", "2020-09-13", 20.0);
		
	}
	
	@After
	public void tearDown(){
		
		usuario=null;
		
	}
	
	public void testGetDinero(){
		usuario.setDinero(30.0);
		assertEquals(30,0, usuario.getDinero());
		
		//Beste aukera bat
		//if((30.0==usuarios.getDinero())){
		//assertTrue(true);
	//}
		
	}

}
