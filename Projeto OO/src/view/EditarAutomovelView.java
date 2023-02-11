package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import controller.ListarAutomoveisController;
import model.Automovel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

import javax.swing.JTable;

public class EditarAutomovelView {

	private ListarAutomoveisController controller = new ListarAutomoveisController();
	private JFrame frame = new JFrame();
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JTextField txtAno;
	private JTextField txtChassi;
	private JTextField txtValor;

	private Automovel automovel;

	public EditarAutomovelView(JScrollPane scroll) {

		JTable view = (JTable) scroll.getViewport().getView();
		int linha = view.getSelectedRow();
		this.automovel = this.controller.getAutomovel(view.getValueAt(linha, 3).toString());

		initialize(scroll);
	}

	private void initialize(JScrollPane scroll) {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("Marca");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 34, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 99, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);

		txtMarca = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtMarca, 31, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtMarca, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtMarca, 340, SpringLayout.WEST, panel);
		txtMarca.setEditable(false);
		panel.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Modelo");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 60, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 94, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);

		txtModelo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtModelo, 57, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtModelo, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtModelo, 340, SpringLayout.WEST, panel);
		txtModelo.setEditable(false);
		panel.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ano");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 86, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 109, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_2);

		txtAno = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtAno, 83, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtAno, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtAno, 340, SpringLayout.WEST, panel);
		txtAno.setEditable(false);
		panel.add(txtAno);
		txtAno.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Chassi");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 112, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 97, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);

		txtChassi = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtChassi, 109, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtChassi, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtChassi, 340, SpringLayout.WEST, panel);
		txtChassi.setEditable(false);
		panel.add(txtChassi);
		txtChassi.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Cor");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 138, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 111, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_4);

		txtCor = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtCor, 135, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtCor, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtCor, 340, SpringLayout.WEST, panel);
		txtCor.setEditable(false);
		panel.add(txtCor);
		txtCor.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Valor");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 164, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 104, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_5);

		txtValor = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtValor, 161, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtValor, 134, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtValor, 340, SpringLayout.WEST, panel);
		panel.add(txtValor);
		txtValor.setColumns(10);

		JButton btnSalvar = new JButton("Concluir Alteração");
		sl_panel.putConstraint(SpringLayout.NORTH, btnSalvar, 212, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnSalvar, 177, SpringLayout.WEST, panel);
		panel.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListarAutomoveisController controller = new ListarAutomoveisController();
				String novoValor = txtValor.getText();
				if (novoValor.matches("^(?:[1-9][0-9]{0,4}(?:\\.\\d{1,2})?|100000|100000.00)$")) {
					controller.editarAutomovel(scroll, Float.parseFloat(novoValor));
					frame.dispose();
				} else {
					JFrame frame2 = new JFrame();
					JOptionPane.showMessageDialog(frame2, "Valor inválido");
				}
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		sl_panel.putConstraint(SpringLayout.NORTH, btnCancelar, 212, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnCancelar, 10, SpringLayout.WEST, panel);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});

		txtAno.setText(this.automovel.getAno_fabricado());
		txtChassi.setText(this.automovel.getChassi());
		txtCor.setText(this.automovel.getCor().toString());
		txtMarca.setText(this.automovel.getMarca().getNome());
		txtModelo.setText(this.automovel.getModelo().getNome());
		txtValor.setText(String.valueOf(this.automovel.getValor()));

	}

}
