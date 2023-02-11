package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ListarAutomoveisController;

public class ListarAutomoveis extends JFrame implements ActionListener {

	private JScrollPane scroll = new JScrollPane();
	private JButton btnUpdate = new JButton("Editar");
	private JButton btnRemove = new JButton("Remover");
	private String[] header = { "Marca", "Modelo", "Ano", "Chassi", "Cor", "Valor" };
	private ListarAutomoveisController controller = new ListarAutomoveisController();

	public ListarAutomoveis() {
		setTitle("Listar Automóveis");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);

		add(btnRemove);
		btnRemove.setBounds(10, 5, 150, 20);
		btnRemove.addActionListener(this);

		add(btnUpdate);
		btnUpdate.setBounds(170, 5, 150, 20);
		btnUpdate.addActionListener(this);

		scroll.setViewportView(
				new JTable(this.controller.generateTable(header)));
		add(scroll);
		scroll.setBounds(0, 30, 800, 520);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnRemove) {
			this.controller.removerAutomovel(scroll);
			scroll.setViewportView(
					new JTable(this.controller.generateTable(header)));
		} else if (e.getSource() == this.btnUpdate) {
			new EditarAutomovelView(scroll);
		}
	}

}
