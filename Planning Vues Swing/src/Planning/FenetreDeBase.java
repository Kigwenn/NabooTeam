package Planning;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public abstract class FenetreDeBase extends JFrame {

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);
	
	public FenetreDeBase(GraphicsConfiguration arg0) {
		super(arg0);
	}

	public FenetreDeBase() throws HeadlessException {
		this.setSize(1700, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);
			
		JMenu fichier = new JMenu("Fichier");
		fichier.setFont(font2);
		barreMenus.add(fichier);
		
//		AJOUTER UN IF POUR AJOUTER LE BOUTON EDITION UNIQUEMENT AUX ADMINISTRATEURS
		JMenu edition = new JMenu("Edition");
		edition.setFont(font2);
		barreMenus.add(edition);
		JMenu vue = new JMenu("Vue");
		vue.setFont(font2);
		barreMenus.add(vue);
		JButton seDeconnecter = new JButton(" Se Déconnecter  ");
		seDeconnecter.setFont(font2);
		fichier.add(seDeconnecter);
		JButton quitter = new JButton("         Quitter         ");
		quitter.setFont(font2);
		fichier.add(quitter);
		JButton vueJour = new JButton("     Vue jour    ");
		vueJour.setFont(font2);
		JButton vueSemaine = new JButton(" Vue semaine ");
		vueSemaine.setFont(font2);
		vue.add(vueJour);
		vue.add(vueSemaine);
		JButton administration = new JButton("Administration");
		administration.setFont(font2);
		edition.add(administration);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan1.add(pan2, BorderLayout.SOUTH);
		JButton retour = new JButton("Retour");
		retour.setFont(font2);
		retour.setPreferredSize(new Dimension(200, 60));
		pan2.add(retour);
		
		
		
		this.setVisible(true);
	}

	public FenetreDeBase(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

}
