package swing.administrador;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.Producto;
import swing.IListasProductos;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * El administrador puede devolver un libro de un usuario. Esta clase se usara cuando
 * un usuario vaya a la biblioteca a devovler un libro. El administrador accedera 
 * al programa en ese momento y marcara que el libro ha sido devuelto.
 * @author Ainhoa y Lorea
 */
public class DevolverLibro extends JFrame {
	
	private JPanel contentPane;
	private static Persona persona;
	private static Persona administrador;
	private JList list;
	private DefaultListModel dfmProductos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevolverLibro frame = new DevolverLibro(DevolverLibro.persona,DevolverLibro.administrador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DevolverLibro(Persona persona,Persona administrador) {
		this.persona=persona;
		this.administrador=administrador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dfmProductos=new DefaultListModel<String>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 90, 357, 116);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		cargarListaProductos(persona);
		
		JButton button = new JButton("Volver");
		button.setBounds(15, 16, 87, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador(persona);
				v.setVisible(true);
				DevolverLibro.this.dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(button);
		
		JLabel lblDevolverLibro = new JLabel("Devolver libro");
		lblDevolverLibro.setBounds(153, 54, 100, 20);
		getContentPane().add(lblDevolverLibro);
		
		
		JButton btnDevolver = new JButton("Buscar");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String producto = (String) list.getSelectedValue();
				LibrosDisponiblesDevolverAdmin v =new LibrosDisponiblesDevolverAdmin(persona, producto,administrador);
				v.setVisible(true);
				DevolverLibro.this.dispose();
			}
		});
		btnDevolver.setBounds(153, 240, 115, 29);
		getContentPane().add(btnDevolver);
		
		
	}
	public void cargarListaProductos(Persona persona) {
		dfmProductos=IListasProductos.cargarListaProductos(persona);
		this.list.setModel(dfmProductos);
	}
}
