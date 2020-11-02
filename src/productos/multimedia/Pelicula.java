package productos.multimedia;
import productos.Producto;
import productos.libros.Autor;
import productos.libros.Genero;
import servicios.ProductoUsuario;

public class Pelicula extends Producto{

	private int edadRecPelicula;

	public int getEdadRecPelicula() {
		return edadRecPelicula;
	}

	public void setEdadRecPelicula(int edadRecPelicula) {
		this.edadRecPelicula = edadRecPelicula;
	}

	public Pelicula(boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario,
			int edadRecPelicula) {
		super(disponible, tiutlo, autor, genero, usuario);
		this.edadRecPelicula = edadRecPelicula;
	}

	
	
	
	
}
