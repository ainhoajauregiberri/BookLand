package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.Producto;
import productos.libros.Ejemplar;
import productos.libros.EjemplarLibro;
import sqlite.GestionBD;
import swing.IListasProductos;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class LibrosDisponiblesDevolverAdmin extends JFrame {

	private JPanel contentPane;
	private Persona persona;
	private Producto producto;
	private DefaultListModel dfmEjemplares;
	private JList list;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param producto 
	 * @param usuario 
	 */
	public LibrosDisponiblesDevolverAdmin(Persona persona, String titulo) {
		this.persona=persona;
		this.producto=producto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 99, 279, 93);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		cargarListaEjemplares(titulo);
		
		JButton button = new JButton("Volver");
		button.setBounds(15, 16, 85, 29);
		contentPane.add(button);
		
		JLabel lblLibrosPrestados = new JLabel("Libros prestados");
		lblLibrosPrestados.setBounds(149, 52, 130, 20);
		contentPane.add(lblLibrosPrestados);
		
		GestionBD bd=new GestionBD("BookLand");
		JButton button_1 = new JButton("Devolver");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EjemplarLibro ejemplarLibro=(EjemplarLibro) list.getSelectedValue();
				bd.devolverLibro(ejemplarLibro, persona);
				JOptionPane.showMessageDialog(LibrosDisponiblesDevolverAdmin.this, "El libro ha sido devuelto");
			}
		});
		button_1.setBounds(149, 215, 115, 29);
		contentPane.add(button_1);
		
		
	}
	public void cargarListaEjemplares(String libro) {
		dfmEjemplares=IListasProductos.cargarListaEjemplaresTotales(libro);
		this.list.setModel(dfmEjemplares);
	}
}
