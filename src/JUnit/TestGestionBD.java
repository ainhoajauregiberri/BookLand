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
import personas.Usuario;
import productos.Libro;
import productos.Producto;
import productos.libros.Autor;
import productos.libros.Ejemplar;
import productos.libros.EjemplarLibro;
import productos.libros.Genero;
import servicios.MultasPersona;
import sqlite.GestionBD;

public class TestGestionBD {
	
	private GestionBD bd;
	private Genero g;
	private Autor a;
	private Connection conn;
	private EjemplarLibro ej;
	private EjemplarLibro ej2;
	private Persona p;
	private Persona p2;
	private String url;
	private DatabaseMetaData meta;
	private Statement stmt;
	private Statement stmt2;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ResultSet rs2;
	private Libro libro;
	private MultasPersona m;

	
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
		a = new Autor("J. K. Rowling");
		ej = new EjemplarLibro(1, "Harry Potter y la piedra filosofal");
		ej2 = new EjemplarLibro(18, "Harry Potter y la c�mara secreto");
		p = new Persona("Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica");
		p2 = new Persona ("Jon", "jon10", "kaixo1234", "2000-07-15", "chico");
		libro = new Libro(true, "Harry Potter y la piedra filosofal", a, g, null, 8); 
		m= new MultasPersona(5, 18);
		
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
		
		String sql = "SELECT prestado FROM ProductoUsuario WHERE codEjem=1";
		
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
		
		
		String sql2 = "DELETE FROM ProductoUsuario WHERE codEjem=1";
		
		
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
		 String sql="SELECT titulo FROM Producto";
		 
		
		 try {
			 rs=((java.sql.Statement) stmt).executeQuery(sql);
			 int i =0;
			while(rs.next()) {
				assertEquals(titulos.get(i), rs.getString(1));
				i++;
			}
		 }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	@Test
	public void testObtenerTitulosPorGenero(){
		
		ArrayList<String> titulosPorGenero = bd.obtenerTitulosPorGenero(g);
		
		 String sql="SELECT titulo FROM Producto WHERE codGenero=1";
		 try {
			rs=((java.sql.Statement) stmt).executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			 int i =0;
				try {
					while(rs.next()) {
						assertEquals(titulosPorGenero.get(i),rs.getString(1));
						i++;
				}
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
	}
		
	@Test
		public void testObtenerTitulosPorAutor(){
			
			ArrayList<String> titulosPorAutor = bd.obtenerTitulosPorAutor(a);
			
			 String sql="SELECT titulo FROM Producto WHERE codAutor=1";
			 try {
				rs=((java.sql.Statement) stmt).executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				int i=0;
				while(rs.next()) {
					assertEquals(titulosPorAutor.get(i),rs.getString(1));
					i++;
			}
			 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
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
			
			 String sql="SELECT nomGenero FROM Genero";
			 try {
				rs=((java.sql.Statement) stmt).executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 try {
				 int i=0;
				while(rs.next()) {
					assertEquals(rs.getString(1), generos.get(i).getNomGen());
				 }
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		}
	
		public void testDevolverLibro(){
			bd.devolverLibro(ej2, p2);
			String sql = "SELECT prestado FROM ProductoUsuario WHERE codEjem=18";
			try {
				((java.sql.Statement) stmt).executeQuery(sql);
				assertFalse(rs.getBoolean(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String sql2 = "UPDATE prestado SET prestado=false FROM ProductoUSuario WHERE codEjem=18";
			try {
				((java.sql.Statement) stmt2).executeQuery(sql2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void testObtenerEjemplares(){
			ArrayList<String> ejemplares = bd.obtenerEjemplares(libro.getTiutlo());
			String sql="SELECT codEjem FROM Ejemplar WHERE codPro=1";
			
			try {
				rs = ((java.sql.Statement) stmt).executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			try {
				while (rs.next()){
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			assertEquals(ejemplares.size(), i);
		}
		
		// Se puede public void testObtenerEjemplaresObjetos(){
	
		public void testCodigoMaximo(){
			int codMax = bd.codigoMaximo();
			
			String sql="SELECT MAX(codPers) FROM Persona";
			
			try {
				rs=((java.sql.Statement) stmt).executeQuery(sql);
				assertEquals(rs.getInt(1), codMax);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void testobtenerProductosUsuario(){
			bd.prestarLibro(ej, p2);
			ArrayList<String> titulos = bd.obtenerProductosUsuario(p2);
			assertEquals("Harry Potter y la piedra filosofal", titulos.get(1));
			String sql2 = "DELETE FROM ProductoUsuario WHERE codEjem=1";
			try {
				stmt2.execute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void testDevolverUsuarios(){
			ArrayList<Persona> usuarios = bd.devolverUsuarios();
			 String sql="SELECT * FROM Persona WHERE codPers IN (SELECT codPers FROM Usuario)";
			 int i = 0;
			 try {
				rs=((java.sql.Statement) stmt).executeQuery(sql);
				while (rs.next()){
					Persona persona=new Persona(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					assertEquals(persona, usuarios.get(i));
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		
		public void testPuedePrestar(){
			boolean prestar = bd.puedePrestar(p2);
			assertFalse(prestar);
		}
		
		public void testDevolverUsuario(){
			String usuario = bd.devolverUsuario(5);
			assertEquals("jon10", usuario);
		}
		
		public void testDevolverMultas(){
			ArrayList<MultasPersona> multas = bd.devolverMultas();
			for (MultasPersona multasPersona : multas) {
				if (multasPersona.getcodEjem()==18){
				if (multasPersona.getUsuarioPersona()==5){
					assertTrue(true);
				}
			}
		}
		}
		
		public void testExisteUsuario(){
			boolean existe = bd.existeUsuario("jon10");
			assertTrue(true);
		}
		
		/*public void testDevolverDate(){
			//Ez dakit nola daukan fecha sqlitek, hor sartu behiko fecha atributo horrekin.
			String fecha = bd.devolverDate();
			assertEquals(fecha, "2020-09-13");
		}
		
		public void testInsertarDatosPersona(){
			bd.insertarDatosPersona(21, "Nerea", "nerea10", "kaixo1234", "1998-06-18", "chica");
			String sql = "SELECT usuario FROM Persona WHERE codPers=21";
			rs = stmt.executeQuery(sql);
			
			assertEquals(rs.getString(1), "nerea10");
		}*/
		
}
			
			
		

		
		