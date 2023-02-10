package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Vendedor;

public class FolhaPagamentoView {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FolhaPagamentoView(Vendedor vendedor) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

}
