package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * En esta clase aparecen los ejemplares del título que se ha seleccionado en la ventana anterior
 * @author Ainhoa y Lorea
 */
public class LibrosDisponiblesPrestarAdmin extends JFrame {

	private JPanel contentPane;
	private Usuario usuario;
	private Producto producto;
	private DefaultListModel dfmEjemplares;
	private JList list;
	/**
	 * Este es el main para lanzar la aplicación
	 */
	
	/**
	 * Crear el frame
	 * @param producto 
	 * @param persona
	 * @param libro
	 */
	public LibrosDisponiblesPrestarAdmin(Persona persona, String libro) {
		this.usuario=usuario;
		this.producto=producto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 87, 335, 118);
		contentPane.add(scrollPane_1);
		
		list = new JList();
		scrollPane_1.setViewportView(list);
		
		cargarListaEjemplares(libro);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PrestarLibro v = new PrestarLibro(usuario);
					v.setVisible(true);
					LibrosDisponiblesPrestarAdmin.this.dispose();
			}
		});
		btnVolver.setBounds(15, 16, 85, 29);
		contentPane.add(btnVolver);
		
		JLabel lblEjemplaresPrestados = new JLabel("Ejemplares prestados");
		lblEjemplaresPrestados.setBounds(130, 51, 178, 20);
		contentPane.add(lblEjemplaresPrestados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 222, -327, -112);
		contentPane.add(scrollPane);
		
		GestionBD bd=new GestionBD("BookLand.db");
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EjemplarLibro ejemplarLibro=(EjemplarLibro)list.getSelectedValue();
				bd.prestarLibro(ejemplarLibro, persona);
				JOptionPane.showMessageDialog(LibrosDisponiblesPrestarAdmin.this, "El libro ha sido prestado");
			}
		});
		btnDevolver.setBounds(159, 219, 115, 29);
		contentPane.add(btnDevolver);
		
		
	}
	public void cargarListaEjemplares(String libro) {
		dfmEjemplares=IListasProductos.cargarListaEjemplaresTotales(libro);
		this.list.setModel(dfmEjemplares);
	}

}
