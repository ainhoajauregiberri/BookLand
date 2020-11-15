package servicios;

import java.sql.Date;

import personas.Usuario;
import productos.Producto;

public class ProductoUsuario {

	private Usuario usuario;
	private Producto producto;
	private String fecIni;
	private String fecFin;
	private boolean prestar;
	
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
	
	public boolean isPrestar() {
		return prestar;
	}
	public void setPrestar(boolean prestar) {
		this.prestar = prestar;
	}
	public ProductoUsuario(Usuario usuario, Producto producto, String fecIni, String fecFin) {
		this.usuario = usuario;
		this.producto = producto;
		this.fecIni = fecIni;
		this.fecFin = fecFin;
		this.prestar = prestar;
	}

	
}
