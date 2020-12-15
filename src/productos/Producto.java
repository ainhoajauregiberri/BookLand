package productos;
import servicios.ProductoUsuario;
import productos.libros.Autor;
import productos.libros.Genero;

/**
 * Representa los atributos que tienen en comun todos los productos
 * de la biblioteca
 * @author ainhoa y lorea
 *
 */
public abstract class Producto {
	private boolean disponible;
	private String titulo;
	private Autor autor;
	private Genero genero;
	private ProductoUsuario usuario;
	
	
	public Producto(boolean disponible, String titulo, Autor autor, Genero genero, ProductoUsuario usuario) {
		this.disponible = disponible;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.usuario = usuario;
	}


	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public ProductoUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(ProductoUsuario usuario) {
		this.usuario = usuario;
	}

	

}
