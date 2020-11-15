package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DevolverLibro extends JFrame {
	
	private JPanel contentPane;
	public DevolverLibro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Volver");
		button.setBounds(15, 16, 87, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador();
				v.setVisible(true);
				DevolverLibro.this.dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(button);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DevolverLibro.this, "El libro ha sido devuelto");
			}
		});
		btnDevolver.setBounds(153, 240, 115, 29);
		getContentPane().add(btnDevolver);
		
		JLabel lblDevolverLibro = new JLabel("Devolver libro");
		lblDevolverLibro.setBounds(153, 54, 100, 20);
		getContentPane().add(lblDevolverLibro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 90, 357, 116);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}
}
