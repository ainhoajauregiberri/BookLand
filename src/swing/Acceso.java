package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import sqlite.GestionBD;
import swing.administrador.VentanaAdministrador;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Acceso extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passFieldContrasenya;
	private HashMap <String,Persona>personas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso frame = new Acceso();
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
	public Acceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		GestionBD bd=new GestionBD("BookLand.db");
		this.personas=bd.seleccionarDatosPersona();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(66, 21, 71, 16);
		panel_1.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(180, 16, 130, 26);
		panel_1.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasenya = new JLabel("Clave:");
		lblContrasenya.setBounds(66, 57, 90, 16);
		panel_1.add(lblContrasenya);
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario=textFieldUsuario.getText();
				String contrasenya=String.valueOf(passFieldContrasenya.getPassword());
				if(personas.containsKey(usuario)) {
					Persona persona=(Persona) personas.get(usuario);
					int codPers=bd.obtenerCodigoDePersona(usuario);
					if(bd.comprobarUsuarioAdminitrador(codPers)) {
						if(persona.getContrasenya().equals(contrasenya)) {
							VentanaUsuario ventanaUsuario=new VentanaUsuario(persona);
							ventanaUsuario.setVisible(true);
							Acceso.this.dispose();
							
						}else {
							JOptionPane.showMessageDialog(Acceso.this, "Contraseña incorrecta");
						}
						
					}else {
						VentanaAdministrador ventanaAdministrador=new VentanaAdministrador(persona);
						ventanaAdministrador.setVisible(true);
						Acceso.this.dispose();
					}
				}else {
				JOptionPane.showMessageDialog(Acceso.this, "Usuario incorrecto");
					}
				}
				
			});
		btnEntrar.setBounds(146, 101, 81, 29);
		panel_1.add(btnEntrar);
		
		passFieldContrasenya = new JPasswordField();
		passFieldContrasenya.setBounds(180, 52, 130, 26);
		panel_1.add(passFieldContrasenya);
	}
}
