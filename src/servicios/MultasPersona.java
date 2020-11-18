package servicios;

import sqlite.GestionBD;

/**
 * Relaciona las personas con sus correspondientes multas
 * @author ainhoa y lorea
 *
 */
public class MultasPersona {

	/**
	 * El codigo del usuario
	 */
	private int usuarioPersona;
	/**
	 * El codigo del ejemplar. Pude haber mas de un ejemplar por 
	 * cada libro
	 */
	private int codEjem;
	
	public MultasPersona(int usuarioPersona, int codEjem) {
		super();
		this.usuarioPersona = usuarioPersona;
		this.codEjem = codEjem;
	}

	public int getUsuarioPersona() {
		return usuarioPersona;
	}

	public void setUsuarioPersona(int usuarioPersona) {
		this.usuarioPersona = usuarioPersona;
	}

	public int getcodEjem() {
		return codEjem;
	}


	public void setcodEjem(int codEjem) {
		this.codEjem = codEjem;
	}

	/**
	 * @return un string donde aparece el nombre del usuario con su correspondiente
	 * multa indicado por el numero del ejemplar del libro
	 */
	@Override
	public String toString() {
		GestionBD bd = new GestionBD("BookLand.db");
		return "Usuario: "+bd.devolverUsuario(usuarioPersona) +" Ejemplar: "+codEjem;
	}
	
	
	
}
