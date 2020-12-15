package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.Libro;
import productos.libros.Autor;
import productos.libros.Editorial;
import productos.libros.Ejemplar;
import productos.libros.Genero;
import productos.libros.Idioma;
import servicios.ProductoUsuario;

public class EjemplarTest {
	
	private Ejemplar ej;
	private Autor autor;
	private Genero genero;
	private ProductoUsuario usuario;
	private Editorial editorial;
	private Editorial editorial2;
	private Idioma idioma;
	private Idioma idioma2;
	private Libro libro;
	private Libro libro2;
	
	

	@Before
	public void setUp() throws Exception {
		ej = new Ejemplar(50, true, "a", autor, genero, usuario, 12, editorial, 3, idioma, 300);
	}

	@After
	public void tearDown() throws Exception {
		ej=null;
	}

	@Test
	public void getCodEjemtest() {
		assertEquals(50, ej.getCodEjem());
	}
	
	@Test
	public void setCodEjemtest() {
		ej.setCodEjem(60);
		assertEquals(60, ej.getCodEjem());
	}
	
	@Test
	public void getEditorialtest() {
		assertEquals(editorial, ej.getEditorial());
	}
	
	@Test
	public void setEditorialtest() {
		ej.setEditorial(editorial2);
		assertEquals(editorial2, ej.getEditorial());
	}
	
	@Test
	public void getEdiciontest() {
		assertEquals(3, ej.getEdicion());
	}

	@Test
	public void setEdiciontest() {
		ej.setEdicion(4);
		assertEquals(4, ej.getEdicion());
	}
	
	@Test
	public void getLibrotest() {
		assertEquals(libro, ej.getLibro());
	}
	
	@Test
	public void setLibrotest() {
		ej.setLibro(libro2);
		assertEquals(libro2, ej.getLibro());
	}
	@Test
	public void getIdiomatest() {
		assertEquals(idioma, ej.getIdioma());
	}
	@Test
	public void setIdioma() {
		ej.setIdioma(idioma2);
		assertEquals(idioma2, ej.getIdioma());
	}
	
	@Test
	public void getNumPagtest() {
		assertEquals(300, ej.getNumPag());
	}
	
	@Test
	public void setNumPagtest() {
		ej.setNumPag(400);
		assertEquals(400, ej.getNumPag());
	}
}
