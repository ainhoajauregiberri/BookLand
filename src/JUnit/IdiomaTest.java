package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.libros.Editorial;
import productos.libros.Idioma;

public class IdiomaTest {

private Idioma idioma;
	
	@Before
	public void setUp() throws Exception {
		idioma = new Idioma("Euskera");
	}

	@After
	public void tearDown() throws Exception {
		idioma = null;
	}

	@Test
	public void getNombreEditorialTest() {
		assertEquals("Euskera", idioma.getIdioma());
	}
	
	@Test
	public void setNombreEditorialTest() {
		idioma.setIdioma("Castellano");
		assertEquals("Castellano", idioma.getIdioma());
	}

}
