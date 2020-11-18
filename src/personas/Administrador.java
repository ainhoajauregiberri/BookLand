package personas;

import java.sql.Date;

/**
 * Clase que representa a los administradores. También son personas.
 * @author ainhoa y lorea
 *
 */
public class Administrador extends Persona {
	
	private int nivel;

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Administrador(String nombre, String usuario, String contrasenya, String fecNac, String sexo, int nivel) {
		super(nombre, usuario, contrasenya, fecNac, sexo);
		this.nivel = nivel;
	}

	

}
