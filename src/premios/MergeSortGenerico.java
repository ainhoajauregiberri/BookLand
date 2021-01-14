package premios;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Esta es la clase para ordenar un array gen�rico con el m�todo mergeSort
 * Despu�s se instanciar� con 3 tipos de variables distintas para conseguir arrays ordenados
 * @author ainhoa y lorea
 *
 */

public class MergeSortGenerico<T extends Comparator<? super T>> {

	private T[] arrayUno;
	private T[] arrayDos;
	private T[] arrayDefinitivo;
	/**
	 * Este m�todo dividir� el array y har� una llamdas recursivas a este mismo m�todo
	 * Cuando llegue al caso base har� llamada a la funci�n merge, para ir ordenando partes peque�as
	 * As�, ir� hacia atr�s en el �rbol dividido hasta conseguir el array completamente ordenado
	 * @param array es el array gen�rico que queremos ordenar
	 * @param inicio es la posici�n de inicio
	 * @param fin es la posici�n del final
	 * @param mitadArry es la posici�n de la mitad del array
	 */
	public T[] mergeSort(T[]array) {
		if (array.length==1){
			return array;
		}
		else {
			arrayUno = Arrays.copyOfRange(array, 0, (array.length)/2);
			arrayDos = Arrays.copyOfRange(array, (array.length)/2, array.length);
			arrayUno = mergeSort(arrayUno);
			arrayDos = mergeSort(arrayDos);
					
			return merge(arrayUno, arrayDos);
		}
	}
	
	/**
	 * Este m�todo ordenar� el array gen�rico recibido
	 * @param array es el array gen�rico que queremos ordenar
	 * @param inicio es la posici�n de inicio
	 * @param fin es la posici�n del final
	 * @param mitadArry es la posici�n de la mitad del array
	 */
	public T[] merge(T[]arrayIzquierda, T[]arrayDerecha) {

		if(arrayIzquierda[0] instanceof PersonaPagina) {
			arrayDefinitivo=(T[]) new PersonaPagina[arrayIzquierda.length+arrayDerecha.length];
		}
		if(arrayIzquierda[0] instanceof PersonaPaginaEuskera) {
			arrayDefinitivo=(T[]) new PersonaPaginaEuskera[arrayIzquierda.length+arrayDerecha.length];
		}
		if(arrayIzquierda[0] instanceof EditorialLibros) {
			arrayDefinitivo=(T[]) new EditorialLibros[arrayIzquierda.length+arrayDerecha.length];
		}
		
		int valorIzquierda = 0;
		int valorDerecha = 0;
		int valorActual = 0;
		
		while(valorIzquierda < arrayIzquierda.length && valorDerecha < arrayDerecha.length) {
			if(compare(arrayIzquierda[valorIzquierda],arrayDerecha[valorDerecha])<= 0) {
				arrayDefinitivo[valorActual] = arrayIzquierda[valorIzquierda];
				valorIzquierda++;
			}else {
				arrayDefinitivo[valorActual] = arrayDerecha[valorDerecha];
				valorDerecha++;
			}
			valorActual++;
		}
		
		while(valorIzquierda < arrayIzquierda.length) {
			arrayDefinitivo[valorActual++] = arrayIzquierda[valorIzquierda++];
		}
		
		while(valorDerecha < arrayDerecha.length) {
			arrayDefinitivo[valorActual++] = arrayDerecha[valorDerecha++];
		}
		
		return arrayDefinitivo;
	}
	
	/**
	 * Este m�todo establecer� el criterio con el que queremos comparar el array
	 * Se har� un @override de este m�todo en cada uno de los tipos de variable por los que sustituir� la T.
	 */
	private int compare(T t, T t2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
