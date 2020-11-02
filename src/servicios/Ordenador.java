package servicios;

public class Ordenador {
	
	public int numOrdenador;
	public boolean disponibleOrdenador;
	public int getNumOrdenador() {
		return numOrdenador;
	}
	public void setNumOrdenador(int numOrdenador) {
		this.numOrdenador = numOrdenador;
	}
	public boolean isDisponibleOrdenador() {
		return disponibleOrdenador;
	}
	public void setDisponibleOrdenador(boolean disponibleOrdenador) {
		this.disponibleOrdenador = disponibleOrdenador;
	}
	public Ordenador(int numOrdenador, boolean disponibleOrdenador) {
		this.numOrdenador = numOrdenador;
		this.disponibleOrdenador = disponibleOrdenador;
	}
	
	

}
