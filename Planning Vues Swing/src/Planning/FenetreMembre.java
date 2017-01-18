package Planning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenetreMembre extends FenetreDeBase implements MouseListener{

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);
	
	public FenetreMembre() throws HeadlessException {
		this.setTitle("Membre");
		
		
		

		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);
		
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setFont(font2);
		barreMenus.add(deconnexion);
		JButton quitter = new JButton("Quitter");
		quitter.setFont(font2);
		barreMenus.add(quitter);
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
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		this.setContentPane(pan1);
						
		JPanel pan2 = new JPanel();
		pan1.add(pan2, BorderLayout.SOUTH);

		
		JLabel messageAccueil = new JLabel();
		messageAccueil.setText("Bienvenue sur le menu du planning de l'IMIE. Enjoy!");
		messageAccueil.setFont(font4);
		pan1.add(messageAccueil, BorderLayout.NORTH);
		
//		A AJOUTER POUR AVOIR LE BOUTON VOIR PROFIL EN BAS
//		JButton voirProfil = new JButton("Voir profil");
//		voirProfil.setFont(font2);
//		pan2.add(voirProfil);
//		voirProfil.addMouseListener(this);
		
		JButton voirPlanning = new JButton("Voir planning");
		voirPlanning.setFont(font2);
		pan2.add(voirPlanning);
		voirPlanning.addMouseListener(this);
		voirPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VuePlanning gestion = new VuePlanning();
				}
			}
		);
		
		
		this.setVisible(true);
	}

	
	public void mouseClicked(MouseEvent e) {
		this.setVisible(false);
	}

	
	public void mouseEntered(MouseEvent e) {
	}

	
	public void mouseExited(MouseEvent e) {
	}

	
	public void mousePressed(MouseEvent e) {
	}

	
	public void mouseReleased(MouseEvent e) {
	}
}







