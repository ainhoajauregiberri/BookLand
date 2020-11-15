package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class CuentacuentosJAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuentacuentosJAdmin frame = new CuentacuentosJAdmin();
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
	public CuentacuentosJAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Inicio");
		button.setBounds(15, 16, 71, 29);
		contentPane.add(button);
		
		JLabel lblCuentacuentos = new JLabel("Cuentacuentos");
		lblCuentacuentos.setBounds(161, 58, 109, 20);
		contentPane.add(lblCuentacuentos);
		
		JLabel lblCuentacuentos_1 = new JLabel("Cuentacuentos");
		lblCuentacuentos_1.setBounds(15, 106, 129, 20);
		contentPane.add(lblCuentacuentos_1);
		
		JList list = new JList();
		list.setBounds(157, 94, 198, 59);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(157, 167, 198, 61);
		contentPane.add(list_1);
		
		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setBounds(15, 168, 94, 20);
		contentPane.add(lblParticipantes);
		
		JLabel lblPlazasDisponibles = new JLabel("Plazas disponibles");
		lblPlazasDisponibles.setBounds(15, 246, 129, 20);
		contentPane.add(lblPlazasDisponibles);
		
		JLabel label = new JLabel("0");
		label.setVisible(false);
		label.setBounds(161, 246, 69, 20);
		contentPane.add(label);
	}

}
