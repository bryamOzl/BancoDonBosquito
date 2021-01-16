package ec.edu.ups.donBosquito.vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class PanelInformacion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInformacion() {
		setLayout(null);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBorder(new LineBorder(Color.BLACK));
		panelInformacion.setBackground(new Color(240, 230, 140));
		panelInformacion.setBounds(0, 0, 699, 29);
		add(panelInformacion);
		
		JLabel lblNewLabel = new JLabel("@ Banco Don Bosquito Todos los derechos reservados");
		lblNewLabel.setBounds(6, 6, 349, 16);
		panelInformacion.add(lblNewLabel);

	}

}
