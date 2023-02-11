package view;

import javax.swing.JFrame;

import model.Vendedor;

public class VendedoresView {

	private JFrame frame;


	public VendedoresView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	
	public JFrame getFrame(){
		return frame;
	}

}
