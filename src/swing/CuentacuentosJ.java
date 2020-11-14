package swing;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CuentacuentosJ extends JFrame {
	public CuentacuentosJ() {
		getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(27, 104, 355, 79);
		getContentPane().add(scrollBar);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
		
		JButton btnApuntarse = new JButton("Apuntarse");
		btnApuntarse.setBounds(157, 199, 111, 29);
		getContentPane().add(btnApuntarse);
		
		JLabel lblNewLabel = new JLabel("Cuentacuentos");
		lblNewLabel.setBounds(157, 68, 111, 29);
		getContentPane().add(lblNewLabel);
	}

}
