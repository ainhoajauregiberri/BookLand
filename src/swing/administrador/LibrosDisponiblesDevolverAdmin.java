package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Usuario;
import productos.Producto;
import productos.libros.Ejemplar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrosDisponiblesDevolverAdmin extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
	private Producto producto;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param producto 
	 * @param usuario 
	 */
	public LibrosDisponiblesDevolverAdmin(Usuario usuario, Producto producto) {
		this.usuario=usuario;
		this.producto=producto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Volver");
		button.setBounds(15, 16, 85, 29);
		contentPane.add(button);
		
		JLabel lblLibrosPrestados = new JLabel("Libros prestados");
		lblLibrosPrestados.setBounds(149, 52, 130, 20);
		contentPane.add(lblLibrosPrestados);
		
		JList list = new JList();
		list.setBounds(44, 88, 333, 116);
		contentPane.add(list);
		
		JButton button_1 = new JButton("Devolver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devolverLibro((Ejemplar)list.getSelectedValue(), usuario);
				JOptionPane.showMessageDialog(LibrosDisponiblesDevolverAdmin.this, "El libro ha sido devuelto");
			}
		});
		button_1.setBounds(149, 215, 115, 29);
		contentPane.add(button_1);
	}

}
