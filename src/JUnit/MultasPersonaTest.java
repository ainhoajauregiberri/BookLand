package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import servicios.MultasPersona;

public class MultasPersonaTest {

	private MultasPersona mp;
	
	@Before
	public void setUp() throws Exception {
		mp=new MultasPersona(7, 11);
	}

	@After
	public void tearDown() throws Exception {
		mp=null;
	}

	@Test
	public void test() {
		assertEquals(mp.toString(), "Usuario: mikel10 Ejemplar: 11");
	}

}
