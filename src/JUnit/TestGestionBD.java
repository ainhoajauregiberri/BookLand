package JUnit;

import static org.junit.Assert.*;


import java.beans.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Action;

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
	private Connection conn;
	private EjemplarLibro ej;
	private Persona p;
	private String url;
	private DatabaseMetaData meta;
	private Statement stmt;
	private Statement stmt2;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSet rs2;

	
	@Before
	public void setUp(){
		url = "jdbc:sqlite:BookLand.db";
		try {
			conn=(Connection) DriverManager.getConnection(url);
			meta= ((java.sql.Connection) conn).getMetaData();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt=(Statement) ((java.sql.Connection) conn).createStatement();
			stmt2=(Statement) ((java.sql.Connection) conn).createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}
		pstmt=null;
		rs=null;
		rs2=null;
		bd = new GestionBD("BookLand.db");
		g = new Genero("Comedia");
		a = new Autor("Roald Dahl");
		ej = new EjemplarLibro(24, "Nur 3");
		p = new Persona("Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica");
	}
	
	@After
	public void tearDown(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt=null;
		pstmt=null;
		rs=null;
		
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
		
		String sql2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='Prueba'";
		
		try {
			rs=((java.sql.Statement) stmt).executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nombre="";
		try {
			nombre = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Hau da konprobatu beharreko lehengoa, si ha creado la tabla
		assertEquals(nombre, "Prueba");
		
		String sql3= "DELETE TABLE IF EXISTS Prueba";
		bd.crearModificarBorrarTabla(sql3);
		
		String sql4 = "SELECT name FROM sqlite_master WHERE type='table' AND name='Prueba'";
		
		
		nombre="";
		try {
			rs2=((java.sql.Statement) stmt2).executeQuery(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			nombre=rs2.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(nombre, "");
				
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
		
		String sql = "SELECT prestado FROM ProductoUsuario WHERE codEjem=24";
		
		try {
			rs=((java.sql.Statement) stmt).executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertTrue(rs.getBoolean(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String sql2 = "DELETE FROM ProductoUsuario WHERE codEjem=24";
		
		
		try {
			stmt2.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testObtenerTitulos(){
		
		ArrayList<String> titulos = bd.obtenerTitulos();

		int tamanyoDeseado=0;
		 String sql="SELECT titulo FROM Producto";
		 
		
		 try {
			 rs=((java.sql.Statement) stmt).executeQuery(sql);
			 int i =0;
			while(rs.next()) {
				 if ((titulos.get(i).equals(rs.getString(1)))){
					 assertTrue(true);
				 }else{
					 assertTrue(false);
					 break;
				 }
				 i++;
			}	
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Honaino ondo zuzenduta
	
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
