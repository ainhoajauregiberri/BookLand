package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class BuscarCD extends JFrame {
	private JTextField textField;
	private JFrame parent;
	public BuscarCD(ActionListener actionListener) {
		this.parent=(JFrame) actionListener;
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(227, 118, 120, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(15, 9, 78, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(162, 184, 115, 29);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblBuscarcd = new JLabel("CDs");
		lblBuscarcd.setBounds(206, 61, 31, 29);
		getContentPane().add(lblBuscarcd);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por", "T\u00EDtulo", "Autor", "Genero"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(93, 118, 120, 26);
		getContentPane().add(comboBox);
	}
}
