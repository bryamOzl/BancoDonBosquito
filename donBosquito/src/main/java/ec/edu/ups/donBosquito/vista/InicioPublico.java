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
import javax.swing.JMenu;

public class InicioPublico extends JFrame {

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
					InicioPublico frame = new InicioPublico();
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
	public InicioPublico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 615);
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
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(new Color(240, 230, 140));
		panelImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelImagen.setBounds(12, 183, 699, 127);
		contentPane.add(panelImagen);
		panelImagen.setLayout(null);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setBounds(313, 61, 61, 16);
		panelImagen.add(lblImagen);
		
		JPanel panelInformacionEm = new JPanel();
		panelInformacionEm.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacionEm.setBounds(12, 315, 699, 110);
		contentPane.add(panelInformacionEm);
		panelInformacionEm.setLayout(null);
		
		JLabel lblSO = new JLabel("Sobre Nosotros");
		lblSO.setBounds(6, 6, 116, 16);
		panelInformacionEm.add(lblSO);
		
		JLabel lblMision = new JLabel("Misión ");
		lblMision.setBounds(6, 55, 61, 16);
		panelInformacionEm.add(lblMision);
		
		JLabel lblVison = new JLabel("Visión ");
		lblVison.setBounds(312, 55, 61, 16);
		panelInformacionEm.add(lblVison);
		
		JLabel lblSOText = new JLabel("");
		lblSOText.setBounds(6, 27, 676, 28);
		panelInformacionEm.add(lblSOText);
		
		JLabel lblMisionText = new JLabel("");
		lblMisionText.setBounds(6, 71, 291, 33);
		panelInformacionEm.add(lblMisionText);
		
		JLabel lblVisiontext = new JLabel("");
		lblVisiontext.setBounds(312, 67, 381, 37);
		panelInformacionEm.add(lblVisiontext);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 430, 699, 157);
		contentPane.add(panelInformacion);
		panelInformacion.setLayout(null);
		
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
