package servicios;

import java.sql.Date;

import personas.Usuario;
import productos.Producto;

public class ProductoUsuario {

	private Usuario usuario;
	private Producto producto;
	private Date FecIni;
	private Date FecFin;
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
		return FecIni;
	}
	public void setFecIni(Date fecIni) {
		FecIni = fecIni;
	}
	public Date getFecFin() {
		return FecFin;
	}
	public void setFecFin(Date fecFin) {
		FecFin = fecFin;
	}
	public ProductoUsuario(Usuario usuario, Producto producto, Date fecIni, Date fecFin) {
		this.usuario = usuario;
		this.producto = producto;
		FecIni = fecIni;
		FecFin = fecFin;
	}

	
}
