package swing.administrador;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import personas.Persona;
import personas.Usuario;
import sqlite.GestionBD;
import swing.IListasProductos;
import swing.ProductosPrestados;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta es la clase a la que se accede si el administrador elige la opción devolverlibro
 * o prestar libro. El administrador seleccionará el usuario en el que tiene que hacer 
 * los cambios.
 * @author Ainhoa y Lorea
 */

public class UsuarioAdmin extends JFrame {
	private JPanel contentPane;
	private static boolean prestar;
	private static Persona persona;
	private DefaultListModel dfmUsuarios;
	private JList list;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioAdmin frame = new UsuarioAdmin(UsuarioAdmin.prestar,UsuarioAdmin.persona);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public UsuarioAdmin(boolean prestar,Persona persona) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.prestar=prestar;
		this.persona=persona;
		this.dfmUsuarios=new DefaultListModel<Persona>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 58, 200, 110);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		cargarListaUsuarios();
		
		
		JButton button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministrador ventanaAdministrador=new VentanaAdministrador(UsuarioAdmin.persona);
				ventanaAdministrador.setVisible(true);
				UsuarioAdmin.this.dispose();
			}
		});
		
		button.setBounds(15, 16, 90, 29);
		getContentPane().add(button);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(31, 95, 121, 20);
		getContentPane().add(lblUsuario);
	
		
		GestionBD bd = new GestionBD("BookLand.db");
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p=(Persona) list.getSelectedValue();
				if (prestar) {
					boolean puedePrestar = bd.puedePrestar(p);
					if (puedePrestar){
					PrestarLibro prestarLibro=new PrestarLibro(persona);
					prestarLibro.setVisible(true);
					UsuarioAdmin.this.dispose();
					}else{
						JOptionPane.showMessageDialog(UsuarioAdmin.this, "El usuario tiene una multa, no puede prestar libros");
					}
				}else{
					ArrayList<String>productosPrestados=new ArrayList<String>();
					productosPrestados=bd.obtenerProductosUsuario(p);
					if(!(productosPrestados.isEmpty())) {
						DevolverLibro devolverLibro=new DevolverLibro(p,persona);
						devolverLibro.setVisible(true);
						UsuarioAdmin.this.dispose();
					}else {
						JOptionPane.showMessageDialog(UsuarioAdmin.this, "El usuario no tiene ningun libro que devolver");
						}
					}
			}
		});
		btnEntrar.setBounds(148, 199, 115, 29);
		getContentPane().add(btnEntrar);
		
		
	}
	public void cargarListaUsuarios() {
		dfmUsuarios=IListasProductos.cargarListaUsuarios();
		this.list.setModel(dfmUsuarios);
	}

}
