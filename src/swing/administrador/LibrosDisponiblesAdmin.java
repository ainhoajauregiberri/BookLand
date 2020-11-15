package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrosDisponiblesAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrosDisponiblesAdmin frame = new LibrosDisponiblesAdmin();
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
	public LibrosDisponiblesAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PrestarLibro v = new PrestarLibro();
					v.setVisible(true);
					LibrosDisponiblesAdmin.this.dispose();
			}
		});
		btnVolver.setBounds(15, 16, 85, 29);
		contentPane.add(btnVolver);
		
		JLabel lblEjemplaresDisponibles = new JLabel("Ejemplares disponibles");
		lblEjemplaresDisponibles.setBounds(130, 51, 178, 20);
		contentPane.add(lblEjemplaresDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 222, -327, -112);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(50, 87, 335, 118);
		contentPane.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JButton btnPrestar = new JButton("Prestar");
		btnPrestar.setBounds(159, 219, 115, 29);
		contentPane.add(btnPrestar);
		
		JOptionPane.showMessageDialog(LibrosDisponiblesAdmin.this, "El libro ha sido prestado");
	}

}
