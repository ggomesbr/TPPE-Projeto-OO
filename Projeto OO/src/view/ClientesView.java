package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.Loja;

public class ClientesView extends JFrame {

	private JScrollPane scrollPane = new JScrollPane();
	private JButton btnRemover;
	private JButton btnEditar;
	private JButton btnVoltar;
	private JButton btnAdicionar;
	private Loja loja = Loja.getInstance();

	public ClientesView() {
		setTitle("Listar Clientes");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 600);

		setBounds(0, 0, 800, 600);
		setLocationRelativeTo(null);
		setLayout(null);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Email");
		model.addColumn("Telefone");

		for (Cliente cliente : loja.getClientes()) {
			model.addRow(new Object[] { cliente.getId(), cliente.getEmail(), cliente.getTelefone() });
		}

		JTable table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(10, 10, 770, 480);
		add(scrollPane);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(10, 500, 100, 30);
		add(btnRemover);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(120, 500, 100, 30);
		add(btnEditar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(230, 500, 100, 30);
		add(btnVoltar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(340, 500, 100, 30);
		add(btnAdicionar);

		setVisible(true);

	}

	public JFrame getFrame() {
		return this;
	}

}
