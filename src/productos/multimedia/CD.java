package productos.multimedia;
import productos.Producto;
import productos.libros.Autor;
import productos.libros.Genero;
import servicios.ProductoUsuario;

public class CD extends Producto{

	public CD(boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario) {
		super(disponible, tiutlo, autor, genero, usuario);
	}

}
