package view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.LayoutStyle.ComponentPlacement;

import controller.AdministradorController;
import controller.VendedorController;
import model.Administrador;
import model.Vendedor;


import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginView implements ActionListener {

	private JFrame frame;
	private JButton LoginButton;
	private JTextField emailField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel LoginLabel;
	private JButton criarContaButton;
	private JPasswordField senhaField;
	private String email;
	private String senha;
	private Vendedor vendedor;
	private Administrador administrador;


	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(223)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		
		LoginButton = new JButton("Login");
		LoginButton.addActionListener(this);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Senha:");
		
		lblNewLabel = new JLabel("E-mail:");
		
		LoginLabel = new JLabel("Login");
		LoginLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 38));
		
		criarContaButton = new JButton("Criar conta");
		criarContaButton.addActionListener(this);
		
		senhaField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(122)
							.addComponent(LoginLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(criarContaButton)
									.addGap(23))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1)))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(LoginLabel)
					.addGap(35)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(criarContaButton)
						.addComponent(LoginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(20))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public JFrame getFrame() {
	    return frame;
	  }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == criarContaButton) {
			CreateVendedor funcionario = new CreateVendedor();
			funcionario.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == LoginButton) {
			email = emailField.getText();
			senha = String.valueOf(senhaField.getPassword());
			VendedorController vendedorController = new VendedorController();
			AdministradorController administradorController = new AdministradorController();
			this.administrador = administradorController.readOneAdmin(email);
			this.vendedor = vendedorController.readOneVendedor(email);
			

			
			//alterar aqui pra logar como vendedor
			if(vendedorController.existeVendedor(email)) {
				if(this.vendedor.getEmail().equals(email) && this.vendedor.getSenha().equals(senha)) {
					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
					VendedorView vendedorView = new VendedorView(this.vendedor);
					vendedorView.getFrame().setVisible(true);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Email ou senha incorreto!");
				}
				
			}
			
			else {
				if(administradorController.existeAdministrador(email)) {
					if(this.administrador.getEmail().equals(email)  && this.administrador.getSenha().equals(senha)) {
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
						AdministradorView administrador = new AdministradorView();
						administrador.getFrame().setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Email ou senha incorreto!");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuário não existe!");
				}
			}
			

				
			
		}
	}
	

	protected void do_LogoutButton_actionPerformed(ActionEvent e) {
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	}
}
