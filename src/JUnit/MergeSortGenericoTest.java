package JUnit;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Persona;
import premios.MergeSortGenerico;
import premios.PersonaPagina;

/**
 * Este es el test de la clase MergeSortGenerico, veremos si el array se ordena correctamente
 * @author Ainhoa y Lorea
 */

public class MergeSortGenericoTest {

	/**
	 * Este m�todo probar� si pasandole un array desordenado de ints lo ordena, 
	 * comparandolo con uno ya ordenado
	 * Har� lo mismo con los char
	 */
	
	private Persona p1;
	private Persona p2;
	private PersonaPagina personaPagina1;
	private PersonaPagina personaPagina2;
	private PersonaPagina[] personasPaginas;
	
	@Before
	public void setUp() {
		
		
		
	}
	
	@Before
	public void tearDown() {
		
		personaPagina1 = null;
		personaPagina2 = null;
		personasPaginas= null;
	}
	
	@Test
	public void test() {
		
		p1 = new Persona("Ainhoa Jauregiberri", "ainhoa1","a", "", "");
		p2 = new Persona("Lorea Intxausti", "lorea1", "a", "", "");
		
		personaPagina1 = new PersonaPagina(p1,130);
		personaPagina2 = new PersonaPagina(p2,140);
		personasPaginas= new PersonaPagina[2];
		personasPaginas[0]= personaPagina1;
		personasPaginas[1]= personaPagina2;
		
		PersonaPagina[] personasPaginasOrdenados= {personaPagina2, personaPagina1};
		
		MergeSortGenerico msg = new MergeSortGenerico<PersonaPagina>();
		msg.mergeSort(personasPaginas);
	
		System.out.println(personasPaginas[0].toString());
		
		for(int i=0; i<personasPaginas.length;i++) {
			assertEquals(personasPaginas[i].getNumPagTotal(),personasPaginasOrdenados[i].getNumPagTotal());
		}
		
	}

	

}
