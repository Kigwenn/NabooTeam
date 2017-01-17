package Planning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreConnexion extends JFrame implements MouseListener {
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonQuitter = new JButton("Quitter");
	private JLabel labelBienvenue = new JLabel("Bienvenue");
	private JLabel labelTitre = new JLabel("Gestion Planning IMIE");
	private JLabel labelIdentifiant = new JLabel("Identifiant: ");
	
	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	
	
	public FenetreConnexion(String a) {	
		this.setTitle(a);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1));
		pan1.add(pan2, BorderLayout.CENTER);
		labelBienvenue.setHorizontalAlignment(pan1.getWidth());
		labelBienvenue.setFont(font);
		pan2.add(labelBienvenue);
		
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
		labelTitre.setHorizontalAlignment(pan1.getWidth());
		labelTitre.setFont(font3);
		pan4.add(labelTitre);
		
		this.setVisible(true);
	}
	
	public FenetreConnexion(String a, int b) {	
		this.setTitle(a);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1));
		pan1.add(pan2, BorderLayout.CENTER);
		labelIdentifiant.setFont(font2);
		pan2.add(labelIdentifiant);	
		
		JPanel pan3 = new JPanel();
		pan2.setLayout(new GridLayout(1, 1));
		pan1.add(pan3, BorderLayout.SOUTH);
		boutonQuitter.setFont(font2);
		pan3.add(boutonQuitter);	
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new GridLayout(1, 1));
		pan1.add(pan4, BorderLayout.NORTH);
		labelTitre.setHorizontalAlignment(pan1.getWidth());
		labelTitre.setFont(font3);
		pan4.add(labelTitre);
		
		
		this.setVisible(true);
	}


	
	public void mouseClicked(MouseEvent arg0) {
	}


	
	public void mouseEntered(MouseEvent arg0) {
	}


	
	public void mouseExited(MouseEvent arg0) {
	}


	
	public void mousePressed(MouseEvent arg0) {
	}


	
	public void mouseReleased(MouseEvent arg0) {
	}

}
