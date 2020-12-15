package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.Libro;
import productos.Producto;
import productos.libros.Autor;
import productos.libros.Genero;
import servicios.ProductoUsuario;

public class ProductoTest {
	
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
	public void isDisponibletest() {
		assertEquals(false, libro.isDisponible());
	}

	@Test
	public void setDisponibletest() {
		libro.setDisponible(true);
		assertEquals(true, libro.isDisponible());
	}
	
	@Test
	public void getTiutlotest() {
		assertEquals("Annie Hall", libro.getTitulo());
	}

	@Test
	public void setTitulotest() {
		libro.setTitulo("Manhattan");
		assertEquals(true, libro.getTitulo());
	}
	
	@Test
	public void getAutortest() {
		assertEquals(autor, libro.getAutor());
	}

	@Test
	public void setAutortest() {
		libro.setAutor(autor2);
		assertEquals(autor2, libro.getAutor());
	}
	
	@Test
	public void getGenerotest() {
		assertEquals(genero, libro.getGenero());
	}

	@Test
	public void setGenerotest() {
		libro.setGenero(genero2);
		assertEquals(genero2, libro.getGenero());
	}
	
	@Test
	public void getUsuariotest() {
		assertEquals(usuario, libro.getUsuario());
	}

	@Test
	public void setUsuariotest() {
		libro.setUsuario(usuario2);
		assertEquals(usuario2, libro.getUsuario());
	}
	
}
