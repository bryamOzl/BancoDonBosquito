package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenu;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(12, 155, 699, 23);
		contentPane.add(panelMenu);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Usuario");
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setBounds(0, 0, 700, 22);
		panelMenu.add(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JPanel panelIniciarSesion = new JPanel();
		panelIniciarSesion.setBackground(new Color(240, 230, 140));
		panelIniciarSesion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelIniciarSesion.setBounds(12, 183, 699, 347);
		contentPane.add(panelIniciarSesion);
		panelIniciarSesion.setLayout(null);
		
		JLabel lblInicarSesion = new JLabel("Iniciar Sesión");
		lblInicarSesion.setBounds(295, 6, 84, 16);
		panelIniciarSesion.add(lblInicarSesion);
		
		JLabel lblCaja = new JLabel("");
		lblCaja.setVerticalAlignment(SwingConstants.TOP);
		lblCaja.setBackground(new Color(255, 255, 255));
		lblCaja.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblCaja.setBounds(217, 24, 228, 135);
		panelIniciarSesion.add(lblCaja);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(246, 45, 53, 16);
		panelIniciarSesion.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(230, 77, 75, 16);
		panelIniciarSesion.add(lblContrasena);
		
		textField = new JTextField();
		textField.setBounds(305, 40, 130, 26);
		panelIniciarSesion.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 72, 130, 26);
		panelIniciarSesion.add(passwordField);
		
		JButton btnLogin = new JButton("Iniciar Sesión ");
		btnLogin.setBounds(277, 116, 117, 29);
		panelIniciarSesion.add(btnLogin);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/EHlOSPQWwAAhpwW_opt-3.jpg"));
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setBounds(42, 170, 602, 171);
		panelIniciarSesion.add(lblImagen);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 535, 699, 157);
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
