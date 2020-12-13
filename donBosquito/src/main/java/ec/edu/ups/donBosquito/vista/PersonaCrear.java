package ec.edu.ups.donBosquito.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PersonaCrear extends JFrame {

	private JPanel contentPane;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtFechaNacimiento;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaCrear frame = new PersonaCrear();
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
	public PersonaCrear() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 383);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(12, 24, 140, 133);
		
		JLabel lblCedula = new JLabel("CÉDULA:");
		lblCedula.setBounds(178, 29, 55, 16);
		
		JLabel lblNOMBRE = new JLabel("NOMBRE:");
		lblNOMBRE.setBounds(176, 95, 57, 16);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(168, 63, 65, 16);
		
		JLabel lblDireccion = new JLabel("DIRECCIÓN:");
		lblDireccion.setBounds(158, 127, 75, 16);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(163, 159, 70, 16);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		lblFechaNacimiento.setBounds(80, 191, 153, 16);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(187, 223, 46, 16);
		
		JLabel lblNewLabel = new JLabel("FOTO:");
		lblNewLabel.setBounds(194, 251, 39, 16);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(245, 122, 130, 26);
		txtDireccion.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(245, 90, 130, 26);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(245, 58, 130, 26);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(245, 24, 130, 26);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(245, 154, 130, 26);
		txtTelefono.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(245, 186, 130, 26);
		txtFechaNacimiento.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(245, 218, 130, 26);
		txtEmail.setColumns(10);
		panel.setLayout(null);
		panel.add(lblImagen);
		panel.add(lblNewLabel);
		panel.add(lblDireccion);
		panel.add(lblApellido);
		panel.add(lblCedula);
		panel.add(lblNOMBRE);
		panel.add(txtNombre);
		panel.add(txtApellido);
		panel.add(txtDireccion);
		panel.add(txtCedula);
		panel.add(lblTelefono);
		panel.add(lblEmail);
		panel.add(txtEmail);
		panel.add(txtFechaNacimiento);
		panel.add(txtTelefono);
		panel.add(lblFechaNacimiento);
		
		JButton btnCargarFoto = new JButton("Cargar Foto");
		btnCargarFoto.setBounds(258, 246, 117, 29);
		panel.add(btnCargarFoto);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(116, 297, 117, 29);
		panel.add(btnCrearUsuario);
		contentPane.setLayout(gl_contentPane);
	}
}
