package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.libros.Editorial;
import productos.libros.Genero;

public class GeneroTest {

private Genero genero;
	
	@Before
	public void setUp() throws Exception {
		genero = new Genero("Drama");
	}

	@After
	public void tearDown() throws Exception {
		genero = null;
	}

	@Test
	public void getNombreEditorialTest() {
		assertEquals("Drama", genero.getNomGen());
	}
	
	@Test
	public void setNombreEditorialTest() {
		genero.setNomGen("Fantasia");
		assertEquals("Fantasia", genero.getNomGen());
	}

}
