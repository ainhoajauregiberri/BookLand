package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.libros.Autor;
import productos.libros.Ejemplar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta es la clase LibrosDisponibles que sera la ventana que se abrira si el usuario 
 * selecciona un titulo de un libro. Aqui apareceran todos los ejemplares disponibles 
 * que hay de ese libro
 * @author Ainhoa y Lorea
 */

public class LibrosDisponibles extends JFrame implements IListasProductos {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<String>dfmEjemplares;
	private static String titulo;
	private static Persona persona;


	/**
	 * Este es el main para lanzar la aplicaci�n
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrosDisponibles frame = new LibrosDisponibles(LibrosDisponibles.titulo,LibrosDisponibles.persona);
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
	public LibrosDisponibles(String titulo,Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dfmEjemplares=new DefaultListModel<String>();
		list = new JList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 93, 325, 138);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(list);
		cargarListaEjemplares(titulo);
		this.persona=persona;
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarLibros v=new BuscarLibros(LibrosDisponibles.persona);
				v.setVisible(true);
				LibrosDisponibles.this.dispose();
			}
		});
		btnVolver.setBounds(6, 6, 117, 29);
		contentPane.add(btnVolver);
		
		JLabel lblEjemplaresDisponibles = new JLabel("Ejemplares disponibles");
		lblEjemplaresDisponibles.setBounds(142, 50, 178, 16);
		contentPane.add(lblEjemplaresDisponibles);
		
		
		
	}
	public void cargarListaEjemplares(String titulo) {
		dfmEjemplares=IListasProductos.cargarListaEjemplares(titulo);
		this.list.setModel(dfmEjemplares);
	}

}
