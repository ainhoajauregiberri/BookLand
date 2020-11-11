package servicios;
import java.sql.Date;

import personas.Usuario;
import servicios.Ordenador;

public class OrdenadorUsuario {

	private Usuario usuario;
	private Ordenador ordenador;
	private Date fecIni;
	private Date fecFin;
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
	public OrdenadorUsuario(Usuario usuario, Ordenador ordenador, Date fecIni, Date fecFin) {
		this.usuario = usuario;
		this.ordenador = ordenador;
		fecIni = fecIni;
		fecFin = fecFin;
	}
	
	
}
