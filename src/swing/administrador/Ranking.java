package swing.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import premios.EditorialLibros;
import premios.IPremios;
import premios.MergeSortGenerico;
import premios.PersonaPagina;
import premios.PersonaPaginaEuskera;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * Esta es la clase Ranking. Solo el administrador tendrá acceso
 * Accederá si desea obtener los ganadores de las 3 competiciones anuales
 * Las competiciones son: mejor lector, euskal saria, mejor editorial
 * @author Ainhoa y Lorea
 */

public class Ranking extends JFrame implements IPremios {

	private JPanel contentPane;
	private PersonaPagina[] personasPaginas;
	private PersonaPaginaEuskera[] personasPaginasEuskera;
	private EditorialLibros[] editorialLibros;
	private static Persona persona;

	/**
	 * Este es el main para lanzar la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking(Ranking.persona);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Este es el constructor para crear el frame
	 */
	public Ranking(Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.persona=persona;
		
		JLabel lblGanador = new JLabel("");
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setForeground(Color.BLUE);
		lblGanador.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblGanador.setBounds(18, 137, 383, 42);
		contentPane.add(lblGanador);
		
		JLabel lblCantidad = new JLabel("");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCantidad.setForeground(Color.BLUE);
		lblCantidad.setBounds(94, 223, 307, 16);
		contentPane.add(lblCantidad);
		
		JLabel lblRanking = new JLabel("El ganador es:");
		lblRanking.setBounds(170, 24, 117, 16);
		contentPane.add(lblRanking);
		
		JButton btnMejorLector = new JButton("Mejor lector");
		btnMejorLector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personasPaginas=IPremios.cargarPersonasPaginas();
				MergeSortGenerico ms = new MergeSortGenerico<PersonaPagina>();
				ms.mergeSort(personasPaginas, 0, personasPaginas.length-1);
				String nombreUsuario=personasPaginas[0].getPersona().getUsuario();
				lblGanador.setText(nombreUsuario);
				lblCantidad.setText(personasPaginas[0].getNumPagTotal()+" paginas leidas");
				
			}
		});
		btnMejorLector.setBounds(18, 66, 117, 29);
		contentPane.add(btnMejorLector);
		
		JButton btnMejorVasco = new JButton("Euskal saria");
		btnMejorVasco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personasPaginasEuskera=IPremios.cargarPersonasPaginasEuskera();
				MergeSortGenerico ms = new MergeSortGenerico<PersonaPaginaEuskera>();
				ms.mergeSort(personasPaginasEuskera, 0, personasPaginasEuskera.length-1);
				String nombreUsuarioEuskaldun=personasPaginasEuskera[0].getPersona().getUsuario();
				lblGanador.setText(nombreUsuarioEuskaldun);
				lblCantidad.setText(personasPaginasEuskera[0].getNumPagTotalEuskera()+" paginas leidas en euskera");
			}
		});
		btnMejorVasco.setBounds(161, 66, 117, 29);
		contentPane.add(btnMejorVasco);
		
		JButton btnResponsable = new JButton("Mejor editorial");
		btnResponsable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorialLibros=IPremios.cargarEditorialLibros();
				MergeSortGenerico ms = new MergeSortGenerico<EditorialLibros>();
				ms.mergeSort(editorialLibros, 0, editorialLibros.length-1);
				String nombreEditorial=editorialLibros[0].getEditorial().getNomEditorial();
				lblGanador.setText(nombreEditorial);
				lblCantidad.setText(editorialLibros[0].getNumLibros()+" libros prestados");
			}
		});
		btnResponsable.setBounds(301, 66, 117, 29);
		contentPane.add(btnResponsable);
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador v = new VentanaAdministrador(persona);
				v.setVisible(true);
				Ranking.this.dispose();
			}
		});
		button.setBounds(15, 11, 78, 29);
		contentPane.add(button);
		
		
		
		
	}
}
