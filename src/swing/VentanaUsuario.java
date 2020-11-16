package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private static Persona persona;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public VentanaUsuario(Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.persona=persona;
		
		JButton btnproductosPrestados = new JButton("Productos prestados");
		btnproductosPrestados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosPrestados productosPrestados =new ProductosPrestados(VentanaUsuario.persona);
				productosPrestados.setVisible(true);
				VentanaUsuario.this.dispose();
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
}
