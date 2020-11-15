package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class OrdenadorJAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenadorJAdmin frame = new OrdenadorJAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrdenadorJAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 71, 29);
		contentPane.add(button);
		
		JLabel lblOrdenador = new JLabel("Ordenador");
		lblOrdenador.setBounds(167, 45, 76, 20);
		contentPane.add(lblOrdenador);
		
		JLabel label = new JLabel("Usuario");
		label.setBounds(70, 82, 69, 20);
		contentPane.add(label);
		
		JList list = new JList();
		list.setBounds(154, 81, 248, 73);
		contentPane.add(list);
		
		JLabel lblOrdenador_1 = new JLabel("Ordenador");
		lblOrdenador_1.setBounds(70, 186, 90, 20);
		contentPane.add(lblOrdenador_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 182, 248, 46);
		contentPane.add(scrollPane);
		
		JList list_1 = new JList();
		scrollPane.setRowHeaderView(list_1);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(143, 259, 115, 29);
		contentPane.add(btnReservar);
	}
}
