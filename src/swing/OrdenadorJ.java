package swing;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OrdenadorJ extends JFrame {
	public OrdenadorJ() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuario v = new VentanaUsuario();
				v.setVisible(true);
				OrdenadorJ.this.dispose();
			}
		});
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
	}

}
