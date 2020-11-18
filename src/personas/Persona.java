package personas;
import java.sql.Date;
import java.util.HashMap;

import sqlite.GestionBD;

/**
 * Clase que representa a las personas. Esta clase tiene
 * los atributos que comparten tanto los usuarios como los administradores.
 * @author ainhoa y lorea
 *
 */
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
	
	
	/**
	 *En este método se devulve el usuario como String. Cuando pidamos al programa
	 *que nos muestre una persona en una lista aparecerá su nombre de usuario
	 *@return el String del usuario de la persona
	 */
	@Override
	public String toString() {
		return usuario ;
	}
	
	

}
