package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import model.Vendedor;


import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.VendedorController;


import javax.swing.JTable;

public class VendedoresView implements ActionListener {
	private JFrame frame;
	private JButton voltarButton;
	private JButton CriarVendedorButton;
	private JScrollPane scrollPane;
	private JTable table;
	private VendedorController vendedorController;
	private Vendedor selectedVendedor;


	public static void main(String[] args) {
		VendedoresView window = new VendedoresView();
		window.frame.setVisible(true);


	}



	public VendedoresView() {
		vendedorController = new VendedorController();
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(700, 400));
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(this);

		CriarVendedorButton = new JButton("Cria Vendedor");

		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(223, Short.MAX_VALUE)
					.addComponent(CriarVendedorButton)
					.addGap(18)
					.addComponent(voltarButton)
					.addGap(281))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(67)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(voltarButton)
						.addComponent(CriarVendedorButton))
					.addGap(23))
		);
		panel.setLayout(gl_panel);
		updateTable();

	}


	public JFrame getFrame() {
		return frame;
	}

	public void updateTable() {
		String[] columns = { "Nome", "E-mail", "Telefone", "Endereco", "Cidade"};
		Object[][] data = new Object[vendedorController.readAllVendedores().size()][columns.length];

		// Create initial table
		for (int i = 0; i < vendedorController.readAllVendedores().size(); i++) {
			String[] product = { vendedorController.readAllVendedores().get(i).getNome(),
					String.valueOf(vendedorController.readAllVendedores().get(i).getEmail()),
					String.valueOf(vendedorController.readAllVendedores().get(i).getTelefone()),
					vendedorController.readAllVendedores().get(i).getEndereco(),
					vendedorController.readAllVendedores().get(i).getCidade(),
			};

			data[i] = product;
		}

		table = new JTable(data, columns);

		// Listen to product selection event
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (table.getSelectedRow() > -1) {
					selectedVendedor = vendedorController.readAllVendedores().get(table.getSelectedRow());

					VendedorInfoView vendedorInfoView = new VendedorInfoView(selectedVendedor);
					vendedorInfoView.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});

		scrollPane.setViewportView(table);
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltarButton) {
			AdministradorView administradorView = new AdministradorView();
			administradorView.getFrame().setVisible(true);
			frame.dispose();
		}
	}

}