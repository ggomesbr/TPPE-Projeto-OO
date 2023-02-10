package view;

import javax.swing.JFrame;

import model.Vendedor;

public class VendedorInfoView {

	private JFrame frame;


	public VendedorInfoView(Vendedor selectedVendedor) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	
	public JFrame getFrame(){
		return frame;
	}

}
