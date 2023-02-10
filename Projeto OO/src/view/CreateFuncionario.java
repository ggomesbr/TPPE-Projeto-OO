package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CreateFuncionario {

	private JFrame CreateFuncionario;
	private JTextField cidadeField;
	private JTextField emailFieldd;
	private JTextField cepField;
	private JTextField bairroFieldd;
	private JTextField nomeFieldd;
	private JTextField estadoField;
	private JTextField enderecoField;
	private JTextField bairroField;



	/**
	 * Create the application.
	 */
	public CreateFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CreateFuncionario = new JFrame();
		CreateFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CreateFuncionario.setResizable(false);
		CreateFuncionario.setTitle("CRIAR VENDEDOR");
		CreateFuncionario.setBounds(100, 100, 376, 392);
		CreateFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		CreateFuncionario.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{104, 85, 162, 0};
		gbl_panel.rowHeights = new int[]{54, 20, 20, 20, 20, 20, 20, 20, 20, 23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel obrigatoriedadeLabel = new JLabel("Por favor, preencha os campos a seguir");
		GridBagConstraints gbc_obrigatoriedadeLabel = new GridBagConstraints();
		gbc_obrigatoriedadeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_obrigatoriedadeLabel.insets = new Insets(0, 0, 5, 0);
		gbc_obrigatoriedadeLabel.gridwidth = 3;
		gbc_obrigatoriedadeLabel.gridx = 0;
		gbc_obrigatoriedadeLabel.gridy = 0;
		panel.add(obrigatoriedadeLabel, gbc_obrigatoriedadeLabel);
		
		JLabel cepLabel = new JLabel("CEP");
		cepLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cepLabel = new GridBagConstraints();
		gbc_cepLabel.anchor = GridBagConstraints.NORTH;
		gbc_cepLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cepLabel.gridx = 0;
		gbc_cepLabel.gridy = 1;
		panel.add(cepLabel, gbc_cepLabel);
		
		cepField = new JTextField();
		cepField.setColumns(10);
		GridBagConstraints gbc_cepField = new GridBagConstraints();
		gbc_cepField.anchor = GridBagConstraints.NORTH;
		gbc_cepField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cepField.insets = new Insets(0, 0, 5, 0);
		gbc_cepField.gridwidth = 2;
		gbc_cepField.gridx = 1;
		gbc_cepField.gridy = 1;
		panel.add(cepField, gbc_cepField);
		
		JLabel cidadeLabel = new JLabel("Cidade");
		cidadeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cidadeLabel = new GridBagConstraints();
		gbc_cidadeLabel.anchor = GridBagConstraints.NORTH;
		gbc_cidadeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cidadeLabel.gridx = 0;
		gbc_cidadeLabel.gridy = 2;
		panel.add(cidadeLabel, gbc_cidadeLabel);
		
		cidadeField = new JTextField();
		cidadeField.setColumns(10);
		GridBagConstraints gbc_cidadeField = new GridBagConstraints();
		gbc_cidadeField.anchor = GridBagConstraints.NORTH;
		gbc_cidadeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cidadeField.insets = new Insets(0, 0, 5, 0);
		gbc_cidadeField.gridwidth = 2;
		gbc_cidadeField.gridx = 1;
		gbc_cidadeField.gridy = 2;
		panel.add(cidadeField, gbc_cidadeField);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
		gbc_nomeLabel.anchor = GridBagConstraints.NORTH;
		gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nomeLabel.gridx = 0;
		gbc_nomeLabel.gridy = 3;
		panel.add(nomeLabel, gbc_nomeLabel);
		
		nomeFieldd = new JTextField();
		nomeFieldd.setColumns(10);
		GridBagConstraints gbc_nomeFieldd = new GridBagConstraints();
		gbc_nomeFieldd.anchor = GridBagConstraints.NORTH;
		gbc_nomeFieldd.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeFieldd.insets = new Insets(0, 0, 5, 0);
		gbc_nomeFieldd.gridwidth = 2;
		gbc_nomeFieldd.gridx = 1;
		gbc_nomeFieldd.gridy = 3;
		panel.add(nomeFieldd, gbc_nomeFieldd);
		
		JLabel estadoLabel = new JLabel("Estado");
		estadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_estadoLabel = new GridBagConstraints();
		gbc_estadoLabel.anchor = GridBagConstraints.NORTH;
		gbc_estadoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_estadoLabel.gridx = 0;
		gbc_estadoLabel.gridy = 4;
		panel.add(estadoLabel, gbc_estadoLabel);
		
		estadoField = new JTextField();
		estadoField.setColumns(10);
		GridBagConstraints gbc_estadoField = new GridBagConstraints();
		gbc_estadoField.anchor = GridBagConstraints.NORTH;
		gbc_estadoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_estadoField.insets = new Insets(0, 0, 5, 0);
		gbc_estadoField.gridwidth = 2;
		gbc_estadoField.gridx = 1;
		gbc_estadoField.gridy = 4;
		panel.add(estadoField, gbc_estadoField);
		
		JLabel bairroLabel = new JLabel("Bairro");
		bairroLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_bairroLabel = new GridBagConstraints();
		gbc_bairroLabel.anchor = GridBagConstraints.NORTH;
		gbc_bairroLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bairroLabel.gridx = 0;
		gbc_bairroLabel.gridy = 5;
		panel.add(bairroLabel, gbc_bairroLabel);
		
		bairroField = new JTextField();
		GridBagConstraints gbc_bairroField = new GridBagConstraints();
		gbc_bairroField.anchor = GridBagConstraints.NORTH;
		gbc_bairroField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bairroField.insets = new Insets(0, 0, 5, 0);
		gbc_bairroField.gridwidth = 2;
		gbc_bairroField.gridx = 1;
		gbc_bairroField.gridy = 5;
		panel.add(bairroField, gbc_bairroField);
		bairroField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.NORTH;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 6;
		panel.add(emailLabel, gbc_emailLabel);
		
		emailFieldd = new JTextField();
		emailFieldd.setColumns(10);
		GridBagConstraints gbc_emailFieldd = new GridBagConstraints();
		gbc_emailFieldd.anchor = GridBagConstraints.NORTH;
		gbc_emailFieldd.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailFieldd.insets = new Insets(0, 0, 5, 0);
		gbc_emailFieldd.gridwidth = 2;
		gbc_emailFieldd.gridx = 1;
		gbc_emailFieldd.gridy = 6;
		panel.add(emailFieldd, gbc_emailFieldd);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		enderecoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_enderecoLabel = new GridBagConstraints();
		gbc_enderecoLabel.anchor = GridBagConstraints.NORTH;
		gbc_enderecoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_enderecoLabel.gridx = 0;
		gbc_enderecoLabel.gridy = 7;
		panel.add(enderecoLabel, gbc_enderecoLabel);
		
		enderecoField = new JTextField();
		GridBagConstraints gbc_enderecoField = new GridBagConstraints();
		gbc_enderecoField.anchor = GridBagConstraints.NORTH;
		gbc_enderecoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_enderecoField.insets = new Insets(0, 0, 5, 0);
		gbc_enderecoField.gridwidth = 2;
		gbc_enderecoField.gridx = 1;
		gbc_enderecoField.gridy = 7;
		panel.add(enderecoField, gbc_enderecoField);
		enderecoField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha");
		senhaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_senhaLabel = new GridBagConstraints();
		gbc_senhaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_senhaLabel.gridx = 0;
		gbc_senhaLabel.gridy = 8;
		panel.add(senhaLabel, gbc_senhaLabel);
		
		bairroFieldd = new JTextField();
		bairroFieldd.setColumns(10);
		GridBagConstraints gbc_bairroFieldd = new GridBagConstraints();
		gbc_bairroFieldd.anchor = GridBagConstraints.NORTH;
		gbc_bairroFieldd.fill = GridBagConstraints.HORIZONTAL;
		gbc_bairroFieldd.insets = new Insets(0, 0, 5, 0);
		gbc_bairroFieldd.gridwidth = 2;
		gbc_bairroFieldd.gridx = 1;
		gbc_bairroFieldd.gridy = 8;
		panel.add(bairroFieldd, gbc_bairroFieldd);
		
		JButton btnCriarVendedor = new JButton("Criar Vendedor");
		GridBagConstraints gbc_btnCriarVendedor = new GridBagConstraints();
		gbc_btnCriarVendedor.insets = new Insets(0, 0, 0, 5);
		gbc_btnCriarVendedor.gridwidth = 2;
		gbc_btnCriarVendedor.gridx = 0;
		gbc_btnCriarVendedor.gridy = 11;
		panel.add(btnCriarVendedor, gbc_btnCriarVendedor);
		
		JButton btnVoltar = new JButton("Voltar");
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.gridx = 2;
		gbc_btnVoltar.gridy = 11;
		panel.add(btnVoltar, gbc_btnVoltar);
	}
	
	public JFrame getFrame() {
	    return CreateFuncionario;
	  }

}
