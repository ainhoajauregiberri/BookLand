package swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

public class BuscarPelicula extends JFrame {
	private JTextField textField;
	private JFrame parent;
	public BuscarPelicula() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario v = new VentanaUsuario();
				v.setVisible(true);
				BuscarPelicula.this.dispose();
			}
		});
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "T\u00EDtulo", "Director", "Genero"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(88, 112, 120, 26);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 112, 120, 26);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(158, 176, 115, 29);
		getContentPane().add(button_1);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(183, 67, 70, 29);
		getContentPane().add(lblPeliculas);
	}

}
