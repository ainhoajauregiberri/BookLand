package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import productos.libros.EjemplarLibro;

public class EjemplarLibroTest {
	
	private EjemplarLibro ejemplar;

	@Before
	public void setUp() throws Exception {
		ejemplar = new EjemplarLibro(100, "a");
	}

	@After
	public void tearDown() throws Exception {
		ejemplar=null;
	}

	@Test
	public void getCodEjemtest() {
		assertEquals(100, ejemplar.getCodEjem());;
	}

	@Test
	public void setCodEjemtest() {
		ejemplar.setCodEjem(120);
		assertEquals(120, ejemplar.getCodEjem());;
	}
	
	@Test
	public void getTitulotest() {
		assertEquals("a", ejemplar.getTitulo());;
	}
	
	@Test
	public void setTitulotest() {
		ejemplar.setTitulo("b");
		assertEquals("b", ejemplar.getTitulo());;
	}


}
