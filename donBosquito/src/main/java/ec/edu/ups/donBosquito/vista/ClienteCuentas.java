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
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ClienteCuentas extends JFrame {

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
					ClienteCuentas frame = new ClienteCuentas();
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
	public ClienteCuentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 709);
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
		
		JMenu mnPolizas = new JMenu("Polizas");
		menuBar.add(mnPolizas);
		
		JMenu mnHAccesos = new JMenu("Historial de Accesos");
		menuBar.add(mnHAccesos);
		
		JMenu mnCerrarSesion = new JMenu("Cerrar Sesión ");
		menuBar.add(mnCerrarSesion);
		
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
		
		JLabel lblDatosDelCajero = new JLabel("Datos del Cliente");
		
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
		
		JPanel panelCuentas = new JPanel();
		panelCuentas.setBorder(new TitledBorder(null, "Cuentas del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCuentas.setBounds(12, 277, 699, 121);
		contentPane.add(panelCuentas);
		
		JPanel panelPolizas = new JPanel();
		panelPolizas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cuentas del Polizas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPolizas.setBounds(12, 397, 699, 121);
		contentPane.add(panelPolizas);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 522, 699, 157);
		contentPane.add(panelInformacion);
		
		JLabel lblUbiquenos = new JLabel("UBIQUENOS");
		lblUbiquenos.setBounds(6, 6, 81, 16);
		panelInformacion.add(lblUbiquenos);
		
		JLabel lblRS = new JLabel("Redes Sociales");
		lblRS.setBounds(426, 6, 94, 16);
		panelInformacion.add(lblRS);
		
		JLabel lblNewLabel = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel.setBounds(6, 135, 349, 16);
		panelInformacion.add(lblNewLabel);
		
		JLabel lblFacebook = new JLabel("");
		lblFacebook.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-facebook.png"));
		lblFacebook.setBounds(412, 26, 25, 25);
		panelInformacion.add(lblFacebook);
		
		JLabel lblTwitter = new JLabel("");
		lblTwitter.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-twitter.png"));
		lblTwitter.setBounds(447, 26, 25, 25);
		panelInformacion.add(lblTwitter);
		
		JLabel lblYouTube = new JLabel("");
		lblYouTube.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-play_button.png"));
		lblYouTube.setBounds(484, 26, 25, 25);
		panelInformacion.add(lblYouTube);
		
		JLabel lblRomaT = new JLabel("");
		lblRomaT.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-parthenon.png"));
		lblRomaT.setBounds(6, 26, 25, 25);
		panelInformacion.add(lblRomaT);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-new_post.png"));
		lblEmail.setBounds(6, 63, 25, 25);
		panelInformacion.add(lblEmail);
		
		JLabel lblPhone = new JLabel("");
		lblPhone.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/icons8-phone.png"));
		lblPhone.setBounds(6, 100, 25, 25);
		panelInformacion.add(lblPhone);
	}

}
