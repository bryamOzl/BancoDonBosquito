package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PrincipalAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PanelInformacion panelInformacion = new PanelInformacion();
	panelLogo panelLogo1 ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdministrador frame = new PrincipalAdministrador();
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
	public PrincipalAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setToolTipText("");
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(12, 7, 699, 146);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/Logo.png"));
		lblLogo.setBounds(102, 0, 496, 147);
		panelLogo.add(lblLogo);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDatos.setBackground(new Color(240, 230, 140));
		panelDatos.setBounds(12, 184, 699, 87);
		contentPane.add(panelDatos);
		
		JLabel lblTituloDatos = new JLabel("Datos del Administrador");
		
		JLabel lblRol = new JLabel("");
		
		JLabel lblCorreo = new JLabel("");
		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
		gl_panelDatos.setHorizontalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(529, Short.MAX_VALUE)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTituloDatos, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblRol, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCorreo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelDatos.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblTituloDatos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		panelDatos.setLayout(gl_panelDatos);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 477, 699, 29);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel);
		
		JPanel panelInformacionPersona = new JPanel();
		panelInformacionPersona.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacionPersona.setBounds(12, 279, 699, 186);
		contentPane.add(panelInformacionPersona);
		panelInformacionPersona.setLayout(null);
		
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(12, 155, 699, 23);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 698, 22);
		panelMenu.add(menuBar);
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setToolTipText("Usuario");
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenu mnPolizas = new JMenu("Polizas");
		menuBar.add(mnPolizas);
		
		JMenu mnCerrarS = new JMenu("Cerrar Sesión ");
		mnCerrarS.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnCerrarS);
	}
}
