package personas;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import servicios.ProductoUsuario;
import sqlite.GestionBD;

public class Usuario extends Persona {
	
	private String fecAlta;
	private double dinero;
	
	public String getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(String fecAlta) {
		this.fecAlta = fecAlta;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public Usuario(String nombre, String usuario, String contrasenya, String fecNac, String sexo, String fecAlta, double dinero) {
		super(nombre, usuario, contrasenya, fecNac, sexo);
		this.fecAlta = fecAlta;
		this.dinero = dinero;
	}
	

	
	
	

}
