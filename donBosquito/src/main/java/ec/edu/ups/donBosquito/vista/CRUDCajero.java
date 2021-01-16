package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class CRUDCajero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtEmail;
	private JTextField txtFechaNacimiento;
	private JTextField txtTelefono;
	private JTextField txtFApertura;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDCajero frame = new CRUDCajero();
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
	public CRUDCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 607);
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
		
		JMenu mnCajero = new JMenu("Cajero ");
		menuBar.add(mnCajero);
		
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
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(12, 183, 699, 363);
		contentPane.add(panel);
		
		JLabel lblAdministradorClientes = new JLabel("Administrador Clientes");
		lblAdministradorClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAdministradorClientes.setBounds(239, 6, 209, 22);
		panel.add(lblAdministradorClientes);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBorder(new TitledBorder(null, "Crear Registro", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelRegistro.setBackground(new Color(240, 230, 140));
		panelRegistro.setBounds(410, 40, 272, 134);
		panel.add(panelRegistro);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(56, 39, 52, 16);
		panelRegistro.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(129, 34, 130, 26);
		panelRegistro.add(txtUsuario);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(33, 72, 75, 16);
		panelRegistro.add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(129, 67, 130, 26);
		panelRegistro.add(txtContrasena);
		
		JPanel panelUsuarioCrear = new JPanel();
		panelUsuarioCrear.setLayout(null);
		panelUsuarioCrear.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelUsuarioCrear.setBackground(new Color(240, 230, 140));
		panelUsuarioCrear.setBounds(20, 40, 380, 310);
		panel.add(panelUsuarioCrear);
		
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
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(245, 58, 130, 26);
		panelUsuarioCrear.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(245, 90, 130, 26);
		panelUsuarioCrear.add(txtApellido);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(245, 122, 130, 26);
		panelUsuarioCrear.add(txtDireccion);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(245, 24, 130, 26);
		panelUsuarioCrear.add(txtCedula);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(163, 159, 70, 16);
		panelUsuarioCrear.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(187, 223, 46, 16);
		panelUsuarioCrear.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(245, 218, 130, 26);
		panelUsuarioCrear.add(txtEmail);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(245, 186, 130, 26);
		panelUsuarioCrear.add(txtFechaNacimiento);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(245, 154, 130, 26);
		panelUsuarioCrear.add(txtTelefono);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		lblFechaNacimiento.setBounds(80, 191, 153, 16);
		panelUsuarioCrear.add(lblFechaNacimiento);
		
		JButton btnCargarFoto = new JButton("Cargar Foto");
		btnCargarFoto.setBounds(245, 246, 130, 29);
		panelUsuarioCrear.add(btnCargarFoto);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(70, 275, 117, 29);
		panelUsuarioCrear.add(btnRegistrar);
		
		JButton btnLimpiar_1 = new JButton("Limpiar");
		btnLimpiar_1.setBounds(204, 275, 117, 29);
		panelUsuarioCrear.add(btnLimpiar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBorder(new TitledBorder(null, "Cuenta Bancaria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(410, 175, 272, 175);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFApertura = new JLabel("F. APERTURA:");
		lblFApertura.setBounds(19, 104, 84, 16);
		panel_1.add(lblFApertura);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBounds(76, 132, 117, 29);
		panel_1.add(btnCrearCuenta);
		
		txtFApertura = new JTextField();
		txtFApertura.setBounds(116, 99, 130, 26);
		panel_1.add(txtFApertura);
		txtFApertura.setColumns(10);
		
		JLabel lblRol = new JLabel("TIPO:");
		lblRol.setBounds(71, 76, 33, 16);
		panel_1.add(lblRol);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(116, 72, 130, 27);
		comboBox.addItem("Cuenta Corriente");
		comboBox.addItem("Cuenta Ahorros");
		panel_1.add(comboBox);
		
		JLabel lblNCuenta = new JLabel("N. CUENTA:");
		lblNCuenta.setBounds(30, 35, 74, 16);
		panel_1.add(lblNCuenta);
		
		textField = new JTextField();
		textField.setBounds(116, 30, 130, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(6, 30, 687, 327);
		panel.add(panel_2);
		
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
