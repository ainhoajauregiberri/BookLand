package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import productos.libros.Autor;
import productos.libros.Ejemplar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrosDisponibles extends JFrame implements IListasProductos {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<String>dfmEjemplares;
	private static String titulo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrosDisponibles frame = new LibrosDisponibles(LibrosDisponibles.titulo);
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
	public LibrosDisponibles(String titulo) {
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
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarLibros v=new BuscarLibros();
				v.setVisible(true);
				LibrosDisponibles.this.dispose();
			}
		});
		btnVolver.setBounds(6, 6, 117, 29);
		contentPane.add(btnVolver);
		
		JLabel lblEjemplaresDisponibles = new JLabel("Ejemplares disponibles");
		lblEjemplaresDisponibles.setBounds(142, 50, 155, 16);
		contentPane.add(lblEjemplaresDisponibles);
		
		
		
	}
	public void cargarListaEjemplares(String titulo) {
		dfmEjemplares=IListasProductos.cargarListaEjemplares(titulo);
		this.list.setModel(dfmEjemplares);
	}

}