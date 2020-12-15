package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import personas.Usuario;
import productos.Producto;
import servicios.ProductoUsuario;

public class ProductoUsuarioTest {
	
	private ProductoUsuario prousu;
	private Usuario usuario;
	private Usuario usuario2;
	private Producto producto;
	private Producto producto2;
	
	

	@Before
	public void setUp() throws Exception {
		prousu = new ProductoUsuario(usuario, producto, "2020-12-13", "2020-12-24", true);
	}

	@After
	public void tearDown() throws Exception {
		prousu= null;
	}

	@Test
	public void getUsuariotest() {
		assertEquals(usuario, prousu.getUsuario());
	}
	
	@Test
	public void setUsuariotest() {
		prousu.setUsuario(usuario2);
		assertEquals(usuario2, prousu.getUsuario());
	}
	
	@Test
	public void getProdutotest() {
		assertEquals(producto, prousu.getProducto());
	}
	
	@Test
	public void setProdutotest() {
		prousu.setProducto(producto2);
		assertEquals(producto2, prousu.getProducto());
	}
	
	@Test
	public void getFecInitest() {
		assertEquals("2020-12-13", prousu.getFecIni());
	}
	
	@Test
	public void setFecInitest() {
		prousu.setFecIni("2020-12-01");
		assertEquals("2020-12-01", prousu.getFecIni());
	}
	@Test
	public void getFecFintest() {
		assertEquals("2020-12-24", prousu.getFecFin());
	}
	
	@Test
	public void setFecFintest() {
		prousu.setFecFin("2020-12-30");
		assertEquals("2020-12-30", prousu.getFecFin());
	}
	@Test
	public void isPrestadotest() {
		assertTrue(prousu.isPrestado());
	}
	
	@Test
	public void setPrestadotest() {
		prousu.setPrestado(false);
		assertFalse(prousu.isPrestado());
	}
	

}
