package servicios;

import personas.Usuario;

public class CuentacuentosUsuario {

	private Usuario usuario;
	private Cuentacuentos cuentacuentos;
	public CuentacuentosUsuario(Usuario usuario, Cuentacuentos cuentacuentos) {
		super();
		this.usuario = usuario;
		this.cuentacuentos = cuentacuentos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cuentacuentos getCuentacuentos() {
		return cuentacuentos;
	}
	public void setCuentacuentos(Cuentacuentos cuentacuentos) {
		this.cuentacuentos = cuentacuentos;
	}
	
	
}
