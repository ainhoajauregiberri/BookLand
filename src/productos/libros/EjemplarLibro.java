package productos.libros;

public class EjemplarLibro {

	private int codEjem;
	private String titulo;
	
	public EjemplarLibro(int codEjem, String titulo) {
		super();
		this.codEjem = codEjem;
		this.titulo=titulo;
	}

	public int getCodEjem() {
		return codEjem;
	}

	public void setCodEjem(int codEjem) {
		this.codEjem = codEjem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return titulo;
	}
	
	
	
	
}
