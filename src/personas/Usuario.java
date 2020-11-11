package personas;
import java.sql.Date;
import java.util.ArrayList;
import servicios.ProductoUsuario;

public class Usuario extends Persona {
	
	private Date fecAlta;
	private double dinero;
	
	public Date getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(Date fecAlta) {
		fecAlta = fecAlta;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public Usuario(String nombre, String usuario, String contrasenya, Date fecNac, String sexo, Date fecAlta,
			ArrayList<ProductoUsuario> productos, double dinero) {
		super(nombre, usuario, contrasenya, fecNac, sexo);
		fecAlta = fecAlta;
		this.dinero = dinero;
	}
	
	
	

}
