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
import productos.libros.Autor;
import productos.libros.Genero;

import java.sql.Connection;
import java.sql.DatabaseMetaData;


public class GestionBD {
	
	private String nombreFichero;
	private String url="jdbc:sqlite:" + nombreFichero;
	private Connection conn;
	private SimpleDateFormat formatoFec;
	private HashMap<String,Persona>personas;
	private ArrayList<Genero>generos;
	private ArrayList<Autor>autores;
	ArrayList<String>titulos;
	
	public GestionBD(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		this.url = "jdbc:sqlite:" + nombreFichero;
		this.conn = null;
		this.personas=new HashMap<String,Persona>();
		this.generos=new ArrayList<Genero>();
		this.autores=new ArrayList<Autor>();
		this.titulos=new ArrayList<String>();
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
				System.out.println(p.toString());
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
	 
	 public ArrayList<String> obtenerTitulos() {
		 establecerConexion();
		 Statement stmt=null;
		 ResultSet rs=null;
		 String sql="SELECT titulo FROM Producto WHERE codPro IN(SELECT codPro FROM CD)";
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
	 public void insertarDatosProductoUsuario(int codPers, int codPro,String StringFecIni, String StringFecFin){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO ProductoUsuario(codPers, codPro, fecIni,fecFin) VALUES(?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codPers);
			pstmt.setInt(2, codPro);
			
			java.util.Date fecIni = string2Date("yyyy-MM-dd", StringFecIni);
			pstmt.setString(3, fecIni.toString());
			if(StringFecFin==null) {
				pstmt.setString(4, null);
			}else {
				java.util.Date fecFin = string2Date("yyyy-MM-dd", StringFecFin);
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
	 
	 public void insertarDatosEjemplar(int codLibro, int codEditorial, int edicion, int codIdioma, int numPag){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Ejemplar(codLibro, codEditorial, edicion, codIdioma, numpag) VALUES(?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codLibro);
			pstmt.setInt(2, codEditorial);
			pstmt.setInt(3, edicion);
			pstmt.setInt(4, codIdioma);
			pstmt.setInt(5, numPag);
			
			
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
	bd1.createDB();

}

}
	 
	 

