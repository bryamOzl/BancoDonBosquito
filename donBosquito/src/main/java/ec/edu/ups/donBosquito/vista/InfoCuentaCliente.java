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
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class InfoCuentaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoCuentaCliente frame = new InfoCuentaCliente();
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
	public InfoCuentaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 791);
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
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(526, Short.MAX_VALUE)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDatosDelCajero, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
						.addComponent(lblRol, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCorreo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblDatosDelCajero, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		panelDatos.setLayout(gl_panelDatos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cuentas del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 278, 699, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Movimiento");
		lblNewLabel.setBounds(27, 89, 125, 16);
		panel.add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(27, 119, 130, 27);
		comboBox.addItem("Retiros");
		comboBox.addItem("Depositos");
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Desde");
		lblNewLabel_1.setBounds(191, 89, 79, 16);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(191, 118, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Hasta");
		lblNewLabel_2.setBounds(362, 89, 79, 16);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(362, 118, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(519, 118, 117, 29);
		panel.add(btnNewButton);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 605, 699, 157);
		contentPane.add(panelInformacion);
		
		JLabel lblUbiquenos = new JLabel("UBIQUENOS");
		lblUbiquenos.setBounds(6, 6, 81, 16);
		panelInformacion.add(lblUbiquenos);
		
		JLabel lblRS = new JLabel("Redes Sociales");
		lblRS.setBounds(426, 6, 94, 16);
		panelInformacion.add(lblRS);
		
		JLabel lblNewLabel_3 = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel_3.setBounds(6, 135, 349, 16);
		panelInformacion.add(lblNewLabel_3);
		
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
