package servicios;

import java.sql.Date;
import java.util.ArrayList;
import personas.Usuario;

public class Cuentacuentos {

	private Date fechaCuentacuentos;
	private int aforo;
	private String nombre;
	private String descripcion;
	private ArrayList<Usuario> usuarios;
	public Date getFechaCuentacuentos() {
		return fechaCuentacuentos;
	}
	public void setFechaCuentacuentos(Date fechaCuentacuentos) {
		this.fechaCuentacuentos = fechaCuentacuentos;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Cuentacuentos(Date fechaCuentacuentos, int aforo, String nombre, String descripcion,
			ArrayList<Usuario> usuarios) {
		this.fechaCuentacuentos = fechaCuentacuentos;
		this.aforo = aforo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}
	
	
}
