package swing;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProductosPrestados extends JFrame {
	public ProductosPrestados() {
		getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(219, 85, 179, 118);
		getContentPane().add(scrollBar);
		
		JLabel lblProductosPrestados = new JLabel("Productos");
		lblProductosPrestados.setBounds(87, 107, 79, 38);
		getContentPane().add(lblProductosPrestados);
		
		JLabel lblPrestados = new JLabel("prestados");
		lblPrestados.setBounds(87, 142, 69, 20);
		getContentPane().add(lblPrestados);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 78, 29);
		getContentPane().add(button);
	}
}
