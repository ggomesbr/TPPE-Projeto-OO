package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ListarAutomoveisController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EditarAutomovelView {

	private JFrame frame;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JTextField txtAno;
	private JTextField txtChassi;
	private JTextField txtValor;

	public EditarAutomovelView(JScrollPane scroll) {
		
		initialize(scroll);
	}

	private void initialize(JScrollPane scroll) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Marca");
		panel.add(lblNewLabel, "2, 4, right, default");
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		panel.add(txtMarca, "4, 4, fill, default");
		txtMarca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		panel.add(lblNewLabel_1, "2, 6, right, default");
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		panel.add(txtModelo, "4, 6, fill, default");
		txtModelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		panel.add(lblNewLabel_2, "2, 8, right, default");
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		panel.add(txtAno, "4, 8, fill, default");
		txtAno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Chassi");
		panel.add(lblNewLabel_3, "2, 10, right, default");
		
		txtChassi = new JTextField();
		txtChassi.setEditable(false);
		panel.add(txtChassi, "4, 10, fill, default");
		txtChassi.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cor");
		panel.add(lblNewLabel_4, "2, 12, right, default");
		
		txtCor = new JTextField();
		txtCor.setEditable(false);
		panel.add(txtCor, "4, 12, fill, default");
		txtCor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Valor");
		panel.add(lblNewLabel_5, "2, 14, right, default");
		
		txtValor = new JTextField();
		panel.add(txtValor, "4, 14, fill, default");
		txtValor.setColumns(10);
		
		JButton btnSalvar = new JButton("Concluir Alteração");
		panel.add(btnSalvar, "4, 18");
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListarAutomoveisController controller = new ListarAutomoveisController();
				// TODO Auto-generated method stub
				String novoValor = txtValor.getText();
				if(!novoValor.matches("[0-9]")) {
					controller.editarAutomovel(scroll,Float.parseFloat(novoValor));
				}
			}
			
		});
	}

}
