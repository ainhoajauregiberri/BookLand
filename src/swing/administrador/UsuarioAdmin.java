package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;

public class UsuarioAdmin extends JFrame {
	private JPanel contentPane;
	private boolean prestar;
	
	
	public UsuarioAdmin(boolean prestar) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador ventanaAdministrador=new VentanaAdministrador();
				ventanaAdministrador.setVisible(true);
				UsuarioAdmin.this.dispose();
			}
		});
		
		button.setBounds(15, 16, 90, 29);
		getContentPane().add(button);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(31, 95, 121, 20);
		getContentPane().add(lblUsuario);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prestar==true) {
					PrestarLibro prestarLibro=new PrestarLibro();
					prestarLibro.setVisible(true);
					UsuarioAdmin.this.dispose();
				}else{
					DevolverLibro devolverLibro=new DevolverLibro();
					devolverLibro.setVisible(true);
					UsuarioAdmin.this.dispose();
					
				}
			}
		});
		btnEntrar.setBounds(148, 199, 115, 29);
		getContentPane().add(btnEntrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 58, 200, 110);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel label = new JLabel("");
		label.setBounds(172, 25, 69, 20);
		getContentPane().add(label);
	}

}
