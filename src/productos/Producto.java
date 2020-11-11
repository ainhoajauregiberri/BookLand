package productos;
import servicios.ProductoUsuario;
import productos.libros.Autor;
import productos.libros.Genero;

public abstract class Producto {
	private boolean disponible;
	private String tiutlo;
	private Autor autor;
	private Genero genero;
	private ProductoUsuario usuario;
	
	
	public Producto(boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario) {
		super();
		this.disponible = disponible;
		this.tiutlo = tiutlo;
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

	public String getTiutlo() {
		return tiutlo;
	}

	public void setTiutlo(String tiutlo) {
		this.tiutlo = tiutlo;
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
