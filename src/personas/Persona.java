package personas;
import java.sql.Date;

public abstract class Persona {
	
	private int codPers;
	private String nombre;
	private String usuario;
	private String contrasenya;
	private Date fecNac;
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
	public Date getFecNac() {
		return fecNac;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Persona(String nombre, String usuario, String contrasenya, Date fecNac, String sexo) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.fecNac = fecNac;
		this.sexo = sexo;
	}
	
	

}
