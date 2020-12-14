package ec.edu.ups.donBosquito.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class panelLogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public panelLogo() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(4, 5, 699, 146);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/fernandosanchez/Documents/DonBosquito/BancoDonBosquito/Imagenes/Logo.png"));
		lblLogo.setBounds(102, 0, 496, 147);
		panel.add(lblLogo);

	}

}
