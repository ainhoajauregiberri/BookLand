package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.libros.Autor;
import productos.libros.Editorial;

public class AutorTest {

private Autor autor;
	
	@Before
	public void setUp() throws Exception {
		autor = new Autor("Bernardo Atxaga");
	}

	@After
	public void tearDown() throws Exception {
		autor = null;
	}

	@Test
	public void getNombreEditorialTest() {
		assertEquals("Bernardo Atxaga", autor.getNombre());
	}
	
	@Test
	public void setNombreEditorialTest() {
		autor.setNombre("Isabel Allende");
		assertEquals("Isabel Allende", autor.getNombre());
	}

}
