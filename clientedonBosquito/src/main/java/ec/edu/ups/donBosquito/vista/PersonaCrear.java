package ec.edu.ups.donBosquito.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.negocio.GestionPersonaONRemoto;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Choice;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.awt.event.ActionEvent;

public class PersonaCrear extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtFechaNacimiento;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField textField;
	
	private GestionPersonaONRemoto on;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaCrear frame = new PersonaCrear();
					frame.referenciaONCliente();
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
		setBounds(100, 100, 718, 383);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JPanel panelUsuarioCrear = new JPanel();
		panelUsuarioCrear.setBackground(new Color(240, 230, 140));
		panelUsuarioCrear.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new TitledBorder(null, "Crear Registro", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JButton btnLimpiar = new JButton("Limpiar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelUsuarioCrear, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(84, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpiar)
							.addGap(77))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelUsuarioCrear, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(btnLimpiar)))
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(56, 39, 52, 16);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(129, 34, 130, 26);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setBounds(33, 67, 75, 16);
		panel.add(lblContrasena);
		
		textField = new JTextField();
		textField.setBounds(129, 62, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 100, 130, 27);
		panel.add(comboBox);
		
		JLabel lblRol = new JLabel("ROL:");
		lblRol.setBounds(79, 104, 29, 16);
		panel.add(lblRol);
		
		JButton btnCrearRegistro = new JButton("Crear Registro");
		btnCrearRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearRegistro();
			}

			
		});
		btnCrearRegistro.setBounds(86, 154, 117, 29);
		panel.add(btnCrearRegistro);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(12, 24, 140, 133);
		
		JLabel lblCedula = new JLabel("CÉDULA:");
		lblCedula.setBounds(178, 29, 55, 16);
		
		JLabel lblApellido = new JLabel("APELLLIDO:");
		lblApellido.setBounds(158, 91, 75, 16);
		
		JLabel lblNombr = new JLabel("NOMBRE:");
		lblNombr.setBounds(176, 63, 57, 16);
		
		JLabel lblDireccion = new JLabel("DIRECCIÓN:");
		lblDireccion.setBounds(158, 127, 75, 16);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(163, 159, 70, 16);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO:");
		lblFechaNacimiento.setBounds(80, 191, 153, 16);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(187, 223, 46, 16);
		
		JLabel lblFOTO = new JLabel("FOTO:");
		lblFOTO.setBounds(194, 251, 39, 16);
		
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
		panelUsuarioCrear.setLayout(null);
		panelUsuarioCrear.add(lblImagen);
		panelUsuarioCrear.add(lblFOTO);
		panelUsuarioCrear.add(lblDireccion);
		panelUsuarioCrear.add(lblNombr);
		panelUsuarioCrear.add(lblCedula);
		panelUsuarioCrear.add(lblApellido);
		panelUsuarioCrear.add(txtNombre);
		panelUsuarioCrear.add(txtApellido);
		panelUsuarioCrear.add(txtDireccion);
		panelUsuarioCrear.add(txtCedula);
		panelUsuarioCrear.add(lblTelefono);
		panelUsuarioCrear.add(lblEmail);
		panelUsuarioCrear.add(txtEmail);
		panelUsuarioCrear.add(txtFechaNacimiento);
		panelUsuarioCrear.add(txtTelefono);
		panelUsuarioCrear.add(lblFechaNacimiento);
		
		JButton btnCargarFoto = new JButton("Cargar Foto");
		btnCargarFoto.setBounds(258, 246, 117, 29);
		panelUsuarioCrear.add(btnCargarFoto);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPersona();
			}

			
		});
		btnCrearUsuario.setBounds(116, 297, 117, 29);
		panelUsuarioCrear.add(btnCrearUsuario);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void guardarPersona()  {
		// TODO Auto-generated method stub
		
		Persona persona = new Persona();
		persona.setPersona_id(1);
		persona.setCedula(txtCedula.getText());
		persona.setNombre(txtNombre.getText());
		persona.setApellido(txtApellido.getText());
		persona.setDireccion(txtDireccion.getText());
		persona.setTelefono(txtTelefono.getText());
		persona.setFecha_nacimiento(comvertirFecha(txtFechaNacimiento.getText()));
		persona.setCorreo(txtEmail.getText());
		
		
		try {
			on.registrarPersona(persona);
			System.out.println("Guardar Persona Ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al Guardar Persona"+ e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void crearRegistro() {
		// TODO Auto-generated method stub
		

		
	}
	
	Date comvertirFecha(String texto) {
		try {
		Date fechaDate = new SimpleDateFormat("yyyy/MM/dd").parse(texto);
		return fechaDate;
		} catch (ParseException ex) {
		System.out.println(ex);
		}
		return null;
		}
	public void referenciaONCliente() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "root1234");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/donBosquito/GestionPersonaON!ec.edu.ups.donBosquito.negocio.GestionPersonaONRemoto";  
              
            this.on = (GestionPersonaONRemoto) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
