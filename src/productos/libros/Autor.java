package productos.libros;

public class Autor {
	
	private String nomAutor;

	public Autor(String nombre) {
		this.nomAutor = nombre;
	}

	public String getNombre() {
		return nomAutor;
	}

	public void setNombre(String nombre) {
		this.nomAutor = nombre;
	}

	@Override
	public String toString() {
		return nomAutor;
	}
	
	

}
