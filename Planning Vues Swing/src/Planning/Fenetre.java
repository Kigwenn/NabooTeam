package Planning;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonQuitter = new JButton("Quitter");
	private JLabel label1 = new JLabel("Bienvenue");
	private JLabel label2 = new JLabel("Gestion Planning IMIE");
	
	
	public Fenetre() {	
		this.setTitle("Connexion");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial",Font.BOLD,40);
		Font font2 = new Font("Arial",Font.BOLD,25);
		Font font3 = new Font("Arial",Font.BOLD,50);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1));
		pan1.add(pan2, BorderLayout.CENTER);
		label1.setHorizontalAlignment(pan1.getWidth());
		label1.setFont(font);
		pan2.add(label1);
		
		JPanel pan3 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1));
		pan1.add(pan3, BorderLayout.SOUTH);
		boutonConnexion.setFont(font2);
		boutonQuitter.setFont(font2);
		pan3.add(boutonConnexion);
		pan3.add(boutonQuitter);
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new GridLayout(1, 1));
		pan1.add(pan4, BorderLayout.NORTH);
		label2.setHorizontalAlignment(pan1.getWidth());
		label2.setFont(font3);
		pan4.add(label2);
		
		this.setVisible(true);
	}

}
