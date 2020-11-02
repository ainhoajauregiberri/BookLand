package personas;

import java.sql.Date;

public class Administrador extends Persona {
	
	private int nivel;

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Administrador(String nombre, String usuario, String contrasenya, Date fecNac, String sexo, int nivel) {
		super(nombre, usuario, contrasenya, fecNac, sexo);
		this.nivel = nivel;
	}

	

}
