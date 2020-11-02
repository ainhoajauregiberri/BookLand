package servicios;
import java.sql.Date;

import personas.Usuario;
import servicios.Ordenador;

public class OrdenadorUsuario {

	private Usuario usuario;
	private Ordenador ordenador;
	private Date FecIni;
	private Date FecFin;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ordenador getOrdenador() {
		return ordenador;
	}
	public void setOrdenador(Ordenador ordenador) {
		this.ordenador = ordenador;
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
	public OrdenadorUsuario(Usuario usuario, Ordenador ordenador, Date fecIni, Date fecFin) {
		this.usuario = usuario;
		this.ordenador = ordenador;
		FecIni = fecIni;
		FecFin = fecFin;
	}
	
	
}
