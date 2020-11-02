package productos.libros;
import productos.Libro;
import servicios.ProductoUsuario;

public class Ejemplar extends Libro {
	
	private Editorial editorial;
	private int edicion;
	private Idioma idioma;
	private int numPag;
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getEdicion() {
		return edicion;
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
	public Ejemplar(boolean disponible, String tiutlo, Autor autor, Genero genero, ProductoUsuario usuario,
			int edadRecLibro, Editorial editorial, int edicion, Idioma idioma, int numPag) {
		super(disponible, tiutlo, autor, genero, usuario, edadRecLibro);
		this.editorial = editorial;
		this.edicion = edicion;
		this.idioma = idioma;
		this.numPag = numPag;
	}
	
	
	

}