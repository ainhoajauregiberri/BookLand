package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import personas.Usuario;
import sqlite.GestionBD;
import sun.util.calendar.CalendarDate;
import sun.util.resources.CalendarData;
import sun.util.resources.es.CalendarData_es;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class CrearUsuario extends JFrame {
	private JTextField textField_nacimiento;
	private JTextField textField_usuario;
	private JTextField textField_nombre;
	private JPanel contentPane;
	private JPasswordField passwordFieldClave;
	private JTextField textField_dinero;
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador();
				v.setVisible(true);
				CrearUsuario.this.dispose();
			}
		});
		button.setBounds(15, 16, 87, 29);
		getContentPane().add(button);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(44, 77, 69, 20);
		getContentPane().add(lblNombre);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(44, 113, 69, 20);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Clave");
		lblContrasea.setBounds(44, 149, 58, 20);
		getContentPane().add(lblContrasea);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setBounds(44, 188, 90, 20);
		getContentPane().add(lblNacimiento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(44, 262, 69, 20);
		getContentPane().add(lblSexo);
		
		textField_nacimiento = new JTextField();
		textField_nacimiento.setBounds(204, 185, 146, 26);
		getContentPane().add(textField_nacimiento);
		textField_nacimiento.setColumns(10);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(204, 110, 146, 26);
		getContentPane().add(textField_usuario);
		textField_usuario.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(204, 74, 146, 26);
		getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblCrearUsuario = new JLabel("Crear usuario");
		lblCrearUsuario.setBounds(161, 38, 116, 20);
		getContentPane().add(lblCrearUsuario);
		
		JRadioButton rdbtnChica = new JRadioButton("Chica");
		rdbtnChica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnChica.setSelected(false);
			}
		});
		rdbtnChica.setBounds(201, 262, 76, 29);
		contentPane.add(rdbtnChica);
		
		JRadioButton rdbtnChico = new JRadioButton("Chico");
		rdbtnChico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnChica.setSelected(false);
			}
		});
		rdbtnChico.setBounds(284, 262, 76, 29);
		contentPane.add(rdbtnChico);
		
		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(204, 146, 146, 26);
		contentPane.add(passwordFieldClave);
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setBounds(44, 224, 69, 20);
		contentPane.add(lblDinero);

		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionBD bd = new GestionBD("BookLand.db");
				String usuario=textField_usuario.getText();
				if (bd.existeUsuario(usuario)==true){
					JOptionPane.showMessageDialog(CrearUsuario.this, "Ya existe este nombre de usuario");
				}else{
					String nombre=textField_nombre.getText();
					String contrasenya=String.valueOf(passwordFieldClave.getPassword());
					String nacimiento=textField_nacimiento.getText();
					String dineroString = textField_dinero.getText();
					int dinero = Integer.parseInt(dineroString);
					boolean chica = rdbtnChica.isSelected();
					int mes = Calendar.DAY_OF_MONTH;
					int dia = Calendar.MONTH;
					int año = Calendar.YEAR;
					String fecha = año+"-"+mes+"-"+dia;
					
					int codPers = bd.codigoMaximo();
					if (chica==true){
						bd.insertarDatosPersona(codPers, nombre, usuario, contrasenya, nacimiento, "chica");
						bd.insertarDatosUsuario(codPers, fecha, dinero);
					}else{
						bd.insertarDatosPersona(codPers, nombre, usuario, contrasenya, nacimiento, "chico");
						bd.insertarDatosUsuario(codPers, fecha, dinero);
					}
					JOptionPane.showMessageDialog(CrearUsuario.this, "El usuario ha sido creado");
				
				}
				
			}
		});
		btnNewButton.setBounds(161, 333, 90, 29);
		getContentPane().add(btnNewButton);
		
		textField_dinero = new JTextField();
		textField_dinero.setBounds(204, 224, 146, 26);
		contentPane.add(textField_dinero);
		textField_dinero.setColumns(10);
		
		
		
		
		
	
	}
}
