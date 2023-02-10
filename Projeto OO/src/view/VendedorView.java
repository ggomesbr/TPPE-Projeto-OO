package view;

import javax.swing.JFrame;

import model.Loja;
import model.Vendedor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VendedorView implements ActionListener {

	private JFrame frame;
	private JButton suasVendasButton;
	private JButton clientesButton;
	private JButton realizarVendaButton;
	private JLabel lojaLabel;
	private JLabel funcionarioLabel;
	private JButton pagamentoButton;
	private JButton logoutButton;
	final private Vendedor vendedor;

	/**
	 * Create the application.
	 */
	public VendedorView(Vendedor vendedor) {
		Loja.getInstance();
		Loja.preencherDatabase();
		this.vendedor = vendedor;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		suasVendasButton = new JButton("Suas vendas");
		suasVendasButton.addActionListener(this);
		
		
		clientesButton = new JButton("Clientes");
		clientesButton.addActionListener(this);
		
		realizarVendaButton = new JButton("Realizar venda");
		realizarVendaButton.addActionListener(this);
		
		lojaLabel = new JLabel(Loja.getNome());
		lojaLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		funcionarioLabel = new JLabel(vendedor.toString());
		funcionarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		funcionarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		pagamentoButton = new JButton("Folha Pagamento");
		pagamentoButton.addActionListener(this);
		
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(lojaLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(275)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(realizarVendaButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(suasVendasButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pagamentoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(clientesButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(335)
							.addComponent(logoutButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(funcionarioLabel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(203, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lojaLabel)
					.addGap(14)
					.addComponent(funcionarioLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addComponent(clientesButton)
					.addGap(18)
					.addComponent(realizarVendaButton)
					.addGap(18)
					.addComponent(suasVendasButton)
					.addGap(18)
					.addComponent(pagamentoButton)
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addComponent(logoutButton)
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

		
	

	
	public JFrame getFrame() {
	    return frame;
	  }
	public void actionPerformed(ActionEvent e) {
		Vendedor vendedor = this.vendedor;
		if (e.getSource() == clientesButton) {			
			ClientesView clientesView = new ClientesView();
			clientesView.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == realizarVendaButton) {
			CreateVenda createVenda = new CreateVenda(vendedor);
			createVenda.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == suasVendasButton) {
			VendasView vendaView = new VendasView(vendedor);
			vendaView.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == pagamentoButton) {
			FolhaPagamentoView folhaPagamentoView = new FolhaPagamentoView(vendedor);
			folhaPagamentoView.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == logoutButton) {
				LoginView loginView = new LoginView();
				loginView.getFrame().setVisible(true);
				frame.dispose();
		
		}
	}
	
	
	 public Vendedor escolherVendedor(){
		 return null;
	 }

}
