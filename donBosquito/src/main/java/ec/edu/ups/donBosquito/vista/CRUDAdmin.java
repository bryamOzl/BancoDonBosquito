package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class CRUDAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDAdmin frame = new CRUDAdmin();
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
	public CRUDAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 608);
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
		
		JMenu mnNewMenu = new JMenu("Administrador");
		menuBar.add(mnNewMenu);
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 183, 699, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrador Usuarios ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(239, 6, 209, 22);
		panel.add(lblNewLabel);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBounds(396, 40, 272, 188);
		panel.add(panelRegistro);
		panelRegistro.setLayout(null);
		panelRegistro.setBorder(new TitledBorder(null, "Crear Registro", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelRegistro.setBackground(new Color(240, 230, 140));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(56, 39, 52, 16);
		panelRegistro.add(lblUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(129, 34, 130, 26);
		panelRegistro.add(textField);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(33, 67, 75, 16);
		panelRegistro.add(lblContrasena);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 62, 130, 26);
		panelRegistro.add(textField_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Cajero");
		comboBox.addItem("Asistente de Captaciones");
		comboBox.setBounds(129, 100, 130, 27);
		panelRegistro.add(comboBox);
		
		JLabel lblRol = new JLabel("ROL:");
		lblRol.setBounds(79, 104, 29, 16);
		panelRegistro.add(lblRol);
		
		JButton btnCrearRegistro = new JButton("Crear Registro");
		btnCrearRegistro.setBounds(86, 154, 117, 29);
		panelRegistro.add(btnCrearRegistro);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(465, 241, 119, 29);
		panel.add(btnLimpiar);
		
		JPanel panelUsuarioCrear = new JPanel();
		panelUsuarioCrear.setBounds(12, 40, 380, 310);
		panel.add(panelUsuarioCrear);
		panelUsuarioCrear.setLayout(null);
		panelUsuarioCrear.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelUsuarioCrear.setBackground(new Color(240, 230, 140));
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setFocusable(false);
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setBounds(12, 24, 140, 151);
		panelUsuarioCrear.add(lblImagen);
		
		JLabel lblFOTO = new JLabel("FOTO:");
		lblFOTO.setBounds(194, 251, 39, 16);
		panelUsuarioCrear.add(lblFOTO);
		
		JLabel lblDireccion = new JLabel("DIRECCIÓN:");
		lblDireccion.setBounds(158, 127, 75, 16);
		panelUsuarioCrear.add(lblDireccion);
		
		JLabel lblNombr = new JLabel("NOMBRE:");
		lblNombr.setBounds(176, 63, 57, 16);
		panelUsuarioCrear.add(lblNombr);
		
		JLabel lblCedula = new JLabel("CÉDULA:");
		lblCedula.setBounds(178, 29, 55, 16);
		panelUsuarioCrear.add(lblCedula);
		
		JLabel lblApellido = new JLabel("APELLLIDO:");
		lblApellido.setBounds(158, 91, 75, 16);
		panelUsuarioCrear.add(lblApellido);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(245, 58, 130, 26);
		panelUsuarioCrear.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(245, 90, 130, 26);
		panelUsuarioCrear.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(245, 122, 130, 26);
		panelUsuarioCrear.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(245, 24, 130, 26);
		panelUsuarioCrear.add(textField_5);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(163, 159, 70, 16);
		panelUsuarioCrear.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(187, 223, 46, 16);
		panelUsuarioCrear.add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(245, 218, 130, 26);
		panelUsuarioCrear.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(245, 186, 130, 26);
		panelUsuarioCrear.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(245, 154, 130, 26);
		panelUsuarioCrear.add(textField_8);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		lblFechaNacimiento.setBounds(80, 191, 153, 16);
		panelUsuarioCrear.add(lblFechaNacimiento);
		
		JButton btnCargarFoto = new JButton("Cargar Foto");
		btnCargarFoto.setBounds(245, 246, 130, 29);
		panelUsuarioCrear.add(btnCargarFoto);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(116, 275, 117, 29);
		panelUsuarioCrear.add(btnCrearUsuario);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFondo.setBounds(6, 29, 670, 325);
		panel.add(panelFondo);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 550, 699, 29);
		contentPane.add(panelInformacion);
		
		JLabel lblNewLabel_1 = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel_1.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel_1);
	}
}
