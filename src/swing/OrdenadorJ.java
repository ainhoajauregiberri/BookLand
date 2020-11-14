package swing;

import javax.swing.JFrame;
import javax.swing.JButton;

public class OrdenadorJ extends JFrame {
	public OrdenadorJ() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
	}

}
