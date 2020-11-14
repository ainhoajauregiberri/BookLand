package swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class BuscarLibros extends JFrame {
	private JTextField textField;
	public BuscarLibros() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "T\u00EDtulo", "Autor", "Genero"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(80, 103, 120, 26);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(235, 103, 120, 26);
		getContentPane().add(textField);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(160, 173, 115, 29);
		getContentPane().add(button_1);
	}
	
	

}
