package sqlite;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import personas.Persona;
import personas.Usuario;
import productos.Producto;
import productos.libros.Autor;
import productos.libros.Editorial;
import productos.libros.Ejemplar;
import productos.libros.EjemplarLibro;
import productos.libros.Genero;
import servicios.MultasPersona;
import servicios.ProductoUsuario;
import swing.LibrosDisponibles;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * Esta es la clase que gestiona todo lo relativo a sqlite
 */

public class GestionBD {
	
	private String nombreFichero;
	private String url="jdbc:sqlite:" + nombreFichero;
	private Connection conn;
	private SimpleDateFormat formatoFec;
	private HashMap<String,Persona>personas;
	private ArrayList<Genero>generos;
	private ArrayList<Autor>autores;
	private ArrayList<String>titulos;
	private ArrayList<String>titulosPorGenero;
	private ArrayList<String>titulosPorAutor;
	private ArrayList<String>ejemplares;
	private ArrayList<String> productosUsuario;
	private ArrayList<Persona>todosUsuarios;
	private ArrayList<EjemplarLibro>ejemplaresTotales;
	private ArrayList<MultasPersona>todasMultas;
	private ArrayList<EjemplarLibro>ejemplarUsuario;

	
	/**
	 * Este es el constructior de la clase
	 */
	public GestionBD(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		this.url = "jdbc:sqlite:" + nombreFichero;
		this.conn = null;
		this.personas=new HashMap<String,Persona>();
		this.generos=new ArrayList<Genero>();
		this.autores=new ArrayList<Autor>();
		this.titulos=new ArrayList<String>();
		this.titulosPorGenero=new ArrayList<String>();
		this.titulosPorAutor=new ArrayList<String>();
		this.ejemplares=new ArrayList<String>();
		this.productosUsuario=new ArrayList<String>();
		this.todosUsuarios=new ArrayList<Persona>();
		this.ejemplaresTotales=new ArrayList<EjemplarLibro>();
		this.todasMultas=new ArrayList<MultasPersona>();
		this.ejemplarUsuario=new ArrayList<EjemplarLibro>();
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public SimpleDateFormat getFormatoFec() {
		return formatoFec;
	}

	public void setFormatoFec(SimpleDateFormat formatoFec) {
		this.formatoFec = formatoFec;
	}

	public void establecerConexion(){
		
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createDB() {
		
		establecerConexion();
		
		if (conn != null)
        {
			
            DatabaseMetaData meta = null;
			try {
				meta = conn.getMetaData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				System.out.println("El nombre driver es: " + meta.getDriverName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Se ha creado una nueva base de datos.");
            cerrarConexion(conn);
	}
	}
	
	 public void crearModificarBorrarTabla(String sql){
		 
		 establecerConexion();
		 Statement stmt = null;
		 try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 try {
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la accion en la tabla");
		 
	 }
	 
	 public HashMap<String,Persona> seleccionarDatosPersona() {
		 establecerConexion();
		 Statement stmt = null;
		 String sql="SELECT codPers, nombre, usuario, contrasenya, fecNac, sexo FROM Persona";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				
				Persona p=new Persona(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				personas.put(rs.getString(3), p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 
		 
		 return personas;
	 }
	 
	 public int obtenerCodigoDePersona(String usuario) {
		 establecerConexion();
		 String sql="SELECT codPers FROM Persona WHERE usuario=?";
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 int codPers = 0;
		 try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstmt.setString(1, usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 codPers=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		return codPers;
	 }
	 
	 
	 public void prestarLibro(int ejemplarLibro, Persona persona){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 String fecFin;
		 
		 String sql = "INSERT INTO ProductoUsuario(codPers, codEjem, fecIni,fecFin, prestado) VALUES(?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
			pstmt.setInt(2, ejemplarLibro);
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date fecIni = new Date(System.currentTimeMillis());
			String stringfecIni=fecIni.toString();
			String[] arrayStringFecIni=stringfecIni.split("-");
			if(Integer.parseInt(arrayStringFecIni[1])==12) {
				fecFin=(arrayStringFecIni[0]+1).toString()+"-"+"01"+"-"+arrayStringFecIni[2].toString();
			}else {
				fecFin=arrayStringFecIni[0].toString()+"-"+(arrayStringFecIni[1]+1).toString()+"-"+arrayStringFecIni[2].toString();
						
			}
			java.util.Date fecInisql = string2Date("yyyy-MM-dd", stringfecIni);
			java.util.Date fecFinsql = string2Date("yyyy-MM-dd", fecFin);
			
			pstmt.setString(3, fecInisql.toString());
			pstmt.setString(4, fecFinsql.toString());
			pstmt.setBoolean(5, true);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla ProductoUsuario");
	 }
	 
	
	 
	 public ArrayList<String> obtenerTitulos() {
		 establecerConexion();
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT titulo FROM Producto";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(rs.next()) {
				 titulos.add(rs.getString(1));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return titulos;
	 }
	 
	 public ArrayList<String> obtenerTitulosPorGenero(Genero genero){
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="SELECT titulo FROM Producto WHERE codGenero IN (SELECT codGenero FROM Genero WHERE nomGenero=?)";
		 try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstmt.setString(1, genero.getNomGen());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				titulosPorGenero.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return titulosPorGenero;
	 }
	 
	 public ArrayList<String> obtenerTitulosPorAutor(Autor autor){
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="SELECT titulo FROM Producto WHERE codAutor IN (SELECT codAutor FROM Autor WHERE nomAutor=?)";
		 try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstmt.setString(1, autor.getNombre());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				titulosPorAutor.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return titulosPorAutor;
	 }
	 
	 //public void prestarLibro(Ejemplar ejemplar, Usuario usuario) {
		// insertarDatosProductoUsuario(obtenerCodigoDePersona(usuario.getUsuario()), ejemplar.getCodEjem(), utilDate.getTime(), StringFecFin, prestado);
	 //}
	 
	 public boolean comprobarUsuarioAdminitrador(int codPers) {
		 establecerConexion();
		 Statement stmt=null;
		 boolean esUsuario=false;
		 String sql="SELECT codPers FROM Usuario";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 if(rs.getInt(1)==codPers) {
					 esUsuario=true;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 cerrarConexion(conn);
		 return esUsuario;
	 }
	 
	 public ArrayList<Genero> devolverGeneros(){
		 establecerConexion();
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT codGenero,nomGenero FROM Genero";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(rs.next()) {
				 Genero genero=new Genero(rs.getString(2));
				 generos.add(genero);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return generos;
	 }
	 
	 public void devolverLibro(EjemplarLibro ejemplarLibro, Persona persona) {
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="UPDATE ProductoUsuario SET fecFin=?, prestado=? WHERE codPers=? AND codEjem=?";
		 try {
			 pstmt=conn.prepareStatement(sql);
			 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			 Date date = new Date(System.currentTimeMillis());
			 java.util.Date fecFinActualizado = string2Date("yyyy-MM-dd", date.toString());
			 pstmt.setString(1, fecFinActualizado.toString());
			 pstmt.setBoolean(2, false);
			 pstmt.setInt(3,obtenerCodigoDePersona(persona.getUsuario()));
			 pstmt.setInt(4, ejemplarLibro.getCodEjem());
			 pstmt.executeUpdate();
			 cerrarConexion(conn);
			 System.out.println("Se ha devuelto el libro");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 
		
	 }
	 
	 public int devolverNumPagTotal(Persona persona) {
		 establecerConexion();
		 int numPag=0;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT numPag FROM Ejemplar WHERE codEjem IN(SELECT codEjem FROM ProductoUsuario WHERE codPers=?)";
		 try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				numPag= numPag+rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return numPag;
	 }
	 
	 public int devolverNumPagTotalEuskera(Persona persona) {
		 establecerConexion();
		 int numPagEuskera=0;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT numPag FROM Ejemplar WHERE codEjem IN(SELECT codEjem FROM ProductoUsuario WHERE codPers=?)AND codIdioma=?";
		 try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
			pstmt.setInt(2, 1);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				numPagEuskera= numPagEuskera+rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return numPagEuskera;
	 }
	 
	 public int devolverLibrosEditorial(Editorial editorial) {
		 establecerConexion();
		 int numLibros=0;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT codEjem FROM ProductoUsuario WHERE codEjem IN(SELECT codEjem FROM Ejemplar WHERE codEditorial=?)";
		 try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,obtenerCodigoEditorial(editorial));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				numLibros+=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return numLibros;
	 }
	 
	 public int obtenerCodigoEditorial(Editorial editorial) {
		 establecerConexion();
		 int codEditorial=0;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql = "SELECT codEditorial FROM Editorial WHERE nomEditorial=?";
		 try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, editorial.getNomEditorial());
			rs= pstmt.executeQuery();
			while(rs.next()) {
				codEditorial=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return codEditorial;
	 }
	 
	 public ArrayList<Autor> devolverAutores(){
		 establecerConexion();
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT codAutor,nomAutor FROM Autor";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(rs.next()) {
				 Autor autor=new Autor(rs.getString(2));
				 autores.add(autor);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return autores;
	 }
	 
	 public ArrayList<Integer> obtenerCodigoEjemplares(String titulo){
		 ArrayList<Integer>codEjemplares=new ArrayList<Integer>();
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 ResultSet rs= null;
		 String sql="SELECT codEjem FROM Ejemplar WHERE codPro IN(SELECT codPro from Producto WHERE titulo=?)";
		 try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, titulo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				codEjemplares.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return codEjemplares;
	 }
	 //Saca los NO DISPONIBLES
	 public ArrayList<Integer> obtenerCodigoEjemplaresDisponiblesTotales(){
		ArrayList<Integer>codEjemplaresDisponibles=new ArrayList<Integer>();
		establecerConexion();
		PreparedStatement pstmt= null;
		String sql="SELECT codEjem FROM ProductoUsuario WHERE prestado=?";
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				codEjemplaresDisponibles.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 //Saca los NO DISPONIBLES
		 return codEjemplaresDisponibles;
	 }
	 
	 public boolean libroDisponible(ArrayList<Integer>todosLosEjemplares,ArrayList<Integer>ejemplaresNoDisponibles) {
		 boolean libroDisponible=true;
		 int numerosRepetidos=0;
		 for(int i=0;i<=todosLosEjemplares.size()-1;i++) {
			 for(int j=0;j<=ejemplaresNoDisponibles.size()-1;j++) {
				 if(todosLosEjemplares.get(i)==ejemplaresNoDisponibles.get(j)) {
					numerosRepetidos+=1;
					 break;
				 }
			 }
		 }
		 if(todosLosEjemplares.size()==numerosRepetidos) {
			 libroDisponible=false;
		 }
		 
		 return libroDisponible;
	 }
	 public ArrayList<Integer>obtenerEjemplaresDisponibles(ArrayList<Integer>todosLosEjemplares,ArrayList<Integer>ejemplaresNoDisponibles){
		ArrayList<Integer>ejemplaresDisponibles=new ArrayList<Integer>();
		boolean disponible=true;
		 for(int i=0;i<=todosLosEjemplares.size()-1;i++) {
			 for(int j=0;j<=ejemplaresNoDisponibles.size()-1;j++) {
				 if(todosLosEjemplares.get(i)==ejemplaresNoDisponibles.get(j)) {
					 disponible=false;
				 }
				 if(j==todosLosEjemplares.size()-1) {
					 if(disponible) {
						 ejemplaresDisponibles.add(todosLosEjemplares.get(i));
					 }
					 disponible=true;
				 }
			 }
		 }
		 return ejemplaresDisponibles;
	 }
	 
	 
	 public ArrayList<String> obtenerEjemplares(String titulo){
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="SELECT codEjem, titulo FROM Ejemplar JOIN (SELECT codPro,titulo FROM Producto WHERE titulo=?)A ON A.codPro=Ejemplar.codPro";
		 try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstmt.setString(1, titulo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				ejemplares.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return ejemplares;
	 }
	 public ArrayList<EjemplarLibro> obtenerEjemplaresObjetos(String titulo){
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="SELECT codEjem, titulo FROM Ejemplar JOIN (SELECT codPro,titulo FROM Producto WHERE titulo=?)A ON A.codPro=Ejemplar.codPro";
		 try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pstmt.setString(1, titulo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EjemplarLibro ejemplarLibro=new EjemplarLibro(rs.getInt(1),titulo);
				ejemplaresTotales.add(ejemplarLibro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return ejemplaresTotales;
	 }
	 
	 
	 
	 
	 public int codigoMaximo() {
		 int max=0;
		 establecerConexion();
		 Statement stmt=null;
		 String sql="SELECT MAX(codPers) FROM Persona";
		 ResultSet rs=null;
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				max=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 cerrarConexion(conn);
		 return max;
	 }
	 
	 public ArrayList<String> obtenerProductosUsuario(Persona persona){
		establecerConexion();
		PreparedStatement pstmt=null;
		String sql="SELECT titulo FROM Producto WHERE codPro IN (SELECT codPro FROM Ejemplar WHERE codEjem IN(SELECT codEjem FROM ProductoUsuario WHERE codPers=? AND prestado=?))";
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
			pstmt.setBoolean(2, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
				productosUsuario.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cerrarConexion(conn);
		return productosUsuario;
	 }
	 
	 public ArrayList<EjemplarLibro> obtenerEjemplarLibro(Persona persona){
			establecerConexion();
			PreparedStatement pstmt=null;
			String sql="SELECT Producto.titulo, BB.codEjem FROM Producto JOIN (SELECT Ejemplar.codPro, AA.codEjem FROM Ejemplar JOIN (SELECT codEjem FROM ProductoUsuario WHERE codPers=? AND prestado=?)AA ON AA.codEjem=Ejemplar.codEjem) BB ON BB.codPro=Producto.codPro";
			try {
				pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
				pstmt.setBoolean(2, true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
					EjemplarLibro ej = new EjemplarLibro(rs.getInt(2), rs.getString(1));
					ejemplarUsuario.add(ej);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cerrarConexion(conn);
			return ejemplarUsuario;
		 }
	 
	 
	 public ArrayList<Persona> devolverUsuarios(){
		 establecerConexion();
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT * FROM Persona WHERE codPers IN (SELECT codPers FROM Usuario)";
		 try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Persona persona=new Persona(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				todosUsuarios.add(persona);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return todosUsuarios;
	 }
	 
	 public boolean puedePrestar(Persona persona) {
		establecerConexion();
		boolean puedePrestar=true;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT fecFin, prestado FROM ProductoUsuario WHERE codPers=?";
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.setInt(1, obtenerCodigoDePersona(persona.getUsuario()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
			Date date = new Date(System.currentTimeMillis());
			String fechaActual=date.toString();
			String[]ArrayFechaActual=fechaActual.split("-");
			int fecActualAnyo=Integer.parseInt(ArrayFechaActual[0]);
			int fecActualMes=Integer.parseInt(ArrayFechaActual[1]);
			int fecActualDia=Integer.parseInt(ArrayFechaActual[2]);
			rs=pstmt.executeQuery();
			while(rs.next()&&puedePrestar) {
				String fecFin=devolverDate(rs.getString(1));
				String[]ArrayFechaFinal=fecFin.split("-");
				int fecFinAnyo=Integer.parseInt(ArrayFechaFinal[0]);
				int fecFinMes=Integer.parseInt(ArrayFechaFinal[1]);
				int fecFinDia=Integer.parseInt(ArrayFechaFinal[2]);
				if(fecActualAnyo>fecFinAnyo) {
					puedePrestar=true;
				}else {
					if(fecActualAnyo==fecFinAnyo) {
						if(fecActualMes>fecFinMes) {
							puedePrestar=true;
						}else {
							if(fecActualMes==fecFinMes) {
								if(fecActualDia>fecFinDia) {
									puedePrestar=true;
								}
							}
						}
					}
				}
			puedePrestar = puedePrestar && (!rs.getBoolean(2));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cerrarConexion(conn);
		 
		 return puedePrestar;
		 
	 }
	 
	 public String devolverUsuario(int codPersona) {
		 establecerConexion();
		 String usuario="";
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 String sql="SELECT usuario FROM Persona WHERE codPers=?";
		 try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, codPersona);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				usuario=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 cerrarConexion(conn);
		 return usuario;
	 }
	 
	 public ArrayList<MultasPersona> devolverMultas() {
			establecerConexion();
			todasMultas=new ArrayList<MultasPersona>();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="SELECT codPers,codEjem,fecFin FROM ProductoUsuario";
			try {
				pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = new Date(System.currentTimeMillis());
				String fechaActual=date.toString();
				String[]ArrayFechaActual=fechaActual.split("-");
				int fecActualAnyo=Integer.parseInt(ArrayFechaActual[0]);
				int fecActualMes=Integer.parseInt(ArrayFechaActual[1]);
				int fecActualDia=Integer.parseInt(ArrayFechaActual[2]);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					String fecFin=devolverDate(rs.getString(3));
					String[]ArrayFechaFinal=fecFin.split("-");
					int fecFinAnyo=Integer.parseInt(ArrayFechaFinal[0]);
					int fecFinMes=Integer.parseInt(ArrayFechaFinal[1]);
					int fecFinDia=Integer.parseInt(ArrayFechaFinal[2]);
					if(fecActualAnyo>fecFinAnyo) {
						MultasPersona mp=new MultasPersona(rs.getInt(1),rs.getInt(2));
						todasMultas.add(mp);
					}else {
						if(fecActualAnyo==fecFinAnyo) {
							if(fecActualMes>fecFinMes) {
								MultasPersona mp=new MultasPersona(rs.getInt(1),rs.getInt(2));
								todasMultas.add(mp);
							}else {
								if(fecActualMes==fecFinMes) {
									if(fecActualDia>fecFinDia) {
										MultasPersona mp=new MultasPersona(rs.getInt(1),rs.getInt(2));
										todasMultas.add(mp);
									}
								}
							}
						}
					}	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cerrarConexion(conn);
			 
			 return todasMultas;
			 
		 }
	 public boolean existeUsuario(String usuario) {
		 boolean existe=false;
		 establecerConexion();
		 PreparedStatement pstmt=null;
		 String sql="SELECT codPers FROM Persona WHERE usuario=?";
		 ResultSet rs=null;
		 try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			rs=pstmt.executeQuery();
			if(rs.next()) {
				existe=true;
			}else {
				existe=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 return existe;
	 }
	 
	 public String devolverDate(String stringDate) {
		 String fecha[]=stringDate.split(" ");
		 int mes=0;
		 int dia=0;
		 int anyo=0;
		 if(fecha[1].equals("Jan")) {
			 mes=1;
		 }
		 if(fecha[1].equals("Feb")) {
			 mes=2;
		 }
		 if(fecha[1].equals("Mar")) {
			 mes=3;
		 }
		 if(fecha[1].equals("Apr")) {
			 mes=4;
		 }
		 if(fecha[1].equals("May")) {
			 mes=5;
		 }
		 if(fecha[1].equals("Jun")) {
			 mes=6;
		 }
		 if(fecha[1].equals("Jul")) {
			 mes=7;
		 }
		 if(fecha[1].equals("Aug")) {
			 mes=8;
		 }
		 if(fecha[1].equals("Sep")) {
			 mes=9;
		 }
		 if(fecha[1].equals("Oct")) {
			 mes=10;
		 }
		 if(fecha[1].equals("Nov")) {
			 mes=11;
		 }
		 if(fecha[1].equals("Dec")) {
			 mes=12;
		 }
		 dia=Integer.parseInt(fecha[2]);
		 anyo=Integer.parseInt(fecha[5]);
		
		 return anyo+"-"+mes+"-"+dia;
	 }
	 
	 public void insertarDatosPersona(int codPers, String nombre, String usuario, String contrasenya, String StringfecNac, String sexo){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Persona(codPers, nombre, usuario, contrasenya, fecNac, sexo) VALUES(?,?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setString(2, nombre);
			pstmt.setString(3, usuario);
			pstmt.setString(4, contrasenya);
			
			java.util.Date fecNac = string2Date("yyyy-MM-dd", StringfecNac);
			
			
			pstmt.setString(5, fecNac.toString());
			pstmt.setString(6, sexo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Persona");
	 }
	 public void insertarDatosAdministrador(int codPers, int nivel){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Administrador(codPers, nivel) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setInt(2, nivel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Administrador");
	 }
	 public void insertarDatosUsuario(int codPers, String stringFecAlta,double dinero){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Usuario(codPers, fecAlta, dinero) VALUES(?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			
			java.util.Date fecAlta = string2Date("yyyy-MM-dd", stringFecAlta);
			
			pstmt.setString(2, fecAlta.toString());
			pstmt.setDouble(3, dinero);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Usuario");
	 }
	 public void insertarDatosProducto(int codPro, String titulo,int codAutor, int codGenero){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Producto(codPro, titulo, codAutor, codGenero) VALUES(?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPro);
			pstmt.setString(2, titulo);
			pstmt.setInt(3, codAutor);
			pstmt.setInt(4, codGenero);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Producto");
	 }
	 public void insertarDatosProductoUsuario(int codPers, int codEjem,String StringFecIni, String StringFecFin, boolean prestado){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO ProductoUsuario(codPers, codEjem, fecIni,fecFin, prestado) VALUES(?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setInt(2, codEjem);
			
			java.util.Date fecIni = string2Date("yyyy-MM-dd", StringFecIni);
			pstmt.setString(3, fecIni.toString());
			if(StringFecFin==null) {
				pstmt.setString(4, null);
			}else {
				java.util.Date fecFin = string2Date("yyyy-MM-dd", StringFecFin);
				pstmt.setString(4, fecFin.toString());
			}
			pstmt.setBoolean(5, prestado);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla ProductoUsuario");
	 }
	 
	 public void insertarDatosLibro(int codPro, int edadRecLibro){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Libro(codPro, edadRecLibro) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPro);
			pstmt.setInt(2, edadRecLibro);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Libro");
	 }
	 
	 public void insertarDatosPelicula(int codPro, int edadRecPelicula){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Pelicula(codPro, edadRecPelicula) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPro);
			pstmt.setInt(2, edadRecPelicula);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Pelicula");
	 }
	 
	 public void insertarDatosAutor(int codAutor, String nomAutor){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Autor(codAutor, nomAutor) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codAutor);
			pstmt.setString(2, nomAutor);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Autor");
	 }
	 
	 public void insertarDatosGenero(int codGenero, String nomGenero){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Genero(codGenero, nomGenero) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codGenero);
			pstmt.setString(2, nomGenero);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Genero");
	 }
	 
	 public void insertarDatosEditorial(int codEditorial, String nomEditorial){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Editorial(codEditorial, nomEditorial) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codEditorial);
			pstmt.setString(2, nomEditorial);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Editorial");
	 }
	 
	 public void insertarDatosIdioma(int codIdioma, String nomIdioma){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Idioma(codIdioma, nomIdioma) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codIdioma);
			pstmt.setString(2, nomIdioma);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Idioma");
	 }
	 
	 public void insertarDatosEjemplar(int codEjem,int codPro, int codEditorial, int edicion, int codIdioma, int numPag, boolean prestado){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Ejemplar(codEjem,codPro, codEditorial, edicion, codIdioma, numpag, prestado) VALUES(?,?,?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codEjem);
			pstmt.setInt(2, codPro);
			pstmt.setInt(3, codEditorial);
			pstmt.setInt(4, edicion);
			pstmt.setInt(5, codIdioma);
			pstmt.setInt(6, numPag);
			pstmt.setBoolean(7, prestado);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Ejemplar");
	 }
	 
	 public void insertarDatosOrdenador(int codOrdenador){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Ordenador(codOrdenador) VALUES(?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codOrdenador);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Ordenador");
	 }
	 
	 public void insertarDatosOrdenadorUsuario(int codPers, int codOrdenador, String StringFecIni, String StringFecFin){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO OrdenadorUsuario(codPers, codOrdenador, fecIni, fecFin) VALUES(?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setInt(2,codOrdenador);
			
			java.util.Date fecIni = string2Date("yyyy-MM-dd HH:mm:ss", StringFecIni);
			
			pstmt.setString(3, fecIni.toString());
			if(StringFecFin==null) {
				pstmt.setString(4,null);
			}else {
				java.util.Date fecFin = string2Date("yyyy-MM-dd HH:mm:ss", StringFecFin);
				pstmt.setString(4, fecFin.toString());
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla OrdenadorUsuario");
	 }
	 
	 public void insertarDatosCuentacuentos(int codCuen, String StringFecCuen, int aforo, String nombre, String descripcion){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Cuentacuentos(codCuen, fecCuen, aforo, nombre, descripcion) VALUES(?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codCuen);
			
			java.util.Date fecCuen = string2Date("yyyy-MM-dd HH:mm:ss", StringFecCuen);
			pstmt.setString(2,fecCuen.toString());
			pstmt.setInt(3, aforo);
			pstmt.setString(4, nombre);
			pstmt.setString(5, descripcion);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Cuentacuentos");
	 }
	 
	 public void insertarDatosCuentacuentosUsuario(int codPers, int codCuen){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO CuentacuentosUsuario(codPers, codCuen) VALUES(?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setInt(2,codCuen);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla CuentacuentosUsuario");
	 }
	 
	 public void insertarDatosCD(int codPro){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO CD(codPro) VALUES(?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPro);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla CD");
	 }
	 
	 public void insertarDatosVideojuego(int codPro){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Videojuego(codPro) VALUES(?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPro);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 cerrarConexion(conn);
		 System.out.println("Se ha ejecutado la acción en la tabla Videojuego");
	 }
	 
	 public java.util.Date string2Date (String formato, String fecha){
		
		 this.formatoFec = new SimpleDateFormat(formato);

		 try {
			return this.formatoFec.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		    
	 }
	 
	 
	 
	 public void cerrarConexion(Connection conn) {
		 if(conn!=null) {
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }

public static void main (String [ ] args) {
	
	GestionBD bd1=new GestionBD("BookLand.db");
	
	
	

	
	
	
}

}
	 
	 

