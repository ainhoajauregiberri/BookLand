package servicios;

import sqlite.GestionBD;

public class MultasPersona {

	private int usuarioPersona;
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

	public int getTitulo() {
		return codEjem;
	}

	public void setTitulo(int codEjem) {
		this.codEjem = codEjem;
	}

	@Override
	public String toString() {
		GestionBD bd = new GestionBD("BookLand.db");
		return "Usuario: "+bd.devolverUsuario(usuarioPersona) +" Ejemplar: "+codEjem;
	}
	
	
	
}
