package view;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;

import model.Vendedor;

public class VendasView {

	private JFrame frame;



	/**
	 * Create the application.
	 */
	public VendasView(Vendedor vendedor) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(vendedor);
	}



	public JFrame getFrame() {
		return frame;
	}
	
	
	
	
	
}

