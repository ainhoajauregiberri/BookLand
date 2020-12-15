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
	public void getNombreTest() {
		assertEquals(persona.getNombre(), "lourdes");
	}
	
	@Test
	public void setNombreTest() {
		persona.setNombre("Miren");
		assertEquals(persona.getNombre(), "Miren");
	}
	
	@Test
	public void getUsuarioTest() {
		assertEquals(persona.getUsuario(), "lourdes10");
	}
	
	@Test
	public void setUsuarioTest() {
		persona.setUsuario("miren10");
		assertEquals(persona.getUsuario(), "miren10");
	}
	
	@Test
	public void toStringTest() {
		assertEquals(persona.toString(), "lourdes10");
	}

}
