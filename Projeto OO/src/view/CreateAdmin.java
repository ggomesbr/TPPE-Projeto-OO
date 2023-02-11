package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import controller.AdministradorController;
import controller.VendedorController;
import model.Loja;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CreateAdmin implements ActionListener {

	private JFrame frame;
	private JTextField nomeField;
	private JLabel nomeLabel;
	private JLabel emailLabel;
	private JLabel enderecoLabel;
	private JLabel cidadeLabel;
	private JLabel estadoLabel;
	private JLabel cepLabel;
	private JLabel bairroLabel;
	private JLabel senhaLabel;
	private JButton criarAdministrador;
	private JTextField cidadeField;
	private JTextField estadoField;
	private JTextField enderecoField;
	private JTextField emailField;
	private JTextField bairroField;
	private JTextField cepField;
	private JButton voltarButton;
	private AdministradorController administradorController;
	private VendedorController vendedorController;
	private int criarADM;
	private JLabel obrigatoriedadeLabel;
	private JLabel lblNewLabel;
	boolean isFirstTime;
	private JPasswordField senhaField;
	private JLabel nomeLojaLabel;
	private JTextField nomeLojaField;

	/**
	 * Create the application.
	 */
	public CreateAdmin() {
		AdministradorController administradorController = new AdministradorController();
		this.administradorController = administradorController;
		VendedorController vendedorController = new VendedorController();
		this.vendedorController = vendedorController;
		
		isFirstTime = administradorController.readAllAdmins().isEmpty();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		
		nomeLabel = new JLabel("Nome*");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		emailLabel = new JLabel("Email*");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		enderecoLabel = new JLabel("Endereço");
		enderecoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cidadeLabel = new JLabel("Cidade");
		cidadeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		estadoLabel = new JLabel("Estado");
		estadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cepLabel = new JLabel("CEP");
		cepLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		bairroLabel = new JLabel("Bairro");
		bairroLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		senhaLabel = new JLabel("Senha*");
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		criarAdministrador = new JButton("Criar Administrador");
		criarAdministrador.addActionListener(this);
		
		cidadeField = new JTextField();
		cidadeField.setColumns(10);
		
		estadoField = new JTextField();
		estadoField.setColumns(10);
		
		enderecoField = new JTextField();
		enderecoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		bairroField = new JTextField();
		bairroField.setColumns(10);
		
		cepField = new JTextField();
		cepField.setColumns(10);
		
		voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFirstTime) {
					MainView mainView = new MainView();
					mainView.getFrame().setVisible(true);
					frame.dispose();
				}
				else {
					LoginView loginView = new LoginView();
					loginView.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		
		obrigatoriedadeLabel = new JLabel("Campos com * são obrigatórios");
		
		lblNewLabel = new JLabel("Preencha os campos do Administrador:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		
		senhaField = new JPasswordField();
		
		nomeLojaLabel = new JLabel("Nome Loja");
		nomeLojaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		nomeLojaField = new JTextField();
		nomeLojaField.setText("Concessionaria FGLADA");
		nomeLojaField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 827, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(obrigatoriedadeLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(nomeLabel)
					.addGap(215)
					.addComponent(cidadeLabel)
					.addGap(207)
					.addComponent(estadoLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(131)
					.addComponent(cidadeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(120)
					.addComponent(estadoField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(enderecoLabel)
					.addGap(201)
					.addComponent(bairroLabel)
					.addGap(213)
					.addComponent(cepLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(244)
					.addComponent(criarAdministrador)
					.addGap(18)
					.addComponent(voltarButton))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(enderecoField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailLabel))
					.addGap(133)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bairroField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(senhaLabel))
					.addGap(120)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nomeLojaField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeLojaLabel)
						.addComponent(cepField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(obrigatoriedadeLabel)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nomeLabel)
						.addComponent(cidadeLabel)
						.addComponent(estadoLabel))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cidadeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(estadoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(enderecoLabel)
						.addComponent(bairroLabel)
						.addComponent(cepLabel))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(enderecoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bairroField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailLabel)
						.addComponent(senhaLabel)
						.addComponent(nomeLojaLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(senhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeLojaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(criarAdministrador)
						.addComponent(voltarButton)))
		);
		frame.getContentPane().setLayout(groupLayout);
		

	}

	
		public JFrame getFrame() {
		    return frame;
		  }


		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == criarAdministrador) {
		        String nome = nomeField.getText();
		        String email = emailField.getText();
		        String senha = String.valueOf(senhaField.getPassword());
		        String endereco = enderecoField.getText();
		        String cidade = cidadeField.getText();
		        String estado = estadoField.getText();
		        String cep = cepField.getText();
		        String bairro = bairroField.getText();
		        String telefone = "619XXXXXXXX";
		        Loja.setNome(nomeLojaField.getText());
		        
		        criarADM = verificarExistencia(nome,senha,email);
		        

		        switch (criarADM) {
					case 1:
						JOptionPane.showMessageDialog(null, "Administrador já existe!");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Vendedor já existe!");
						break;
					case 3:
						administradorController.createAdmin(email,endereco,cidade,estado,cep,bairro,nome,senha,telefone);
						isFirstTime = false;
						Loja.getInstance();
						Loja.preencherDatabase();
						JOptionPane.showMessageDialog(null, "Administrador criado com sucesso!");
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
						break;
				}
		        


		      }
			if (e.getSource() == voltarButton) {
				
			}
			
		}
	
	public int verificarExistencia(String nome, String senha, String email) {
        for (int i = 0; i < administradorController.readAllAdmins().size(); i++) {
        	if(email.equalsIgnoreCase(administradorController.readAllAdmins().get(i).getEmail())) {
        		return 1;
        	}
        }
        
        for (int i = 0; i < vendedorController.readAllVendedores().size(); i++) {
        	if(email.equalsIgnoreCase(vendedorController.readAllVendedores().get(i).getEmail())) {
        		return 2;
        	}
        }
        if(nome.trim().isEmpty() || email.trim().isEmpty() || senha.trim().isEmpty()) {
        	return 4;
        }
        
        return 3;
	}
}
