package sqlite;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DatabaseMetaData;


public class GestionBD {
	
	private String nombreFichero;
	private String url="jdbc:sqlite:" + nombreFichero;
	private Connection conn;
	private SimpleDateFormat formatoFec;
	
	public GestionBD(String nombreFichero) {
		this.nombreFichero = nombreFichero;
		this.url = "jdbc:sqlite:" + nombreFichero;
		this.conn = null;
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
		 
	 }
	 
	 public void insertarDatosPersona(int codPers, String nombre, String usuario, String contrasenya, String StringfecNac, String sexo){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 java.util.Date fecNac=null;
		 
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
			
			fecNac =  (Date) string2Date("yyyy-MM-dd", StringfecNac);
			
			
			pstmt.set(5, fecNac);
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
			
			Date fecAlta = (java.sql.Date) string2Date("yyyy-MM-dd", stringFecAlta);
			
			pstmt.setDate(2, fecAlta);
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
			
			Date fecIni = (java.sql.Date) string2Date("yyyy-MM-dd", StringFecIni);
			Date fecFin = (java.sql.Date) string2Date("yyyy-MM-dd", StringFecFin);
			pstmt.setDate(3, fecIni);
			pstmt.setDate(4, fecFin);
			
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
	 }
	 
	 public void insertarDatosLibro(int codPro, int edadRecLibro){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Libro(codPers, codPro) VALUES(?,?)";
		 
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
	 }
	 
	 public void insertarDatosAutor(int codAutor, String nomAutor){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Autor(codPro, edadRecPelicula) VALUES(?,?)";
		 
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
	 }
	 
	 public void insertarDatosEditorial(int codEditorial, String nomEditorial){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Genero(codEditorial, nomEditorial) VALUES(?,?)";
		 
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
	 }
	 
	 public void insertarDatosEjemplar(int codLibro, int codEditorial, int edicion, int codIdioma, int numPag){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Ejemplar(codLibro, codEditorial, edicion, codIdioma, numpag) VALUES(?,?)";
		 
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
	 }
	 
	 public void insertarDatosOrdenador(int codOrdenador){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Ordenador(codOrdenadorg) VALUES(?)";
		 
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
			
			Date fecIni = (java.sql.Date) string2Date("yyyy-MM-dd HH:mm:ss", StringFecIni);
			Date fecFin = (java.sql.Date) string2Date("yyyy-MM-dd HH:mm:ss", StringFecFin);
			pstmt.setDate(3, fecIni);
			pstmt.setDate(4, fecFin);
			
			
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
	 }
	 
	 public void insertarDatosCuentacuentos(int codCuen, String StringFecCuen, int aforo, String nombre, String descripcion){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO Cuentacuentos(codCuen, fecCuen, nombre, descripcion) VALUES(?,?,?,?,?)";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			pstmt.setInt(1, codCuen);
			
			Date fecCuen = (java.sql.Date) string2Date("yyyy-MM-dd HH:mm:ss", StringFecCuen);
			pstmt.setDate(2,fecCuen);
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
	 }
	 
	 public void insertarDatosCuentacuentosUsuarios(int codPers, int codCuen){
		 establecerConexion();
		 PreparedStatement pstmt = null;
		 
		 String sql = "INSERT INTO CuentacuentosUsuarios(codPers, codCuen) VALUES(?,?)";
		 
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
	 }
	 
	 public void Videojuego(int codPro){
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
	
	bd1.insertarDatosPersona(1, "Ainhoa", "ainhoa10", "kaixo1234", "2000-07-10", "chica");
    bd1.insertarDatosPersona(2, "Lorea", "lorea10", "kaixo1234", "2000-03-13", "chica");
    bd1.insertarDatosPersona(3, "Naroa", "naroa10", "kaixo1234", "2000-02-11", "chica");
    bd1.insertarDatosPersona(4, "Julen", "julen10", "kaixo1234", "2002-08-10", "chico");
    bd1.insertarDatosPersona(5, "Jon", "jon10", "kaixo1234", "2000-07-15", "chico");
    bd1.insertarDatosPersona(6, "Alvaro", "alvaro10", "kaixo1234", "1990-01-20", "chico");
    bd1.insertarDatosPersona(7, "Mikel", "mikel10", "kaixo1234", "1967-02-30", "chico");
    bd1.insertarDatosPersona(8, "Victor", "victor10", "kaixo1234", "1987-08-10", "chico");
    bd1.insertarDatosPersona(9, "Ruben", "ruben10", "kaixo1234", "1980-09-10", "chico");
    bd1.insertarDatosPersona(10, "Gorka", "gorka10", "kaixo1234", "2004-12-12", "chico");
    bd1.insertarDatosPersona(11, "Nora", "nora10", "kaixo1234", "2006-11-01", "chica");
    bd1.insertarDatosPersona(12, "Leire", "leire10", "kaixo1234", "1981-05-06", "chica");
    bd1.insertarDatosPersona(13, "Pablo", "pablo10", "kaixo1234", "1945-06-10", "chico");
    bd1.insertarDatosPersona(14, "Xanti", "xanti10", "kaixo1234", "1974-09-07", "chico");
    bd1.insertarDatosPersona(15, "Markel", "markel10", "kaixo1234", "1974-09-07", "chico");
    bd1.insertarDatosPersona(16, "Unai", "unai10", "kaixo1234", "1974-09-07", "chico");
    bd1.insertarDatosPersona(17, "Aitor", "aitor10", "kaixo1234", "1974-09-07", "chico");
    bd1.insertarDatosPersona(18, "Asier", "asier10", "kaixo1234", "1974-09-07", "chico");
    bd1.insertarDatosPersona(19, "Andrea", "andrea10", "kaixo1234", "1974-09-07", "chica");
    bd1.insertarDatosPersona(20, "Maria", "maria10", "kaixo1234", "1974-09-07", "chica");
	
	
	

 
}

}
	 
	 

