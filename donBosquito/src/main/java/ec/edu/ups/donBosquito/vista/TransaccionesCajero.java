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
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class TransaccionesCajero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNCuenta;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransaccionesCajero frame = new TransaccionesCajero();
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
	public TransaccionesCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 583);
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
		
		JMenu mnCajero = new JMenu("Cajero");
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
		panel.setBounds(12, 183, 699, 334);
		contentPane.add(panel);
		
		JLabel lblSistemaDeTransacciones = new JLabel("Sistema de Transacciones ");
		lblSistemaDeTransacciones.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSistemaDeTransacciones.setBounds(229, 6, 229, 22);
		panel.add(lblSistemaDeTransacciones);
		
		JLabel lblCuenta = new JLabel("# Cuenta:");
		lblCuenta.setBounds(60, 56, 61, 16);
		panel.add(lblCuenta);
		
		txtNCuenta = new JTextField();
		txtNCuenta.setBounds(133, 51, 130, 26);
		panel.add(txtNCuenta);
		txtNCuenta.setColumns(10);
		
		JButton btnBuscarCuenta = new JButton("Buscar Cuenta");
		btnBuscarCuenta.setBounds(275, 51, 117, 29);
		panel.add(btnBuscarCuenta);
		
		JPanel panelCuentaCliente = new JPanel();
		panelCuentaCliente.setBackground(new Color(240, 230, 140));
		panelCuentaCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panelCuentaCliente.setBorder(new TitledBorder(null, "Cuenta de Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCuentaCliente.setBounds(60, 84, 594, 116);
		panel.add(panelCuentaCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"# CUENTA", "CEDULA", "NOMBRE", "TIPO CUENTA", "TOTAL"
			}
		));
		scrollPane.setViewportView(table);
		GroupLayout gl_panelCuentaCliente = new GroupLayout(panelCuentaCliente);
		gl_panelCuentaCliente.setHorizontalGroup(
			gl_panelCuentaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCuentaCliente.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelCuentaCliente.setVerticalGroup(
			gl_panelCuentaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCuentaCliente.createSequentialGroup()
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
		);
		panelCuentaCliente.setLayout(gl_panelCuentaCliente);
		
		JPanel panelOperaciones = new JPanel();
		panelOperaciones.setBackground(new Color(240, 230, 140));
		panelOperaciones.setBorder(new TitledBorder(null, "Operaciones ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOperaciones.setBounds(60, 206, 319, 116);
		panel.add(panelOperaciones);
		panelOperaciones.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 21, 130, 26);
		panelOperaciones.add(textField);
		textField.setColumns(10);
		
		JLabel txtMonto = new JLabel("Ingrese el Monto");
		txtMonto.setBounds(16, 59, 105, 16);
		panelOperaciones.add(txtMonto);
		
		JButton btnRealizarDeposito = new JButton("Realizar Deposito");
		btnRealizarDeposito.setBounds(148, 12, 145, 29);
		panelOperaciones.add(btnRealizarDeposito);
		
		JButton btnRealizarRetiro = new JButton("Realizar Retiro");
		btnRealizarRetiro.setBounds(148, 46, 145, 29);
		panelOperaciones.add(btnRealizarRetiro);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(148, 81, 145, 29);
		panelOperaciones.add(btnLimpiar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(30, 36, 642, 290);
		panel.add(panel_1);
		
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(12, 521, 699, 29);
		contentPane.add(panelInformacion);
		
		JLabel lblNewLabel_1 = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel_1.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel_1);
	}
}
