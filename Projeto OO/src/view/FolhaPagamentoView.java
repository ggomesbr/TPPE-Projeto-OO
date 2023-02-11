package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Vendedor;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class FolhaPagamentoView {

	private JFrame frame;
	private JTextField CampoComissao;
	private JTextField CampoValorBruto;
	private JTextField CampoSalarioBruto;
	private JTextField CampoSalarioLiquido;
	private JButton btnVoltar;

	/**
	 * Create the application.
	 */
	public FolhaPagamentoView(final Vendedor vendedor) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("FOLHA DE PAGAMENTO");
		frame.setForeground(Color.WHITE);
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(FolhaPagamentoView.class.getResource("/imgs/car.png")));
		frame.setBounds(100, 100, 707, 448);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel panel = new Panel();
		panel.setName("PanelPagamento");
		panel.setBackground(new Color(0, 206, 209));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		Label TextoComissao = new Label("Valor das comissões:");
		sl_panel.putConstraint(SpringLayout.NORTH, TextoComissao, 67, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, TextoComissao, 213, SpringLayout.WEST, panel);
		panel.add(TextoComissao);

		CampoComissao = new JTextField();
		CampoComissao.setEditable(false);
		sl_panel.putConstraint(SpringLayout.WEST, CampoComissao, 6, SpringLayout.EAST, TextoComissao);
		sl_panel.putConstraint(SpringLayout.SOUTH, CampoComissao, 0, SpringLayout.SOUTH, TextoComissao);
		CampoComissao.setText("x.xxx,xx");
		panel.add(CampoComissao);
		CampoComissao.setColumns(10);

		Label LabelValorBruto = new Label("Salario Base:");
		sl_panel.putConstraint(SpringLayout.NORTH, LabelValorBruto, 67, SpringLayout.SOUTH, TextoComissao);
		sl_panel.putConstraint(SpringLayout.WEST, LabelValorBruto, 213, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, LabelValorBruto, -406, SpringLayout.EAST, panel);
		panel.add(LabelValorBruto);

		CampoValorBruto = new JTextField();
		CampoValorBruto.setEditable(false);
		sl_panel.putConstraint(SpringLayout.WEST, CampoValorBruto, 52, SpringLayout.EAST, LabelValorBruto);
		sl_panel.putConstraint(SpringLayout.SOUTH, CampoValorBruto, 0, SpringLayout.SOUTH, LabelValorBruto);
		CampoValorBruto.setText("x.xxx,xx");
		panel.add(CampoValorBruto);
		CampoValorBruto.setColumns(10);

		JLabel LabelSalarioBruto = new JLabel("Salario Bruto:");
		sl_panel.putConstraint(SpringLayout.NORTH, LabelSalarioBruto, 67, SpringLayout.SOUTH, LabelValorBruto);
		sl_panel.putConstraint(SpringLayout.WEST, LabelSalarioBruto, 213, SpringLayout.WEST, panel);
		panel.add(LabelSalarioBruto);

		CampoSalarioBruto = new JTextField();
		CampoSalarioBruto.setEditable(false);
		sl_panel.putConstraint(SpringLayout.NORTH, CampoSalarioBruto, -3, SpringLayout.NORTH, LabelSalarioBruto);
		sl_panel.putConstraint(SpringLayout.WEST, CampoSalarioBruto, 59, SpringLayout.EAST, LabelSalarioBruto);
		panel.add(CampoSalarioBruto);
		CampoSalarioBruto.setColumns(10);

		JLabel LabelSalarioLiquido = new JLabel("Salario Liquido:");
		sl_panel.putConstraint(SpringLayout.NORTH, LabelSalarioLiquido, 67, SpringLayout.SOUTH, LabelSalarioBruto);
		sl_panel.putConstraint(SpringLayout.WEST, LabelSalarioLiquido, 213, SpringLayout.WEST, panel);
		panel.add(LabelSalarioLiquido);

		CampoSalarioLiquido = new JTextField();
		CampoSalarioLiquido.setEditable(false);
		sl_panel.putConstraint(SpringLayout.NORTH, CampoSalarioLiquido, -3, SpringLayout.NORTH, LabelSalarioLiquido);
		sl_panel.putConstraint(SpringLayout.WEST, CampoSalarioLiquido, 52, SpringLayout.EAST, LabelSalarioLiquido);
		panel.add(CampoSalarioLiquido);
		CampoSalarioLiquido.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendedorView vendedorView = new VendedorView(vendedor);
				vendedorView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.SOUTH, btnVoltar, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnVoltar, -10, SpringLayout.EAST, panel);
		panel.add(btnVoltar);

	}

	public JFrame getFrame() {
		return frame;
	}
}
