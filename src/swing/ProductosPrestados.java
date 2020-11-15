package swing;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.libros.Autor;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;


public class ProductosPrestados extends JFrame {
	private JPanel contentPane;
	private DefaultListModel dfmTitulos;
	private JList list;
	private static Persona persona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosPrestados frame = new ProductosPrestados(ProductosPrestados.persona);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ProductosPrestados(Persona persona) {
		dfmTitulos=new DefaultListModel<String>();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.persona=persona;
		JButton btnProlongar = new JButton("Prolongar");
		btnProlongar.setBounds(160, 213, 117, 29);
		getContentPane().add(btnProlongar);
		
		list = new JList();
		list.setBounds(92, 91, 260, 111);
		contentPane.add(list);
		cargarListaProductos(persona);
		
		JLabel lblProductosPrestados = new JLabel("Productos prestados");
		lblProductosPrestados.setBounds(157, 57, 141, 38);
		getContentPane().add(lblProductosPrestados);
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario v = new VentanaUsuario(ProductosPrestados.persona);
				v.setVisible(true);
				ProductosPrestados.this.dispose();
			}
		});
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
	}
	public void cargarListaProductos(Persona persona) {
		dfmTitulos=IListasProductos.cargarListaProductos(persona);
		list.setModel(dfmTitulos);
	}
}
