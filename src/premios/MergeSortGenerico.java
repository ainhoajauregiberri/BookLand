package premios;

import java.util.Comparator;

public class MergeSortGenerico<T extends Comparator<? super T>> {

	public void mergeSort(T[]array, int inicio, int fin) {
		if(inicio<fin) {
			int mitadArray=(inicio+fin)/2;
			mergeSort(array,inicio,mitadArray);
			mergeSort(array,mitadArray+1,fin);
			merge(array,inicio,mitadArray,fin);
		}
	}
	
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
	
	private int compare(T t, T t2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
