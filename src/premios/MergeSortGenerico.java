package premios;

import java.util.Comparator;

/**
 * Esta es la clase para ordenar un array genérico con el método mergeSort
 * Después se instanciará con 3 tipos de variables distintas para conseguir arrays ordenados
 * @author ainhoa y lorea
 *
 */

public class MergeSortGenerico<T extends Comparator<? super T>> {

	
	/**
	 * Este método dividirá el array y hará una llamdas recursivas a este mismo método
	 * Cuando llegue al caso base hará llamada a la función merge, para ir ordenando partes pequeñas
	 * Así, irá hacia atrás en el árbol dividido hasta conseguir el array completamente ordenado
	 * @param array es el array genérico que queremos ordenar
	 * @param inicio es la posición de inicio
	 * @param fin es la posición del final
	 * @param mitadArry es la posición de la mitad del array
	 */
	public void mergeSort(T[]array, int inicio, int fin) {
		if(inicio<fin) {
			int mitadArray=(inicio+fin)/2;
			mergeSort(array,inicio,mitadArray);
			mergeSort(array,mitadArray+1,fin);
			merge(array,inicio,mitadArray,fin);
		}
	}
	
	/**
	 * Este método ordenará el array genérico recibido
	 * @param array es el array genérico que queremos ordenar
	 * @param inicio es la posición de inicio
	 * @param fin es la posición del final
	 * @param mitadArry es la posición de la mitad del array
	 */
	public void merge(T[]array, int inicio, int mitadArray, int fin) {
		T[] arrayIzquierda = (T[]) new Comparator[mitadArray-inicio+1];
		T[] arrayDerecha = (T[]) new Comparator[fin-mitadArray];
		
		for (int i = 0; i < arrayIzquierda.length; i++) {
			arrayIzquierda[i] = array[inicio + i];
		}
		for (int i = 0; i < arrayDerecha.length; i++) {
			arrayDerecha[i] = array[mitadArray + 1 + i];
		}
		
		int valorIzquierda = 0;
		int valorDerecha = 0;
		int valorActual = inicio;
		
		while(valorIzquierda < arrayIzquierda.length && valorDerecha < arrayDerecha.length) {
			if(compare(arrayIzquierda[valorIzquierda],arrayDerecha[valorDerecha])<= 0) {
				array[valorActual] = arrayIzquierda[valorIzquierda];
				valorIzquierda++;
			}else {
				array[valorActual] = arrayDerecha[valorDerecha];
				valorDerecha++;
			}
			valorActual++;
		}
		
		while(valorIzquierda < arrayIzquierda.length) {
			array[valorActual++] = arrayIzquierda[valorIzquierda++];
		}
		
		while(valorDerecha < arrayDerecha.length) {
			array[valorActual++] = arrayDerecha[valorDerecha++];
		}
	}
	
	/**
	 * Este método establecerá el criterio con el que queremos comparar el array
	 * Se hará un @override de este método en cada uno de los tipos de variable por los que sustituirá la T.
	 */
	private int compare(T t, T t2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
