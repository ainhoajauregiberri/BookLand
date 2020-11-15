package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import swing.ProductosPrestados;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UsuarioAdmin extends JFrame {
	private JPanel contentPane;
	private static boolean prestar;
	private static Persona persona;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioAdmin frame = new UsuarioAdmin(UsuarioAdmin.prestar,UsuarioAdmin.persona);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public UsuarioAdmin(boolean prestar,Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.prestar=prestar;
		this.persona=persona;
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador ventanaAdministrador=new VentanaAdministrador(UsuarioAdmin.persona);
				ventanaAdministrador.setVisible(true);
				UsuarioAdmin.this.dispose();
			}
		});
		
		button.setBounds(15, 16, 90, 29);
		getContentPane().add(button);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(31, 95, 121, 20);
		getContentPane().add(lblUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 58, 200, 110);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarioSeleccionado = (Usuario) list.getSelectedValue();
				if (prestar) {
					boolean puedePrestar = puedePrestar(usuarioSeleccionado);
					if (puedePrestar){
					PrestarLibro prestarLibro=new PrestarLibro(usuarioSeleccionado);
					prestarLibro.setVisible(true);
					UsuarioAdmin.this.dispose();
					}else{
						JOptionPane.showMessageDialog(UsuarioAdmin.this, "El usuario tiene una multa, no puede prestar libros");
					}
				}else{
					boolean puedeDevolver = puedeDevolver (usuarioSeleccionado);
					if (puedeDevolver){
					DevolverLibro devolverLibro=new DevolverLibro(usuarioSeleccionado);
					devolverLibro.setVisible(true);
					UsuarioAdmin.this.dispose();
					}else{
						JOptionPane.showMessageDialog(UsuarioAdmin.this, "El usuario no tiene ning�n libro que devolver");
					}
					
				}
			}
		});
		btnEntrar.setBounds(148, 199, 115, 29);
		getContentPane().add(btnEntrar);
		
		
	}

}
