package productos.libros;

/**
 * Esta es la clase de los autores de los libros que está en la biblioteca
 * En ella aparecen los atributos que tienen en común las clases
 * @author ainhoa y lorea
 *
 */

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
