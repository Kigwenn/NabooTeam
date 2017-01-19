package Planning;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenetreAdmin extends FenetreDeBase implements MouseListener{

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);
	
	public FenetreAdmin() throws HeadlessException {
		this.setTitle("Admin");

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
		pan1.setLayout(new BorderLayout(10, 10));
		this.setContentPane(pan1);
		
		JPanel pan2 = new JPanel();
		pan1.add(pan2, BorderLayout.SOUTH);

		JLabel messageAccueil = new JLabel();
		messageAccueil.setText("Bienvenue sur le menu du planning de l'IMIE. Enjoy!");
		messageAccueil.setFont(font4);
		pan1.add(messageAccueil, BorderLayout.NORTH);
		
		JButton gestionMembre = new JButton("Gestion membre");
		gestionMembre.setFont(font2);
		gestionMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionMembre gestion = new GestionMembre();
				}
			}
		);
		pan2.add(gestionMembre);
		gestionMembre.addMouseListener(this);
		JButton gestionPlanning = new JButton("Gestion planning");
		gestionPlanning.addMouseListener(this);
		gestionPlanning.setFont(font2);
		gestionPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionPlanning gestion = new GestionPlanning();
				}
			}
		);
		pan2.add(gestionPlanning);
		
//		JButton gestionSalle = new JButton("Gestion Salle");
//		gestionSalle.setFont(font2);
//		pan2.add(gestionSalle);
//		gestionSalle.addMouseListener(this);
//		JButton gestionEquipement = new JButton("Gestion Equipement");
//		gestionEquipement.setFont(font2);
//		pan3.add(gestionEquipement);
//		gestionEquipement.addMouseListener(this);
		
		this.setVisible(true);
	}

	public FenetreAdmin(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
	}

	public void mouseClicked(MouseEvent arg0) {
		this.setVisible(false);
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
