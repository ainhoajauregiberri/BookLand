package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import premios.MergeSortGenerico;

public class MergeSortGenericoTest {

	@Test
	public void test() {

		int[]numeros = {4,5,1,2,10,8,7,3};
		char[] letras = {'b','s','r','a','x','y'};
		
		int[]arrayNumerosOrdenados={1,2,3,4,5,7,8,10};
		char[] arrayLetrasOrdenadas = {'a','b','r','s','x','y'};
		
		MergeSortGenerico msg = new MergeSortGenerico<>();
		msg.mergeSort(numeros, 0, 7);
		
		for(int i=0; i<=7;i++) {
			assertEquals(numeros[i],arrayNumerosOrdenados[i]);
		}
		
	}

}
