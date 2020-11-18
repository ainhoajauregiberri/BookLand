package productos.libros;
import productos.Libro;
import servicios.ProductoUsuario;

/**
 * Clase que representa a los ejemplares. Puede haber más de un ejemplar del mismo libro,
 * pero con distinta editorial o edición.
 * @author ainhoa y lorea
 *
 */
public class Ejemplar extends Libro {
	
	private int codEjem;
	private Editorial editorial;
	private Libro libro;
	private int edicion;
	private Idioma idioma;
	private int numPag;
	
	public int getCodEjem() {
		return codEjem;
	}
	public void setCodEjem(int codEjem) {
		this.codEjem = codEjem;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getEdicion() {
		return edicion;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public Ejemplar(int codEjem,boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario,
			int edadRecLibro, Editorial editorial, int edicion, Idioma idioma, int numPag) {
		super(disponible, tiutlo, autor, genero, usuario, edadRecLibro);
		this.codEjem=codEjem;
		this.editorial = editorial;
		this.edicion = edicion;
		this.idioma = idioma;
		this.numPag = numPag;
	}
	
	
	

}