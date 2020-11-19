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
 * En esta clase aparecen los ejemplares del t�tulo que se ha seleccionado en la ventana anterior
 * @author Ainhoa y Lorea
 */
public class LibrosDisponiblesPrestarAdmin extends JFrame {

	private JPanel contentPane;
	private Persona persona;
	private Persona p;
	private String libro;
	private DefaultListModel dfmEjemplares;
	private JList list;
	/**
	 * Este es el main para lanzar la aplicaci�n
	 */
	
	/**
	 * Crear el frame
	 * @param producto 
	 * @param persona
	 * @param libro
	 */
	public LibrosDisponiblesPrestarAdmin(Persona persona, String libro,Persona p) {
		this.persona=persona;
		this.p=p;
		this.libro=libro;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dfmEjemplares=new DefaultListModel<Integer>();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 87, 335, 118);
		contentPane.add(scrollPane_1);
		
		list = new JList();
		scrollPane_1.setViewportView(list);
		
		cargarListaEjemplares(libro);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PrestarLibro v = new PrestarLibro(persona,p);
					v.setVisible(true);
					LibrosDisponiblesPrestarAdmin.this.dispose();
			}
		});
		btnVolver.setBounds(15, 16, 85, 29);
		contentPane.add(btnVolver);
		
		JLabel lblEjemplaresPrestados = new JLabel("Prestar");
		lblEjemplaresPrestados.setBounds(130, 51, 178, 20);
		contentPane.add(lblEjemplaresPrestados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 222, -327, -112);
		contentPane.add(scrollPane);
		
		GestionBD bd=new GestionBD("BookLand.db");
		
		JButton btnDevolver = new JButton("Prestar");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ejemplarLibro=(int)list.getSelectedValue();
				bd.prestarLibro(ejemplarLibro, p);
				JOptionPane.showMessageDialog(LibrosDisponiblesPrestarAdmin.this, "El libro ha sido prestado");
			}
		});
		btnDevolver.setBounds(159, 219, 115, 29);
		contentPane.add(btnDevolver);
		
		
	}
	public void cargarListaEjemplares(String libro) {
		dfmEjemplares=IListasProductos.cargarListaEjemplaresDisponibles(libro);
		this.list.setModel(dfmEjemplares);
	}

}
