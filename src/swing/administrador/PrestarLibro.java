package swing.administrador;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.Producto;
import sqlite.GestionBD;
import swing.IListasProductos;
import swing.ProductosPrestados;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * Esta es la clase acceso para que el administrador pueda registrar que un usuario se 
 * ha llevado un libro de la biblioteca. En esta ventana le apareceran los titulos de los
 * libros que hay actualmente
 * @author Ainhoa y Lorea
 */
public class PrestarLibro extends JFrame {
	private JPanel contentPane;
	private Persona persona;
	private Persona p;
	private DefaultListModel titulosLibros;
	private JList list;
	
	public PrestarLibro(Persona persona,Persona p) {
		this.persona=persona;
		this.p=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.titulosLibros=new DefaultListModel<String>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 93, 318, 120);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		cargarListaProductos();
		
		JButton btnInicio = new JButton("Volver");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador(persona);
				v.setVisible(true);
				PrestarLibro.this.dispose();
			}
		});
		btnInicio.setBounds(15, 16, 86, 29);
		getContentPane().add(btnInicio);
		
		JLabel lblPrestarLibro = new JLabel("Prestar libro");
		lblPrestarLibro.setBounds(166, 57, 86, 20);
		getContentPane().add(lblPrestarLibro);
		
		
		GestionBD bd=new GestionBD("BookLand.db");
		JButton btnPrestar = new JButton("Buscar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String libro =(String) list.getSelectedValue();
				if(bd.libroDisponible(bd.obtenerCodigoEjemplares(libro), bd.obtenerCodigoEjemplaresDisponiblesTotales())) {
					LibrosDisponiblesPrestarAdmin v =new LibrosDisponiblesPrestarAdmin(persona, libro, p);
					v.setVisible(true);
					PrestarLibro.this.dispose();
				}else {
					JOptionPane.showMessageDialog(PrestarLibro.this, "No tenemos ningun ejemplar disponible en este momento");
				}
				
				
			}
		});
		btnPrestar.setBounds(151, 247, 115, 29);
		getContentPane().add(btnPrestar);
		
		
	}
	public void cargarListaProductos() {
		titulosLibros=IListasProductos.cargarListaTitulos();
		this.list.setModel(titulosLibros);
	}
}
