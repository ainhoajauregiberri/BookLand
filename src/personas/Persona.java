package personas;
import java.sql.Date;
import java.util.HashMap;

import sqlite.GestionBD;

public class Persona {
	
	private String nombre;
	private String usuario;
	private String contrasenya;
	private String fecNac;
	private String sexo;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getFecNac() {
		return fecNac;
	}
	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Persona(String nombre, String usuario, String contrasenya, String fecNac, String sexo) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.fecNac = fecNac;
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", usuario=" + usuario + ", contrasenya=" + contrasenya + ", fecNac="
				+ fecNac + ", sexo=" + sexo + "]";
	}
	
	

}
