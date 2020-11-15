package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnproductosPrestados = new JButton("Productos prestados");
		btnproductosPrestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosPrestados productosPrestados =new ProductosPrestados();
				productosPrestados.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnproductosPrestados.setBounds(39, 53, 183, 29);
		contentPane.add(btnproductosPrestados);
		
		JButton btnBuscarLibros = new JButton("Buscar libros");
		btnBuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarLibros buscarLibros=new BuscarLibros();
				buscarLibros.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnBuscarLibros.setBounds(39, 94, 183, 29);
		contentPane.add(btnBuscarLibros);
		
		JButton btnBuscarCD = new JButton("Buscar CD");
		btnBuscarCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarCD buscarCD=new BuscarCD();
				buscarCD.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnBuscarCD.setBounds(39, 135, 183, 29);
		contentPane.add(btnBuscarCD);
		
		JButton btnBuscarPelicula = new JButton("Buscar pelicula");
		btnBuscarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPelicula buscarPelicula=new BuscarPelicula();
				buscarPelicula.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnBuscarPelicula.setBounds(39, 176, 183, 29);
		contentPane.add(btnBuscarPelicula);
		
		JButton btnBuscarVideojuego = new JButton("Buscar videojuego");
		btnBuscarVideojuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarVideojuego buscarVideojuego=new BuscarVideojuego();
				buscarVideojuego.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnBuscarVideojuego.setBounds(39, 217, 183, 29);
		contentPane.add(btnBuscarVideojuego);
		
		JButton btnOrdenador = new JButton("Ordenador");
		btnOrdenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdenadorJ ordenadorJ=new OrdenadorJ();
				ordenadorJ.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnOrdenador.setBounds(269, 53, 147, 29);
		contentPane.add(btnOrdenador);
		
		JButton btnCuentacuentos = new JButton("Cuentacuentos");
		btnCuentacuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentacuentosJ cuentacuentosJ=new CuentacuentosJ();
				cuentacuentosJ.setVisible(true);
				VentanaUsuario.this.dispose();
			}
		});
		btnCuentacuentos.setBounds(269, 94, 147, 29);
		contentPane.add(btnCuentacuentos);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setBounds(97, 21, 82, 16);
		contentPane.add(lblProductos);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setBounds(310, 21, 73, 16);
		contentPane.add(lblServicios);
	}
}
