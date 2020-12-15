package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.libros.Editorial;

public class EditorialTest {

	private Editorial editorial;
	
	@Before
	public void setUp() throws Exception {
		editorial = new Editorial("Erein");
	}

	@After
	public void tearDown() throws Exception {
		editorial = null;
	}

	@Test
	public void getNombreEditorialTest() {
		assertEquals("Erein", editorial.getNomEditorial());
	}
	
	@Test
	public void setNombreEditorialTest() {
		editorial.setNomEditorial("Planetadelibros");
		assertEquals("Planetadelibros", editorial.getNomEditorial());
	}

}
