package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Esta es la clase ventana usuario que sera la primera pestanyaa que vea el usuario
 * despues de haber introducido su usuario y contrasenya correctos. Esta ventana lleva a
 * otras dos ventanas, BuscarLibros y LibrosDisponibles.
 * @author Ainhoa y Lorea
 */
public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private static Persona persona;
	private DefaultListModel dfmTitulos;

	/**
	 * Este es el main para lanzar la aplicaci�n
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario frame = new VentanaUsuario(VentanaUsuario.persona);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Este es el constructor para crear el frame
	 */
	public VentanaUsuario(Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.persona=persona;
		this.dfmTitulos = new DefaultListModel<String>();
		
		JButton btnproductosPrestados = new JButton("Productos prestados");
		btnproductosPrestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean tieneLibros= mirarSiProductos(persona);
				if (tieneLibros) {
					ProductosPrestados productosPrestados =new ProductosPrestados(VentanaUsuario.persona);
					productosPrestados.setVisible(true);
					VentanaUsuario.this.dispose();
				}
			}
		});
		btnproductosPrestados.setBounds(146, 53, 183, 29);
		contentPane.add(btnproductosPrestados);
		
		JButton btnBuscarLibros = new JButton("Buscar libros");
		btnBuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarLibros buscarLibros=new BuscarLibros(VentanaUsuario.persona);
				buscarLibros.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnBuscarLibros.setBounds(146, 95, 183, 29);
		contentPane.add(btnBuscarLibros);
		
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(206, 24, 82, 16);
		contentPane.add(lblProductos);
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceso v = new Acceso();
				v.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		button.setBounds(6, 6, 87, 29);
		contentPane.add(button);
		
	}
	
	public boolean mirarSiProductos(Persona persona) {
		boolean tiene=true;
		dfmTitulos=IListasProductos.cargarListaProductos(persona);
		if(dfmTitulos.isEmpty()) {
			JOptionPane.showMessageDialog(VentanaUsuario.this, "No tiene ningun libro prestado");
			tiene=false;
		}return tiene;
	}	
}
