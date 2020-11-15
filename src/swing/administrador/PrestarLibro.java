package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import personas.Usuario;
import productos.Producto;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PrestarLibro extends JFrame {
	private JPanel contentPane;
	private Usuario usuario;
	public PrestarLibro(Usuario usuario) {
		this.usuario=usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInicio = new JButton("Volver");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador();
				v.setVisible(true);
				PrestarLibro.this.dispose();
			}
		});
		btnInicio.setBounds(15, 16, 86, 29);
		getContentPane().add(btnInicio);
		
		JLabel lblPrestarLibro = new JLabel("Prestar libro");
		lblPrestarLibro.setBounds(166, 57, 86, 20);
		getContentPane().add(lblPrestarLibro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 93, 318, 120);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnPrestar = new JButton("Buscar");
		btnPrestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto producto = (Producto) list.getSelectedValue();
				LibrosDisponiblesPrestarAdmin v =new LibrosDisponiblesPrestarAdmin(usuario, producto);
				v.setVisible(true);
				PrestarLibro.this.dispose();
				
			}
		});
		btnPrestar.setBounds(151, 247, 115, 29);
		getContentPane().add(btnPrestar);
		
		
	}
}
