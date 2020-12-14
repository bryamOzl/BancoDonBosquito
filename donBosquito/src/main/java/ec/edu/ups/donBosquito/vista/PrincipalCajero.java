package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class PrincipalCajero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCajero frame = new PrincipalCajero();
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
	public PrincipalCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(12, 155, 699, 23);
		contentPane.add(panelMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Usuario");
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setBounds(0, 0, 699, 22);
		panelMenu.add(menuBar);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenu mnTransacciones = new JMenu("Transacciones");
		menuBar.add(mnTransacciones);
		
		JMenu mnCerrarS = new JMenu("Cerrar Sesión ");
		menuBar.add(mnCerrarS);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setToolTipText("");
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(12, 7, 699, 146);
		contentPane.add(panelLogo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/Logo.png"));
		lblLogo.setBounds(102, 0, 496, 147);
		panelLogo.add(lblLogo);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDatos.setBackground(new Color(240, 230, 140));
		panelDatos.setBounds(12, 184, 699, 87);
		contentPane.add(panelDatos);
		
		JLabel lblDatosDelCajero = new JLabel("Datos del Cajero");
		
		JLabel lblRol = new JLabel("");
		
		JLabel lblCorreo = new JLabel("");
		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
		gl_panelDatos.setHorizontalGroup(
			gl_panelDatos.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 699, Short.MAX_VALUE)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(526, Short.MAX_VALUE)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDatosDelCajero, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblRol, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCorreo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 87, Short.MAX_VALUE)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblDatosDelCajero, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		panelDatos.setLayout(gl_panelDatos);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 477, 699, 29);
		contentPane.add(panelInformacion);
		
		JLabel lblNewLabel = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel);
		
		JPanel panelInformacionPersona = new JPanel();
		panelInformacionPersona.setLayout(null);
		panelInformacionPersona.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacionPersona.setBounds(12, 279, 699, 186);
		contentPane.add(panelInformacionPersona);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFoto.setBounds(18, 16, 211, 153);
		panelInformacionPersona.add(lblFoto);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(255, 16, 61, 16);
		panelInformacionPersona.add(lblNombre);
		
		JLabel lblApelldio = new JLabel("");
		lblApelldio.setBounds(255, 44, 61, 16);
		panelInformacionPersona.add(lblApelldio);
		
		JLabel lblDireccion = new JLabel("");
		lblDireccion.setBounds(255, 72, 61, 16);
		panelInformacionPersona.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("");
		lblTelefono.setBounds(255, 98, 61, 16);
		panelInformacionPersona.add(lblTelefono);
	}

}
