package productos;

import productos.libros.Autor;
import productos.libros.Genero;
import servicios.ProductoUsuario;

/**
 * Representa los atributos que tienen los libros.
 * @author ainhoa y lorea
 *
 */
public class Libro extends Producto {
	
	private int edadRecLibro;

	public int getEdadRecLibro() {
		return edadRecLibro;
	}

	public void setEdadRecLibro(int edadRecLibro) {
		this.edadRecLibro = edadRecLibro;
	}

	public Libro(boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario,
			int edadRecLibro) {
		super(disponible, tiutlo, autor, genero, usuario);
		this.edadRecLibro = edadRecLibro;
	}

	
	
	
	
}
