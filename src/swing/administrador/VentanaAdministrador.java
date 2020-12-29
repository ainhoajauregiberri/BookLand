package swing.administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import swing.Acceso;
import swing.ProductosPrestados;
import swing.VentanaUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

/**
 * Esta es la clase a la que accederan los administradores despues de meter su nombre
 * de usuario y contrasenya correctos
 * @author Ainhoa y Lorea
 */

public class VentanaAdministrador extends JFrame{
	private JPanel contentPane;
	private static Persona persona;
	/**
	 * Este es el main para lanzar la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductosPrestados frame = new ProductosPrestados(VentanaAdministrador.persona);
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
	public VentanaAdministrador(Persona persona) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.persona=persona;
		
		JButton btnPrestarLibro = new JButton("Prestar productos");
		btnPrestarLibro.setBounds(36, 72, 167, 29);
		btnPrestarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioAdmin usuarioAdmin=new UsuarioAdmin(true,persona);
				usuarioAdmin.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnPrestarLibro);
		
		JButton btnDevolverLibro = new JButton("Devolver producto");
		btnDevolverLibro.setBounds(36, 113, 167, 29);
		btnDevolverLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioAdmin usuarioAdmin=new UsuarioAdmin(false,persona);
				usuarioAdmin.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
		});
		getContentPane().add(btnDevolverLibro);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setBounds(233, 72, 161, 29);
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario=new CrearUsuario(persona);
				crearUsuario.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
		});
		getContentPane().add(btnCrearUsuario);
		
		JButton btnMirarMultas = new JButton("Mirar multas");
		btnMirarMultas.setBounds(233, 113, 161, 29);
		btnMirarMultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MirarMultas mirarMultas=new MirarMultas(persona);
				mirarMultas.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
		});
		getContentPane().add(btnMirarMultas);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceso v = new Acceso();
				v.setVisible(true);
				VentanaAdministrador.this.dispose();
			}
		});
		btnInicio.setBounds(6, 6, 87, 29);
		contentPane.add(btnInicio);
		
		JButton btnNewButton = new JButton("Premios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(139, 154, 147, 29);
		contentPane.add(btnNewButton);
		
	}
}
