package swing.administrador;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import servicios.MultasPersona;
import swing.IListasProductos;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * En esta ventana aparecerá la lista de los usuarios que tienen multas por retrasar
 * la devolución del producto. Aparecerá el nombre del usuario y el ejemplar retrasado.
 * @author Ainhoa y Lorea
 */
public class MirarMultas extends JFrame {
	private JPanel contentPane;
	private DefaultListModel dfmMultas;
	private JList list;
	
	public MirarMultas(Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dfmMultas=new DefaultListModel<MultasPersona>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 75, 292, 116);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setColumnHeaderView(list);
		
		cargarListaMultas();
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador(persona);
				v.setVisible(true);
				MirarMultas.this.dispose();
			}
		});
		button.setBounds(15, 16, 88, 29);
		getContentPane().add(button);
		
		
		JLabel lblMultas = new JLabel("Multas");
		lblMultas.setBounds(173, 39, 69, 20);
		getContentPane().add(lblMultas);
	}
	public void cargarListaMultas() {
		dfmMultas=IListasProductos.cargarListaMultas();
		this.list.setModel(dfmMultas);
	}
}
