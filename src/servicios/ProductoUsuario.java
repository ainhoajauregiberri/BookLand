package servicios;

import java.sql.Date;

import personas.Usuario;
import productos.Producto;

/**
 * Realciona el usuario con los productos que tiene o ha tenido prestados
 * @author ainhoa
 *
 */
public class ProductoUsuario {

	private Usuario usuario;
	private Producto producto;
	/**
	 * La fecha en la que presto el libro
	 */
	private String fecIni;
	/**
	 * La fecha en la que tiene que devolver o devolvio el libro
	 */
	private String fecFin;
	/**
	 * Indica si el libro esta prestado o no. Sirve para tener un
	 * historial de los libros que se prestan a cada usuario
	 */
	private boolean prestado;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getFecIni() {
		return fecIni;
	}
	public void setFecIni(String fecIni) {
		this.fecIni = fecIni;
	}
	public String getFecFin() {
		return fecFin;
	}
	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}
	
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public ProductoUsuario(Usuario usuario, Producto producto, String fecIni, String fecFin, boolean prestado) {
		this.usuario = usuario;
		this.producto = producto;
		this.fecIni = fecIni;
		this.fecFin = fecFin;
		this.prestado = prestado;
	}

	
}
