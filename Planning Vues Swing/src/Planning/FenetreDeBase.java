package Planning;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public abstract class FenetreDeBase extends JFrame {

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);
	
	public FenetreDeBase(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public FenetreDeBase() throws HeadlessException {
		this.setSize(1500, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);
		
		this.setVisible(true);
	}

	public FenetreDeBase(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}
