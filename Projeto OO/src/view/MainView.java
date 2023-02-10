package view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainView implements ActionListener {

	private JFrame frame;
	private JLabel nomeLoja;
	private JButton createAdminButton;
	private JButton createLogoutButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainView window = new MainView();
		window.frame.setVisible(true);
		

	}

	/**
	 * Create the application.
	 */
	public MainView() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		nomeLoja = new JLabel("Seja Bem vindo(a) !!");
		
		nomeLoja.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nomeLoja.setHorizontalAlignment(SwingConstants.CENTER);
		
		createAdminButton = new JButton("Iniciar Sistema");
		createAdminButton.addActionListener(this);
		
		createLogoutButton = new JButton("Sair");
		createLogoutButton.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(271)
					.addComponent(nomeLoja, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addGap(252))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(createAdminButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(337))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(346)
					.addComponent(createLogoutButton, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(337))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(nomeLoja, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(createAdminButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(createLogoutButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(191))
		);
		frame.getContentPane().setLayout(groupLayout);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createAdminButton) {
			CreateAdmin administrador = new CreateAdmin();
			administrador.getFrame().setVisible(true);
			frame.dispose();
		}
		if (e.getSource() == createLogoutButton) {
			System.exit(0);
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	}
	



