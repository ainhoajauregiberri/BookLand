package productos.libros;

/**
 * Clase que representa los generos de los libros de la biblioteca.
 * @author ainhoa y lorea
 *
 */

public class Genero {

	private String nomGen;

	public String getNomGen() {
		return nomGen;
	}

	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}

	public Genero(String nomGen) {
		this.nomGen = nomGen;
	}

	@Override
	public String toString() {
		return nomGen;
	}
	

	
}
