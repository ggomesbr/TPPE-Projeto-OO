package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ClientesView {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public ClientesView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


}
