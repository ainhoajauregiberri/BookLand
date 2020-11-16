package JUnit;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sqlite.GestionBD;

public class TestGestionBD {
	
	private GestionBD bd;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void setUp(){
		
		bd = new GestionBD("BookLand.db");
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	public void testEstablecerConexion() {
		bd.establecerConexion();
		assertNotNull(bd.getConn());
	}
	
	public void testCreateDB(){
		bd.createDB();
		String url = bd.getUrl();
		File aFile = new File(url);
		assertTrue(aFile.exists());
	}
	
	public void testCrearModificarBorrarTabla (){
		String sql = "CREATE TABLE IF NOT EXISTS Prueba (\n"
					+"codPrueba integer PRIMARY KEY,\n"
					+ ");";
		bd.crearModificarBorrarTabla(sql);
		String sql2 = "SELECT name FROM sqlite_master WHERE type='table' AND name='Prueba'";
		
				
	}
	
	

}
