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
	
	private PersonaPagina personaPagina1;
	private PersonaPagina personaPagina2;
	private PersonaPagina[] personasPaginas;
	
	@Before
	public void setUp() {
		
		personaPagina1 = new PersonaPagina("Ainhoa Jauregiberri",130);
		personaPagina2 = new PersonaPagina("Lorea Intxausti",140);
		personasPaginas= new PersonaPagina[2];
		personasPaginas[0]= personaPagina1;
		personasPaginas[1]= personaPagina2;
		
	}
	
	@Before
	public void tearDown() {
		
		personaPagina1 = null;
		personaPagina2 = null;
		personasPaginas= null;
	}
	
	@Test
	public void test() {
		
		PersonaPagina[] personasPaginasOrdenados= new PersonaPagina[2];
		personasPaginasOrdenados[0]=personaPagina2;
		personasPaginasOrdenados[1]=personaPagina1;
		
		MergeSortGenerico msg = new MergeSortGenerico<PersonaPagina>();
		msg.mergeSort(personasPaginas, 0, personasPaginas.length-1);
	
		
		for(int i=0; i<=personasPaginas.length;i++) {
			assertEquals(personasPaginas[i].getNumPagTotal(),personasPaginasOrdenados[i].getNumPagTotal());
		}
		
	}

	

}
