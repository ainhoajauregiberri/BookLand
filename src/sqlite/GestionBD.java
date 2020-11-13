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
		 System.out.println("Se ha ejecutado la accion en la tabla");
		 
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
	bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Persona (\n"
		    +"codPers integer PRIMARY KEY,\n"
		    		+"nombre text NOT NULL,\n"
		    		+"usuario text NOT NULL,\n"
		    		+"contrasenya text NOT NULL,\n"
		    		+"fecNac DATETIME NOT NULL,\n"
		    		+"sexo text NOT NULL\n"
		    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Administrador (\n"
    	    +"codPers integer NOT NULL,\n"
    	    +"nivel integer NOT NULL,\n"
 	    +"PRIMARY KEY(codPers),\n"
	    +"FOREIGN KEY (codPers) REFERENCES Persona(codPers)\n"
    	   + ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Usuario (\n"
    		+"codPers integer NOT NULL,\n"
    		+"fecAlta DATETIME NOT NULL,\n"
    		+"dinero Double NOT NULL,\n"
	+"PRIMARY KEY(codPers),\n"
	+"FOREIGN KEY (codPers) REFERENCES Persona(codPers)\n"
    		+ ");");

	bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Producto (\n"
	  	  	+"codPro integer PRIMARY KEY,\n"
//No hace falta disponible. Lo sacaremos mirando si exsite alguna instancia
//de la clase ProductoUsuario en la que la fecha actual esta entre la fecha de inicio y la fecha final
//El atributo que nos dice el usuario que actualmente tiene ese producto también se hará a través de la tabla ProductoUsuario	    		
		+"titulo text NOT NULL,\n"
	    		+"codAutor integer NOT NULL,\n"
	    		+"codGenero integer NOT NULL\n"
	    		+ ");");

	bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS ProductoUsuario (\n"
    		+"codPers integer NOT NULL,\n"
	+"codPro integer NOT NULL,\n"
    		+"fecIni DATETIME NOT NULL,\n"
    		+"fecFin DATETIME,\n"
	+"PRIMARY KEY(codPers, codPro),\n"
	+"FOREIGN KEY (codPers) REFERENCES Persona(codPers),\n"
	+"FOREIGN KEY (codPro) REFERENCES Producto(codPro)"
    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Libro (\n"
			+"codPro integer NOT NULL,\n"
    	    		+"edadRecLibro text NOT NULL,\n"
			+"PRIMARY KEY(codPro),\n"
			+"FOREIGN KEY (codPro) REFERENCES Producto(codPro)\n"
    	    		+ ");");


bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Pelicula (\n"
			+"codPro integer NOT NULL,\n"
    	    		+"edadRecPelicula text NOT NULL,\n"
			+"PRIMARY KEY(codPro),\n"
			+"FOREIGN KEY (codPro) REFERENCES Producto(codPro)\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Autor (\n"
			+"codAutor integer PRIMARY KEY,\n"
    	    		+"nomAutor text NOT NULL\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Genero (\n"
			+"codGenero integer PRIMARY KEY,\n"
    	    		+"nomGenero text NOT NULL\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Editorial (\n"
			+"codEditorial integer PRIMARY KEY,\n"
    	    		+"nomEditorial text NOT NULL\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Idioma (\n"
			+"codIdioma integer PRIMARY KEY,\n"
    	    		+"nomIdioma text NOT NULL\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Ejemplar (\n"
			+"codLibro integer NOT NULL,\n"
			+"codEditorial integer NOT NULL,\n"
    	    		+"edicion integer NOT NULL,\n"
			+"codIdioma integer NOT NULL,\n"
			+"numPag integer NOT NULL,\n"
			+"PRIMARY KEY(codLibro, codEditorial, edicion),\n"
			+"FOREIGN KEY (codLibro) REFERENCES Producto(codLibro),\n"
			+"FOREIGN KEY (codEditorial) REFERENCES Editorial(codEditorial),\n"
			+"FOREIGN KEY (codIdioma) REFERENCES Idioma(codIdioma)\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Ordenador (\n"
			+"codOrdenador integer PRIMARY KEY\n"
    	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS OrdenadorUsuario (\n"
			+"codPers integer NOT NULL,\n"
			+"codOrdenador integer NOT NULL,\n"
			+"fecIni DATETIME NOT NULL,\n"
    	    		+"fecFin DATETIME,\n"  
			+"PRIMARY KEY(codPers, codOrdenador,fecIni),\n"
			+"FOREIGN KEY (codPers) REFERENCES Usuaio(codPers),\n"  	    
			+"FOREIGN KEY (codOrdenador) REFERENCES Ordenador(codOrdenador)\n"  		
			+ ");");


bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Cuentacuentos (\n"
	        +"codCuen integer PRIMARY KEY,\n"	
	        +"fecCuen DATETIME NOT NULL,\n" 
		+"aforo integer NOT NULL,\n" 
		+"nombre text NOT NULL,\n"
		+"descripcion text NOT NULL\n"
	    		+ ");");

bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS CuentacuentosUsuario (\n"
			+"codPers integer NOT NULL,\n"   
			+"codCuen integer NOT NULL,\n"   		
			+"PRIMARY KEY(codPers, codCuen),\n" 
			+"FOREIGN KEY (codPers) REFERENCES Usuario(codPers),\n"
			+"FOREIGN KEY (codCuen) REFERENCES Cuentacuentos(codCuen)\n"  	 
			+ ");");

	
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


    bd1.insertarDatosAdministrador(1, 1);
    bd1.insertarDatosAdministrador(2, 2);
    bd1.insertarDatosAdministrador(3, 2);
    bd1.insertarDatosAdministrador(4, 2);



    bd1.insertarDatosOrdenador(1);
    bd1.insertarDatosOrdenador(2);
    bd1.insertarDatosOrdenador(3);

bd1.insertarDatosOrdenadorUsuario(5, 1, "2020-06-13 17:00:00", "2020-06-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(5, 2, "2020-06-14 17:00:00", "2020-06-14 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(5, 2, "2020-07-13 17:00:00", "2020-07-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(11, 2, "2020-06-13 17:00:00", "2020-06-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(11, 3, "2020-07-17 17:00:00", "2020-07-17 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(11, 3, "2020-06-19 17:00:00", "2020-06-19 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(15, 3, "2020-06-13 17:00:00", "2020-06-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(15, 1, "2020-08-13 17:00:00", "2020-08-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(15, 1, "2020-09-13 17:00:00", "2020-09-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(10, 2, "2020-10-13 17:00:00", null);
	bd1.insertarDatosOrdenadorUsuario(19, 3, "2019-11-13 17:00:00", "2019-11-13 18:00:00");
	bd1.insertarDatosOrdenadorUsuario(19, 1, "2019-12-13 17:00:00", "2019-12-13 18:00:00");


	bd1.insertarDatosCuentacuentos(1, "2020-04-23 13:00:00", 10, "Dia del libro", "Este es el cuentacuentos especial organizado para celebrar el día del libro");
	bd1.insertarDatosCuentacuentos(2, "2020-09-13 13:00:00", 10, "Roald Dahl", "Este es el cuentacuentos especial organizado para celebrar el día de Roald Dahl");
	bd1.insertarDatosCuentacuentos(3, "2020-07-04 13:00:00", 5, "Julio", "En verano se organizan dos cuentacuentos, este es el relativo al primer sabado de julio");
	bd1.insertarDatosCuentacuentos(4, "2020-08-01 13:00:00", 5, "Agosto", "En verano se organizan cuentacuentos, este es el relativo al primer sabado de agosto2");

	bd1.insertarDatosCuentacuentosUsuario(5, 1);
	bd1.insertarDatosCuentacuentosUsuario(5, 2);
	bd1.insertarDatosCuentacuentosUsuario(5, 3);
	bd1.insertarDatosCuentacuentosUsuario(6, 1);
	bd1.insertarDatosCuentacuentosUsuario(6, 2);
	bd1.insertarDatosCuentacuentosUsuario(7, 3);
	bd1.insertarDatosCuentacuentosUsuario(8, 4);
	bd1.insertarDatosCuentacuentosUsuario(9, 3);
	bd1.insertarDatosCuentacuentosUsuario(9, 4);
	bd1.insertarDatosCuentacuentosUsuario(10, 3);
	bd1.insertarDatosCuentacuentosUsuario(10, 4);
	bd1.insertarDatosCuentacuentosUsuario(11, 1);
	bd1.insertarDatosCuentacuentosUsuario(11, 2);
	bd1.insertarDatosCuentacuentosUsuario(12, 1);
	bd1.insertarDatosCuentacuentosUsuario(12, 2);
	bd1.insertarDatosCuentacuentosUsuario(13, 1);
	bd1.insertarDatosCuentacuentosUsuario(13, 2);
	bd1.insertarDatosCuentacuentosUsuario(13, 4);
	bd1.insertarDatosCuentacuentosUsuario(14, 4);
	bd1.insertarDatosCuentacuentosUsuario(15, 2);


bd1.insertarDatosAutor(1, "J. K. Rowling");
bd1.insertarDatosAutor(2, "Toti Martínez de Lezea");
bd1.insertarDatosAutor(3, "Roald Dahl");	
bd1.insertarDatosAutor(4, "Enid Blyton");  //Autora de los 5
bd1.insertarDatosAutor(5, "Bernardo Atxaga");
bd1.insertarDatosAutor(6, "Isabel Allende");
bd1.insertarDatosAutor(7, "Joaquín Lavado");
bd1.insertarDatosAutor(8, "Woody Allen");
bd1.insertarDatosAutor(9, "Jon Avnet");


bd1.insertarDatosGenero(1, "Comedia");
bd1.insertarDatosGenero(2, "Drama");
bd1.insertarDatosGenero(3, "Fantasia");

    bd1.insertarDatosEditorial(1, "Planetadelibros");
    bd1.insertarDatosEditorial(2, "Erein");

    bd1.insertarDatosIdioma(1, "Euskara");
    bd1.insertarDatosIdioma(2, "Castellano");



bd1.insertarDatosEjemplar(1, 1, 1, 1, 100);
bd1.insertarDatosEjemplar(1, 1, 2, 1, 120);
bd1.insertarDatosEjemplar(2, 1, 2, 1, 120);
bd1.insertarDatosEjemplar(3, 1, 2, 1, 220);
bd1.insertarDatosEjemplar(4, 1, 1, 1, 420);
bd1.insertarDatosEjemplar(5, 1, 1, 1, 620);
bd1.insertarDatosEjemplar(6, 1, 1, 1, 720);
bd1.insertarDatosEjemplar(7, 1, 1, 1, 180);
bd1.insertarDatosEjemplar(8, 1, 1, 1, 800);
bd1.insertarDatosEjemplar(9, 1, 1, 1, 1000);
bd1.insertarDatosEjemplar(10, 1, 1, 1, 60);
bd1.insertarDatosEjemplar(10, 2, 1, 1, 100);
bd1.insertarDatosEjemplar(11, 1, 1, 1, 900);
bd1.insertarDatosEjemplar(12, 1, 2, 1, 190);
bd1.insertarDatosEjemplar(13, 1, 2, 1, 50);
bd1.insertarDatosEjemplar(14, 1, 2, 1, 500);
bd1.insertarDatosEjemplar(15, 1, 2, 1, 1000);
bd1.insertarDatosEjemplar(16, 1, 1, 1, 900);
bd1.insertarDatosEjemplar(17, 1, 2, 1, 380);
bd1.insertarDatosEjemplar(18, 1, 2, 1, 430);
bd1.insertarDatosEjemplar(19, 1, 1, 1, 870);
bd1.insertarDatosEjemplar(20, 1, 2, 1, 900);
bd1.insertarDatosEjemplar(20, 2, 2, 1, 120);
bd1.insertarDatosEjemplar(20, 2, 3, 1, 630);


bd1.insertarDatosLibro(1,12);
bd1.insertarDatosLibro(2,8);
bd1.insertarDatosLibro(3,8);
bd1.insertarDatosLibro(4,6);
bd1.insertarDatosLibro(5,6);
bd1.insertarDatosLibro(6,12);
bd1.insertarDatosLibro(7,14);
bd1.insertarDatosLibro(8,14);
bd1.insertarDatosLibro(9,14);
bd1.insertarDatosLibro(10,14);
bd1.insertarDatosLibro(11,14);
bd1.insertarDatosLibro(12,14);
bd1.insertarDatosLibro(13,14);
bd1.insertarDatosLibro(14,6);
bd1.insertarDatosLibro(15,6);
bd1.insertarDatosLibro(16,6);
bd1.insertarDatosLibro(17,6);
bd1.insertarDatosLibro(18,12);
bd1.insertarDatosLibro(19,12);
bd1.insertarDatosLibro(20,8);

bd1.insertarDatosPelicula(21, 14);
bd1.insertarDatosPelicula(22, 16);
bd1.insertarDatosPelicula(23, 18);
bd1.insertarDatosPelicula(24, 10);

   bd1.insertarDatosUsuario(5, "2002-03-13", 3.5);
    bd1.insertarDatosUsuario(6, "2012-04-13", 4.6);
    bd1.insertarDatosUsuario(7, "2014-05-13", 2.9);
    bd1.insertarDatosUsuario(8, "2016-06-13", 5.1);
    bd1.insertarDatosUsuario(9, "2000-07-13", 7.0);
    bd1.insertarDatosUsuario(10, "2001-08-13", 0.6);
    bd1.insertarDatosUsuario(11, "2003-09-13", 12.5);
    bd1.insertarDatosUsuario(12, "1990-11-13", 1.5);
    bd1.insertarDatosUsuario(13, "1987-10-13", 0.5);
    bd1.insertarDatosUsuario(14, "1999-12-13", 2.5);
    bd1.insertarDatosUsuario(15, "1998-03-13", 4.5);
    bd1.insertarDatosUsuario(16, "1996-01-13", 7.5);
    bd1.insertarDatosUsuario(17, "2017-01-13", 8.5);
    bd1.insertarDatosUsuario(18, "2018-02-13", 0.1);
    bd1.insertarDatosUsuario(19, "2020-02-13", 0.0);
    bd1.insertarDatosUsuario(20, "2019-01-13", 0.2);


bd1.insertarDatosProducto(1, "Harry Potter y la piedra filosofal", 1, 3);
bd1.insertarDatosProducto(2, "Nur 1", 2, 3);
bd1.insertarDatosProducto(3, "Nur 2", 2, 3);
bd1.insertarDatosProducto(4, "Charlie y la fábrica de chocolate", 3, 3);
bd1.insertarDatosProducto(5, "Matilda", 3, 3);
bd1.insertarDatosProducto(6, "Los 5", 4, 1);
bd1.insertarDatosProducto(7, "La casa de los espíritus", 6, 2);
bd1.insertarDatosProducto(8, "Bi anai", 5, 2);
bd1.insertarDatosProducto(9, "Obabakoak", 6, 1);
bd1.insertarDatosProducto(10, "Hijo de la fortuna", 6, 2);
bd1.insertarDatosProducto(11, "El embajador", 6, 2);
bd1.insertarDatosProducto(12, "La balada de medio pelo", 6, 1);
bd1.insertarDatosProducto(13, "Los siete espejos", 6, 2);
bd1.insertarDatosProducto(14, "Las brujas", 3, 3);
bd1.insertarDatosProducto(15, "El gram gigante bonachón", 3, 3);
bd1.insertarDatosProducto(16, "James y el melocotón gigante", 3, 3);
bd1.insertarDatosProducto(17, "El dedo mágico", 3, 3);
bd1.insertarDatosProducto(18, "Harry Potter y la cámara secreto", 1, 3);
bd1.insertarDatosProducto(19, "Harry Potter y el prisionero de Azkaban", 1, 3);
bd1.insertarDatosProducto(20, "Nur 3", 2, 3);
bd1.insertarDatosProducto(21, "Tomates verdes fritos", 9, 2);
bd1.insertarDatosProducto(22, "El laberinto rojo", 9, 3);
bd1.insertarDatosProducto(23, "Annie Hall", 8, 1);
bd1.insertarDatosProducto(24, "Medianoche en París", 8, 1);


bd1.insertarDatosProductoUsuario(5, 1, "2020-06-10", "2020-07-27");
bd1.insertarDatosProductoUsuario(5, 18, "2020-06-10", "2020-07-27");
bd1.insertarDatosProductoUsuario(5, 19, "2020-08-10", null);
bd1.insertarDatosProductoUsuario(6, 2, "2020-09-10", "2020-09-20");
bd1.insertarDatosProductoUsuario(15, 23, "2020-09-10", "2020-09-20");
bd1.insertarDatosProductoUsuario(16, 22, "2020-09-10", "2020-09-20");
bd1.insertarDatosProductoUsuario(17, 21, "2020-09-10", "2020-09-20");
bd1.insertarDatosProductoUsuario(18, 18, "2020-11-12", null);
bd1.insertarDatosProductoUsuario(19, 21, "2020-10-12", null);
bd1.insertarDatosProductoUsuario(7, 4, "2020-11-12", null);
bd1.insertarDatosProductoUsuario(8, 5, "2020-11-01", null);
bd1.insertarDatosProductoUsuario(9, 5, "2020-11-01", null);
bd1.insertarDatosProductoUsuario(9, 6, "2020-11-11", null);
bd1.insertarDatosProductoUsuario(10, 7, "2020-11-13", null);
bd1.insertarDatosProductoUsuario(11, 8, "2020-11-05", null);
bd1.insertarDatosProductoUsuario(12, 10, "2020-11-04", null);
bd1.insertarDatosProductoUsuario(12, 11, "2020-11-03", null);
bd1.insertarDatosProductoUsuario(12, 12, "2020-11-02", null);
bd1.insertarDatosProductoUsuario(14, 14, "2020-11-01", null);
bd1.insertarDatosProductoUsuario(14, 15, "2020-11-01", null);

}

}
	 
	 

