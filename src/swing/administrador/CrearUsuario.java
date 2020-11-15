package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class CrearUsuario extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel contentPane;
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador();
				v.setVisible(true);
				CrearUsuario.this.dispose();
			}
		});
		button.setBounds(15, 16, 71, 29);
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
		lblSexo.setBounds(44, 224, 69, 20);
		getContentPane().add(lblSexo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 185, 146, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 146, 146, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(204, 110, 146, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 74, 146, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCrearUsuario = new JLabel("Crear usuario");
		lblCrearUsuario.setBounds(161, 38, 116, 20);
		getContentPane().add(lblCrearUsuario);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(CrearUsuario.this, "El usuario ha sido creado");
			}
		});
		btnNewButton.setBounds(161, 271, 90, 29);
		getContentPane().add(btnNewButton);
		
		JRadioButton rdbtnChica = new JRadioButton("Chica");
		rdbtnChica.setBounds(201, 220, 76, 29);
		contentPane.add(rdbtnChica);
		
		JRadioButton rdbtnChico = new JRadioButton("Chico");
		rdbtnChico.setBounds(284, 220, 76, 29);
		contentPane.add(rdbtnChico);
	}
}
