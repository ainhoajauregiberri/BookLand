package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario frame = new VentanaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnproductosPrestados = new JButton("Productos prestados");
		btnproductosPrestados.setBounds(39, 53, 173, 29);
		contentPane.add(btnproductosPrestados);
		
		JButton btnBuscarLibros = new JButton("Buscar libros");
		btnBuscarLibros.setBounds(39, 94, 173, 29);
		contentPane.add(btnBuscarLibros);
		
		JButton btnBuscarCD = new JButton("Buscar CD");
		btnBuscarCD.setBounds(39, 135, 173, 29);
		contentPane.add(btnBuscarCD);
		
		JButton btnBuscarPelicula = new JButton("Buscar película");
		btnBuscarPelicula.setBounds(39, 176, 173, 29);
		contentPane.add(btnBuscarPelicula);
		
		JButton btnBuscarVideojuego = new JButton("Buscar videojuego");
		btnBuscarVideojuego.setBounds(39, 217, 173, 29);
		contentPane.add(btnBuscarVideojuego);
		
		JButton btnOrdendor = new JButton("Ordenador");
		btnOrdendor.setBounds(269, 53, 147, 29);
		contentPane.add(btnOrdendor);
		
		JButton btnContacuentos = new JButton("Contacuentos");
		btnContacuentos.setBounds(269, 94, 147, 29);
		contentPane.add(btnContacuentos);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(93, 25, 82, 16);
		contentPane.add(lblProductos);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(309, 25, 61, 16);
		contentPane.add(lblServicios);
	}
}
