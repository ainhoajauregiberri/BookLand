package sqlite;

public class BaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GestionBD bd1=new GestionBD("BookLand.db");
		bd1.createDB();
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
		//de la clase ProductoUsuario en la que la fecha actual esta entre la fecha de inicio y la fecha
		//final
		//El atributo que nos dice el usuario que actualmente tiene ese producto también se hará a
		//través de la
		//tabla ProductoUsuario
		+"titulo text NOT NULL,\n"
		+"codAutor integer NOT NULL,\n"
		+"codGenero integer NOT NULL\n"
		+ ");");
		bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS ProductoUsuario (\n"
		+"codPers integer NOT NULL,\n"
		+"codEjem integer NOT NULL,\n"
		+"fecIni DATETIME NOT NULL,\n"
		+"fecFin DATETIME,\n"
		+"prestado boolean,\n"

		+"PRIMARY KEY(codPers, codEjem, fecIni),\n"
		+"FOREIGN KEY (codPers) REFERENCES Persona(codPers),\n"
		+"FOREIGN KEY (codEjem) REFERENCES Ejemplar(codEjem)"
		+ ");");
		bd1.crearModificarBorrarTabla("CREATE TABLE IF NOT EXISTS Libro (\n"
		+"codPro integer NOT NULL,\n"
		+"edadRecLibro text NOT NULL,\n"
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
		+"codEjem integer NOT NULL,\n"
		+"codPro integer NOT NULL,\n"
		+"codEditorial integer NOT NULL,\n"
		+"edicion integer NOT NULL,\n"
		+"codIdioma integer NOT NULL,\n"
		+"numPag integer NOT NULL,\n"
		+"prestado boolean,\n "
		+"PRIMARY KEY(codEjem),\n"
		+"FOREIGN KEY (codPro) REFERENCES Producto(codPro),\n"
		+"FOREIGN KEY (codEditorial) REFERENCES Editorial(codEditorial),\n"
		+"FOREIGN KEY (codIdioma) REFERENCES Idioma(codIdioma)\n"
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
		bd1.insertarDatosAutor(1, "J. K. Rowling");
		bd1.insertarDatosAutor(2, "Toti Martínez de Lezea");
		bd1.insertarDatosAutor(3, "Roald Dahl");
		bd1.insertarDatosAutor(4, "Enid Blyton"); //Autora de los 5
		bd1.insertarDatosAutor(5, "Bernardo Atxaga");
		bd1.insertarDatosAutor(6, "Isabel Allende");
		bd1.insertarDatosAutor(7, "Joaquín Lavado");
		bd1.insertarDatosGenero(1, "Comedia");
		bd1.insertarDatosGenero(2, "Drama");
		bd1.insertarDatosGenero(3, "Fantasia");
		bd1.insertarDatosEditorial(1, "Planetadelibros");
		bd1.insertarDatosEditorial(2, "Erein");
		bd1.insertarDatosIdioma(1, "Euskara");
		bd1.insertarDatosIdioma(2, "Castellano");

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

		bd1.insertarDatosEjemplar(1, 1, 1, 1, 1, 100, false);
		bd1.insertarDatosEjemplar(2, 1, 1, 2, 1, 120, false);
		bd1.insertarDatosEjemplar(3, 2, 1, 2, 1, 120, true);
		bd1.insertarDatosEjemplar(4, 3, 1, 2, 1, 220, true);
		bd1.insertarDatosEjemplar(5, 4, 1, 1, 1, 420, true);
		bd1.insertarDatosEjemplar(6, 5, 1, 1, 1, 620, true);
		bd1.insertarDatosEjemplar(7, 6, 1, 1, 1, 720, true);
		bd1.insertarDatosEjemplar(8, 7, 1, 1, 1, 180, true);
		bd1.insertarDatosEjemplar(9, 8, 1, 1, 1, 800, false);
		bd1.insertarDatosEjemplar(10, 9, 1, 1, 1, 1000, true);
		bd1.insertarDatosEjemplar(11, 10, 1, 1, 1, 60, true);
		bd1.insertarDatosEjemplar(12, 10, 2, 1, 1, 100, true);
		bd1.insertarDatosEjemplar(13, 11, 1, 1, 1, 900, false);
		bd1.insertarDatosEjemplar(14, 12, 1, 2, 1, 190, true);
		bd1.insertarDatosEjemplar(15, 13, 1, 2, 1, 50, true);
		bd1.insertarDatosEjemplar(16, 14, 1, 2, 1, 500, false);
		bd1.insertarDatosEjemplar(17, 15, 1, 2, 1, 1000, false);

		bd1.insertarDatosEjemplar(18, 16, 1, 1, 1, 900, true);
		bd1.insertarDatosEjemplar(19, 17, 1, 2, 1, 380, false);
		bd1.insertarDatosEjemplar(20, 18, 1, 2, 1, 430, false);
		bd1.insertarDatosEjemplar(21, 19, 1, 1, 1, 870, false);
		bd1.insertarDatosEjemplar(22, 20, 1, 2, 1, 900, true);
		bd1.insertarDatosEjemplar(23, 20, 2, 2, 1, 120, false);
		bd1.insertarDatosEjemplar(24, 20, 2, 3, 1, 630, false);

		//true si todavía no se ha devuelto
		bd1.insertarDatosProductoUsuario(5, 1, "2020-06-10", "2020-07-27", false);
		bd1.insertarDatosProductoUsuario(5, 18, "2020-06-10", "2020-07-27",

		true);

		bd1.insertarDatosProductoUsuario(5, 19, "2020-11-10", "2020-11-20",

		false);

		bd1.insertarDatosProductoUsuario(6, 2, "2020-09-10", "2020-09-20",

		false);

		bd1.insertarDatosProductoUsuario(15, 23, "2020-09-10", "2020-09-20",

		false);

		bd1.insertarDatosProductoUsuario(16, 22, "2020-09-10", "2020-09-20",

		true);

		bd1.insertarDatosProductoUsuario(17, 21, "2020-09-10", "2020-09-20",

		false);

		bd1.insertarDatosProductoUsuario(18, 24, "2020-11-12", "2020-11-30",

		false);

		bd1.insertarDatosProductoUsuario(19, 21, "2020-10-12", "2020-11-20",

		false);

		bd1.insertarDatosProductoUsuario(7, 4, "2020-11-12", "2020-12-01",

		true);

		bd1.insertarDatosProductoUsuario(8, 5, "2020-11-01", "2020-11-23",

		true);

		bd1.insertarDatosProductoUsuario(9, 3, "2020-11-01", "2020-11-31",

		true);

		bd1.insertarDatosProductoUsuario(9, 6, "2020-11-11", "2020-12-01",

		true);

		bd1.insertarDatosProductoUsuario(10, 7, "2020-11-13", "2020-12-01",

		true);

		bd1.insertarDatosProductoUsuario(11, 8, "2020-11-05", "2020-12-02",

		true);

		bd1.insertarDatosProductoUsuario(12, 10, "2020-11-04", "2020-12-03",

		true);

		bd1.insertarDatosProductoUsuario(12, 11, "2020-11-03", "2020-12-19",

		true);

		bd1.insertarDatosProductoUsuario(12, 12, "2020-11-02", "2020-11-23",

		true);

		bd1.insertarDatosProductoUsuario(14, 14, "2020-11-01", "2020-11-31",

		true);

		bd1.insertarDatosProductoUsuario(14, 15, "2020-11-01", "2020-12-01",

		true);
		
	}

}
