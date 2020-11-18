package JUnit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.AssertionFailedError;
import personas.Persona;
import productos.libros.EjemplarLibro;
import sqlite.GestionBD;

public class GestionBDTest {

	private GestionBD bd;
	
	
	@Before
	public void setUp() throws Exception {
		bd = new GestionBD("BookLand.db");
	}

	@After
	public void tearDown() throws Exception {
		bd=null;
	}

	@Test
	public void testObetnerCodigoPersona() {
		assertEquals(bd.obtenerCodigoDePersona("ainhoa10"),1);
	}
	
	@Test
	public void testComprobarUsuarioAdministrador() {
		assertEquals(bd.comprobarUsuarioAdminitrador(1), false);
	}
	
	@Test
	public void testObetnerCodigoMaximo() {
		assertEquals(bd.codigoMaximo(),20);
	}
	
	@Test
	public void testPuedePrestar() {
		Persona personaNoPuedePrestar=new Persona("Jon","jon10","kaixo1234", "2000-07-15", "chico");
		Persona personaPuedePrestar=new Persona("Asier", "asier10", "kaixo1234", "1974-09-07", "chico");
		assertFalse(bd.puedePrestar(personaNoPuedePrestar));
		assertTrue(bd.puedePrestar(personaPuedePrestar));
		
	}
	
	@Test
	public void testDevolverUsuario() {
		assertEquals(bd.devolverUsuario(1),"ainhoa10");
	}
	
	@Test
	public void testExisteUsuario() {
		assertTrue(bd.existeUsuario("ainhoa10"));
		assertFalse(bd.existeUsuario("xuban10"));
	}
	
	@Test
	public void testDevolverDate() {
		assertEquals(bd.devolverDate("Sat Jul 10 00:00:00 CET 2000"),"2000-7-10");
	}
	

}
