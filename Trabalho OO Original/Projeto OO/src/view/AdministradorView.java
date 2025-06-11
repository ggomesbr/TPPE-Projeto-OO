package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Administrador;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministradorView {

	private JFrame frame;


	/**
	 * Create the application.
	 * @param administrador 
	 */
	public AdministradorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("TELA DE ADMINISTRADOR");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 0, 89, 0};
		gbl_panel.rowHeights = new int[]{0, 23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAutomoveis = new JButton("Automoveis");
		btnAutomoveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutomovelView automovelView = new AutomovelView();
				automovelView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		GridBagConstraints gbc_btnAutomoveis = new GridBagConstraints();
		gbc_btnAutomoveis.insets = new Insets(0, 0, 5, 5);
		gbc_btnAutomoveis.gridx = 0;
		gbc_btnAutomoveis.gridy = 1;
		panel.add(btnAutomoveis, gbc_btnAutomoveis);
		
		JButton btnVendedores = new JButton("Vendedores");
		btnVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VendedoresView vendedoresView = new VendedoresView();
				vendedoresView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		GridBagConstraints gbc_btnVendedores = new GridBagConstraints();
		gbc_btnVendedores.insets = new Insets(0, 0, 5, 0);
		gbc_btnVendedores.gridx = 2;
		gbc_btnVendedores.gridy = 1;
		panel.add(btnVendedores, gbc_btnVendedores);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				loginView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogout.gridx = 1;
		gbc_btnLogout.gridy = 2;
		panel.add(btnLogout, gbc_btnLogout);
	}
	
	public JFrame getFrame() {
	    return frame;
	  }
	
	public static void main(String[] args) {
		AdministradorView window = new AdministradorView();
		window.frame.setVisible(true);
		

	}
}
