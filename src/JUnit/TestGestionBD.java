package JUnit;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.corba.se.pept.transport.Connection;

import personas.Persona;
import productos.libros.Ejemplar;
import productos.libros.EjemplarLibro;
import sqlite.GestionBD;

public class TestGestionBD {
	
	private GestionBD bd;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void setUp(){
		
		bd = new GestionBD("BookLand.db");
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	public void testEstablecerConexion() {
		bd.establecerConexion();
		assertNotNull(bd.getConn());
	}
	
	public void testCreateDB(){
		bd.createDB();
		String url = bd.getUrl();
		File aFile = new File(url);
		assertTrue(aFile.exists());
		
	}
	
	public void testCrearModificarBorrarTabla (){
		String sql = "CREATE TABLE IF NOT EXISTS Prueba (\n"
					+"codPrueba integer PRIMARY KEY,\n"
					+ ");";
		bd.crearModificarBorrarTabla(sql);
		ResultSet rs=null;
		
		String sql2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='Prueba'";
		Statement stmt=null;
		try {
			stmt=(Statement) (bd.getConn()).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=((java.sql.Statement) stmt).executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		try {
			rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		String sql3= "DELETE TABLE IF EXISTS Prueba";
		bd.crearModificarBorrarTabla(sql3);
		
		ResultSet rs2 = null;
		String sql4 = "SELECT name FROM sqlite_master WHERE type='table' AND name='Prueba'";
		Statement stmt2=null;
		try {
			stmt2=(Statement) (bd.getConn()).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs2=((java.sql.Statement) stmt2).executeQuery(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		try {
			rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		bd.cerrarConexion(bd.getConn());
				
	}
	
	public void testSeleccionarDatosPersona(){
		HashMap<String, Persona>personas = bd.seleccionarDatosPersona();
		assertEquals(personas.get("ainhoa10").toString(), "ainhoa10");
	}
	
	public void testObtenerCodigoDePersona(){
		int codPers = bd.obtenerCodigoDePersona("unai10");
		assertEquals(16, codPers);
	}
	
	public void testPrestarLibro(){
		EjemplarLibro ej = new EjemplarLibro(24, "Nur 3");
		Persona p = new Persona("Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica");
		bd.prestarLibro(ej, p);
		
		String sql = "SELECT prestado FROM ProductoUsuario WHERE codEjem=24";
		Statement stmt=null;
		ResultSet rs = null;
		try {
			stmt=(Statement) (bd.getConn()).createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs=((java.sql.Statement) stmt).executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals(rs.getBoolean(1), true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void testObtenerTitulos(){
		
		
	}
	
}
