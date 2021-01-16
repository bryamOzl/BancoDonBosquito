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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PolizasAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTiempo;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolizasAdministrador frame = new PolizasAdministrador();
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
	public PolizasAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 619);
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
		menuBar.setBounds(0, 0, 699, 22);
		panelMenu.add(menuBar);
		
		JMenu mnAdminstrador = new JMenu("Administrador");
		menuBar.add(mnAdminstrador);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setHorizontalTextPosition(SwingConstants.LEADING);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
		menuBar.add(mnNewMenu);
		
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
			gl_panelDatos.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 699, Short.MAX_VALUE)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap(526, Short.MAX_VALUE)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTituloDatos, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(lblTituloDatos, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblCorreo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
		);
		panelDatos.setLayout(gl_panelDatos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tabla de Valores de Polizas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 276, 699, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(130, 197, 51, 16);
		panel.add(lblTiempo);
		
		textTiempo = new JTextField();
		textTiempo.setBounds(192, 197, 130, 26);
		panel.add(textTiempo);
		textTiempo.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(435, 197, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(140, 235, 117, 29);
		panel.add(btnIngresar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(288, 235, 117, 29);
		panel.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBounds(445, 235, 117, 29);
		panel.add(btnEliminar);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFondo.setBackground(new Color(240, 230, 140));
		panelFondo.setBounds(114, 184, 464, 94);
		panel.add(panelFondo);
		panelFondo.setLayout(null);
		
		JLabel lblTasaI = new JLabel("Tasa de Interés:");
		lblTasaI.setBounds(239, 10, 104, 16);
		panelFondo.add(lblTasaI);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 25, 462, 120);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"VALOR_ID", "TIEMPO DIAS", "TASA DE INTERES"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 562, 699, 29);
		contentPane.add(panelInformacion);
		
		JLabel lblNewLabel = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel);
	}

}
