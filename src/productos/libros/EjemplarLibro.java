package productos.libros;


/**
 * Clase que relaciona el c�digo de un ejemplar y el t�tulo. Es una clase que creamos 
 * para poder insertar ciertos m�todos.
 * @author ainhoa y lorea
 *
 */
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

	
	/**
	 * M�todo que devulve el t�tulo como String, lo usaremos para sacarlo en una lista
	 * @return titulo del ejemplar
	 *
	 */
	@Override
	public String toString() {
		return titulo;
	}
	
	
	
	
}
