package servicios;

public class Ordenador {
	
	public int codOrdenador;
	public boolean disponibleOrdenador;
	public int getNumOrdenador() {
		return codOrdenador;
	}
	public void setNumOrdenador(int numOrdenador) {
		this.codOrdenador = numOrdenador;
	}
	public boolean isDisponibleOrdenador() {
		return disponibleOrdenador;
	}
	public void setDisponibleOrdenador(boolean disponibleOrdenador) {
		this.disponibleOrdenador = disponibleOrdenador;
	}
	public Ordenador(int numOrdenador, boolean disponibleOrdenador) {
		this.codOrdenador = numOrdenador;
		this.disponibleOrdenador = disponibleOrdenador;
	}
	
	

}
