package swing;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import productos.libros.Autor;
import swing.administrador.CrearUsuario;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class ProductosPrestados extends JFrame {
	private JPanel contentPane;
	private DefaultListModel dfmTitulos;
	private static Persona persona;
	private JList list;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 105, 329, 96);
		contentPane.add(scrollPane);
		
		//ScrollPane.setViewportView hemen sartu det Ainho, cargarLista baino lehen
		list = new JList();
		scrollPane.setViewportView(list);
		cargarListaProductos(persona);
		list.setVisible(true);
		scrollPane.setVisible(true);
		
		
		//Hengo funtzioa ere egin behar da. Titulo izanda ProductosUsuarios-etan 3 aste gehitu behar dira.
		JButton btnProlongar = new JButton("Prolongar");
		btnProlongar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = (String) list.getSelectedValue();
				JOptionPane.showMessageDialog(ProductosPrestados.this, "El libro se ha prolongado 3 semanas");
			}
		});
		btnProlongar.setBounds(160, 213, 117, 29);
		getContentPane().add(btnProlongar);
		
		
		
		
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
		this.list.setModel(dfmTitulos);
		if(dfmTitulos.isEmpty()) {
			JOptionPane.showMessageDialog(ProductosPrestados.this, "No tiene ningún libro prestado");
		}
	}
}
