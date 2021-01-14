package premios;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Esta es la clase para ordenar un array genérico con el método mergeSort
 * Después se instanciará con 3 tipos de variables distintas para conseguir arrays ordenados
 * @author ainhoa y lorea
 *
 */

public class MergeSortGenerico<T extends Comparator<? super T>> {

	private T[] arrayUno;
	private T[] arrayDos;
	private T[] arrayDefinitivo;
	/**
	 * Este método dividirá el array y hará una llamdas recursivas a este mismo método
	 * Cuando llegue al caso base hará llamada a la función merge, para ir ordenando partes pequeñas
	 * Así, irá hacia atrás en el árbol dividido hasta conseguir el array completamente ordenado
	 * @param array es el array genérico que queremos ordenar
	 * @param inicio es la posición de inicio
	 * @param fin es la posición del final
	 * @param mitadArry es la posición de la mitad del array
	 */
	public T[] mergeSort(T[]array) {
		if (array.length==1){
			System.out.println("a");
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
	 * Este método ordenará el array genérico recibido
	 * @param array es el array genérico que queremos ordenar
	 * @param inicio es la posición de inicio
	 * @param fin es la posición del final
	 * @param mitadArry es la posición de la mitad del array
	 */
	public T[] merge(T[]arrayIzquierda, T[]arrayDerecha) {

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
	 * Este método establecerá el criterio con el que queremos comparar el array
	 * Se hará un @override de este método en cada uno de los tipos de variable por los que sustituirá la T.
	 */
	private int compare(T t, T t2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
