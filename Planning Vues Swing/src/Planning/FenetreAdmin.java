package Planning;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class FenetreAdmin extends JFrame {

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);
	
	public FenetreAdmin() throws HeadlessException {
	}

	public FenetreAdmin(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public FenetreAdmin(String a) throws HeadlessException {
		this.setTitle(a);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);
		
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setFont(font2);
		barreMenus.add(deconnexion);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan1.add(pan2, BorderLayout.SOUTH);
		
		
		JPanel pan3 = new JPanel();
		pan2.add(pan3, BorderLayout.NORTH);
		
		JPanel pan4 = new JPanel();
		pan2.add(pan4, BorderLayout.CENTER);
		JLabel messageAccueil = new JLabel();
		messageAccueil.setText("Bienvenue sur le menu du planning de l'IMIE. Enjoy!");
		messageAccueil.setFont(font4);
		pan1.add(messageAccueil, BorderLayout.NORTH);
		
		
		
		
		
		
		
		this.setVisible(true);
	}

	public FenetreAdmin(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}
