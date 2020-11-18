package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Persona;
/**
 * Para testear los metodos de la clase de Persona
 * @author ainhoa y lorea
 *
 */
public class PersonaTest {
	
	private Persona persona;

	@Before
	public void setUp() throws Exception {
		persona = new Persona("lourdes","lourdes10","943375432","1964-09-09","chica");
	}

	@After
	public void tearDown() throws Exception {
		persona=null;
	}

	@Test
	public void testComprobarUsuario() {
		assertEquals(persona.getNombre(), "lourdes");
	}

}
