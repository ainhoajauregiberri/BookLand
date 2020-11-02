package personas;
import java.sql.Date;
import java.util.ArrayList;
import servicios.ProductoUsuario;

public class Usuario extends Persona {
	
	private Date FecAlta;
	private ArrayList<ProductoUsuario> productos;
	private float dinero;
	
	public Date getFecAlta() {
		return FecAlta;
	}
	public void setFecAlta(Date fecAlta) {
		FecAlta = fecAlta;
	}
	public ArrayList<ProductoUsuario> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<ProductoUsuario> productos) {
		this.productos = productos;
	}
	public float getDinero() {
		return dinero;
	}
	public void setDinero(float dinero) {
		this.dinero = dinero;
	}
	public Usuario(String nombre, String usuario, String contrasenya, Date fecNac, String sexo, Date fecAlta,
			ArrayList<ProductoUsuario> productos, float dinero) {
		super(nombre, usuario, contrasenya, fecNac, sexo);
		FecAlta = fecAlta;
		this.productos = productos;
		this.dinero = dinero;
	}
	
	
	

}
