package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Administrador;

public class AdministradorTest {

	private Administrador ad;
	
	@Before
	public void setUp() throws Exception {
	
		ad = new Administrador("Ainhoa", "ainhoa10", "kaixo1234", "2000-07-10", "chica",1);
	}

	@After
	public void tearDown() throws Exception {
	
		ad=null;
	}

	@Test
	public void getNivelTest() {
		assertEquals(1, ad.getNivel());;
	}
	
	@Test
	public void setNivelTest() {
		ad.setNivel(2);
		assertEquals(2, ad.getNivel());
	}


}
