package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.Libro;
import productos.libros.Autor;
import productos.libros.Genero;
import servicios.ProductoUsuario;

public class LibroTest {
	
	private Libro libro;
	private Autor autor;
	private Autor autor2;
	private Genero genero;
	private Genero genero2;
	private ProductoUsuario usuario;
	private ProductoUsuario usuario2;


	@Before
	public void setUp() throws Exception {
		libro = new Libro(false, "Annie Hall", autor, genero, usuario, 12);
	}

	@After
	public void tearDown() throws Exception {
		libro=null;
	}

	@Test
	public void getEdadRecLibrotest() {
		assertEquals(12, libro.getEdadRecLibro());
	}
	@Test
	public void setEdadRecLibrotest() {
		libro.setEdadRecLibro(13);
		assertEquals(13, libro.getEdadRecLibro());
	}


}
