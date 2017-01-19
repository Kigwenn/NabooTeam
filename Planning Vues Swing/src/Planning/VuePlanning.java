package Planning;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VuePlanning extends FenetreDeBase implements MouseListener {

	public VuePlanning() {
		this.setTitle("Gestion du planning");


		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);

		
		
		
		
		
		
		
		JMenu fichier = new JMenu("Fichier");
		fichier.setFont(font2);
		barreMenus.add(fichier);
		JMenu edition = new JMenu("Edition");
		edition.setFont(font2);
		barreMenus.add(edition);
		JMenu vue = new JMenu("Vue");
		vue.setFont(font2);
		barreMenus.add(vue);
		JButton vueJour = new JButton("     Vue jour    ");
		vueJour.setFont(font2);
		JButton vueSemaine = new JButton(" Vue semaine ");
		vueSemaine.setFont(font2);
		vue.add(vueJour);
		vue.add(vueSemaine);
		JButton administration = new JButton("Administration");
		administration.setFont(font2);
		edition.add(administration);
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setFont(font2);
		fichier.add(deconnexion);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		JButton menu = new JButton("       Menu      ");
		menu.setFont(font2);
		menu.addMouseListener(this);
		fichier.add(menu);
		JButton quitter = new JButton("      Quitter     ");
		quitter.setFont(font2);
		fichier.add(quitter);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop;
				int retour;
				jop = new JOptionPane();
				retour = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?", "Quitter?", JOptionPane.YES_NO_OPTION);
				if(retour == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		
		JPanel pan2 = new JPanel();
		pan1.add(pan2, BorderLayout.SOUTH);


		JPanel pan3 = new JPanel();
		pan2.add(pan3, BorderLayout.NORTH);

		JPanel pan4 = new JPanel();
		pan2.add(pan4, BorderLayout.CENTER);
		JLabel messageAccueil = new JLabel();
		messageAccueil.setText("Bienvenue sur le planning de l'IMIE. Enjoy!");
		messageAccueil.setFont(font4);
		pan1.add(messageAccueil, BorderLayout.NORTH);
		
//		JTable tableau = new JTable();
		
		
		this.setVisible(true);
	}

	
	public void mouseClicked(MouseEvent arg0) {
		this.setVisible(false);
		FenetreMembre fen = new FenetreMembre();
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
