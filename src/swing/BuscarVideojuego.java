package swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class BuscarVideojuego extends JFrame {
	private JTextField textField;
	private JFrame parent;
	public BuscarVideojuego(JFrame parent) {
		this.parent=parent;
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
		JLabel lblVideojuegos = new JLabel("Videojuegos");
		lblVideojuegos.setBounds(164, 64, 98, 29);
		getContentPane().add(lblVideojuegos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "T\u00EDtulo", "Marca", "Genero"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(75, 119, 120, 26);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(210, 119, 120, 26);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(152, 186, 115, 29);
		getContentPane().add(button_1);
	}

}
