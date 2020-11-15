package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class BuscarLibros extends JFrame implements IListasProductos{
	private JPanel contentPane;
	private DefaultListModel dfmTitulos;
	private DefaultListModel dfm;
	private JList listFiltros;
	private JList listTitulos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosPrestados frame = new ProductosPrestados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public BuscarLibros() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		dfm=new DefaultListModel<Object>();
		dfmTitulos=new DefaultListModel<String>();
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario v = new VentanaUsuario();
				v.setVisible(true);
				BuscarLibros.this.dispose();
			}
		});
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcionFiltro=(String) comboBox.getSelectedItem();
				if(opcionFiltro.equals("Genero")) {
					cargarListaGenero();
				}
				if(opcionFiltro.equals("Autor")){
					cargarListaAutor();
				}
				if(opcionFiltro.equals("Titulo")) {
					cargarListaTitulos();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "Titulo", "Autor", "Genero"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(35, 57, 157, 26);
		getContentPane().add(comboBox);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(158, 250, 115, 29);
		getContentPane().add(button_1);
		
		JLabel lblLibros = new JLabel("Libros");
		lblLibros.setBounds(187, 21, 61, 16);
		contentPane.add(lblLibros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 154, 276, 90);
		contentPane.add(scrollPane);
		
		listTitulos = new JList();
		scrollPane.setViewportView(listTitulos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(204, 57, 206, 80);
		contentPane.add(scrollPane_1);
		
		listFiltros = new JList();
		scrollPane_1.setViewportView(listFiltros);
	}
	public void  cargarListaGenero() {
		dfm=IListasProductos.cargarListaGenero();
		listFiltros.setModel(dfm);
	}
	
	public void cargarListaAutor() {
		dfm=IListasProductos.cargarListaAutor();
		listFiltros.setModel(dfm);
	}
	
	public void cargarListaTitulos() {
		dfmTitulos=IListasProductos.cargarListaTitulos();
		listTitulos.setModel(dfmTitulos);
	}
}
