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

import controller.AdministradorController;
import model.Administrador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import java.awt.Dimension;

public class AdmVendedoresView {
	private JFrame frmAdmVendedoresView;
	private Administrador administrador;

	public AdmVendedoresView() {
		frmAdmVendedoresView = new JFrame();
		frmAdmVendedoresView.setMinimumSize(new Dimension(700, 400));
		frmAdmVendedoresView.setResizable(false);
		
		JPanel panel = new JPanel();
		frmAdmVendedoresView.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnCadastraVendedor = new JButton("Cadastrar Vendedor");
		
		JButton btnEditaVendedor = new JButton("Editar Vendedor");
		
		JButton btnRemoveVendedor = new JButton("Remover Vendedor");
		
		JButton btnVisualizaVendedores = new JButton("Visualizar Vendedores");
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(btnCadastraVendedor);
		panel.add(btnEditaVendedor);
		panel.add(btnRemoveVendedor);
		panel.add(btnVisualizaVendedores);
		panel.add(btnVoltar);

	}
	
	public void actionPerformed(ActionEvent e) {
		AdministradorController administradorController = new AdministradorController();
		this.administrador = administradorController.readOneAdmin(email);
	}

	public JFrame getFrame() {
		return frmAdmVendedoresView;
	}


	public void setFrame(JFrame frame) {
		this.frmAdmVendedoresView = frame;
	}
}
