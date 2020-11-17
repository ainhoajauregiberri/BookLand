package JUnit;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Persona;
import productos.libros.Autor;
import productos.libros.Ejemplar;
import productos.libros.EjemplarLibro;
import productos.libros.Genero;
import sqlite.GestionBD;

public class TestGestionBD {
	
	private GestionBD bd;
	private Genero g;
	private Autor a;
	private EjemplarLibro ej;
	private Persona p;

	
	@Before
	public void setUp(){
		
		bd = new GestionBD("BookLand.db");
		g = new Genero("Comedia");
		a = new Autor("Roald Dahl");
		ej = new EjemplarLibro(24, "Nur 3");
		p = new Persona("Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica");
		
	}
	
	@After
	public void tearDown(){
		
	}
	@Test
	public void testEstablecerConexion() {
		bd.establecerConexion();
		assertNotNull(bd.getConn());
	}
	@Test
	public void testCreateDB(){
		bd.createDB();
		String url = bd.getUrl();
		File aFile = new File(url);
		assertTrue(aFile.exists());
		
	}
	@Test
	public void testCrearModificarBorrarTabla (){
		String sql = "CREATE TABLE IF NOT EXISTS Prueba (\n"
					+"codPrueba integer PRIMARY KEY,\n"
					+ ");";
		bd.crearModificarBorrarTabla(sql);
		bd.establecerConexion();
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
		String nombre="";
		try {
			nombre = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		assertEquals(nombre, "Prueba");
		
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
		nombre="";
		try {
			rs2=((java.sql.Statement) stmt2).executeQuery(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		try {
			nombre=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
			e.printStackTrace();
		}
		
		assertEquals(nombre, "");
		
		bd.cerrarConexion(bd.getConn());
				
	}
	@Test
	public void testSeleccionarDatosPersona(){
		HashMap<String, Persona>personas = bd.seleccionarDatosPersona();
		assertEquals(personas.get("ainhoa10").toString(), "ainhoa10");
	}
	@Test
	public void testObtenerCodigoDePersona(){
		int codPers = bd.obtenerCodigoDePersona("unai10");
		assertEquals(16, codPers);
	}
	@Test
	public void testPrestarLibro(){
		
		bd.prestarLibro(ej, p);
		bd.establecerConexion();
		
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
		
		
		String sql2 = "DELETE FROM ProductoUsuario WHERE codEjem=24";
		
		Statement stmt2=null;
		try {
			stmt2=(Statement) (bd.getConn()).createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt2.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 bd.cerrarConexion(bd.getConn());
		
	}
	@Test
	public void testObtenerTitulos(){
		
		
		ArrayList<String> titulos = bd.obtenerTitulos();

		int tamanyoDeseado=0;
		
		bd.establecerConexion();
		
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT titulo FROM Producto";
		 try {
			stmt=(Statement) bd.getConn().createStatement();
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
			while(rs.next()) {
				 tamanyoDeseado+=1;
				 if (rs.getString(1).equals("Nur 3")){
					 assertTrue(true);
				 } 
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 assertEquals(tamanyoDeseado, titulos.size());
		 bd.cerrarConexion(bd.getConn());
		
	}
	@Test
	public void testObtenerTitulosPorGenero(){
		
		ArrayList<String> titulosPorGenero = bd.obtenerTitulosPorGenero(g);
		bd.establecerConexion();
		
		int tamanyoDeseado=0;
		
		bd.establecerConexion();
		
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT titulo FROM Producto WHERE codGenero=1";
		 try {
			stmt=(Statement) bd.getConn().createStatement();
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
			while(rs.next()) {
				 tamanyoDeseado+=1;
				 if (rs.getString(1).equals("Los 5")){
					 assertTrue(true);
			 }
		}
		 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 assertEquals(tamanyoDeseado, titulosPorGenero.size());
		 bd.cerrarConexion(bd.getConn());
		
		 }
		
	@Test
		public void testObtenerTitulosPorAutor(){
			
			ArrayList<String> titulosPorAutor = bd.obtenerTitulosPorAutor(a);
			bd.establecerConexion();
			
			int tamanyoDeseado=0;
			
			bd.establecerConexion();
			
			 Statement stmt=null;
			 ResultSet rs=null;
			 String sql="SELECT titulo FROM Producto WHERE codAutor=3";
			 try {
				stmt=(Statement) bd.getConn().createStatement();
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
				while(rs.next()) {
					 tamanyoDeseado+=1;
					 if (rs.getString(1).equals("Matilda")){
						 assertTrue(true);
				 }
			}
			 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 assertEquals(tamanyoDeseado, titulosPorAutor.size());
			 bd.cerrarConexion(bd.getConn());
			
			 }
	@Test
		public void testComprobarUsuarioAdminitrador(){
			boolean esUsuario = bd.comprobarUsuarioAdminitrador(10);
			assertTrue(esUsuario);
			boolean esAdmin = bd.comprobarUsuarioAdminitrador(1);
			assertFalse(esAdmin);
	}
	@Test
		public void testDevolverGeneros() {
			ArrayList<Genero> generos = bd.devolverGeneros();
			
			bd.establecerConexion();
			
			int tamanyoDeseado=0;
			
			bd.establecerConexion();
			
			 Statement stmt=null;
			 ResultSet rs=null;
			 String sql="SELECT codGenero,nomGenero FROM Genero WHERE codGenero=1";
			 try {
				stmt=(Statement) bd.getConn().createStatement();
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
				while(rs.next()) {
					 tamanyoDeseado+=1;
					 if (rs.getString(1).equals("Comedia")){
						 assertTrue(true);
				 }
			}
			 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 assertEquals(tamanyoDeseado, generos.size());
			 bd.cerrarConexion(bd.getConn());
			
			 
			
		}
	
	
}
