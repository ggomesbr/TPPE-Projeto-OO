package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;

public class AdmVendedoresView {
	private JFrame frmAdmVendedoresView;

	public AdmVendedoresView() {
		frmAdmVendedoresView = new JFrame();
		
		JPanel panel = new JPanel();
		frmAdmVendedoresView.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnCadastraVendedor = new JButton("Cadastrar Vendedor");
		
		JButton btnVisualizaVendedores = new JButton("Visualizar Vendedores");
		
		JButton btnEditaVendedor = new JButton("Editar Vendedor");
		
		JButton btnRemoveVendedor = new JButton("Remover Vendedor");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("434px"),},
			new RowSpec[] {
				RowSpec.decode("fill:65px"),
				RowSpec.decode("fill:65px"),
				RowSpec.decode("fill:65px"),
				RowSpec.decode("fill:65px"),}));
		panel.add(btnCadastraVendedor, "1, 1, fill, fill");
		panel.add(btnVisualizaVendedores, "1, 2, fill, fill");
		panel.add(btnEditaVendedor, "1, 3, fill, fill");
		panel.add(btnRemoveVendedor, "1, 4, fill, fill");

	}


	public JFrame getFrame() {
		return frmAdmVendedoresView;
	}


	public void setFrame(JFrame frame) {
		this.frmAdmVendedoresView = frame;
	}
}
