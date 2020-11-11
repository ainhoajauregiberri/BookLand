package servicios;

import java.sql.Date;

import personas.Usuario;
import productos.Producto;

public class ProductoUsuario {

	private Usuario usuario;
	private Producto producto;
	private Date fecIni;
	private Date fecFin;
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
	public Date getFecIni() {
		return fecIni;
	}
	public void setFecIni(Date fecIni) {
		fecIni = fecIni;
	}
	public Date getFecFin() {
		return fecFin;
	}
	public void setFecFin(Date fecFin) {
		fecFin = fecFin;
	}
	public ProductoUsuario(Usuario usuario, Producto producto, Date fecIni, Date fecFin) {
		this.usuario = usuario;
		this.producto = producto;
		fecIni = fecIni;
		fecFin = fecFin;
	}

	
}
