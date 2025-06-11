package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Vendedor;

public class CreateVenda {

	private JFrame frame;



	/**
	 * Create the application.
	 */
	public CreateVenda(Vendedor vendedor) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public JFrame getFrame() {
		return frame;
	}
}
