package Planning;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreConnexion extends JFrame implements MouseListener{
	private JButton boutonConnexion = new JButton("Connexion");
	private JButton boutonQuitter = new JButton("Quitter");
	private JButton boutonValider = new JButton("Valider");
	private JLabel labelBienvenue = new JLabel("Bienvenue");
	private JLabel labelTitre = new JLabel("Gestion Planning IMIE");
	private JLabel labelIdentifiant = new JLabel("Identifiant:  ");
	private JLabel labelMdp = new JLabel("Password:  ");
	private JTextField champ1 = new JTextField(" ");
	private JTextField champ2 = new JTextField(" ");

	Font font = new Font("Arial",Font.BOLD,40);
	Font font2 = new Font("Arial",Font.BOLD,25);
	Font font3 = new Font("Arial",Font.BOLD,50);
	Font font4 = new Font("Arial",Font.BOLD,35);


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
		boutonConnexion.addMouseListener(this);
		pan3.add(boutonQuitter);
		boutonQuitter.addActionListener(new ActionListener() {
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
		pan1.setLayout(new BorderLayout());
		this.setContentPane(pan1);



		JPanel pan2 = new JPanel();
		labelIdentifiant.setFont(font2);
		pan2.add(labelIdentifiant);	
		pan1.add(pan2);
		champ1.setPreferredSize(new Dimension(400, 30));
		champ1.setFont(font2);
		pan2.add(champ1);
		labelMdp.setFont(font2);
		pan2.add(labelMdp);
		champ2.setPreferredSize(new Dimension(400, 30));
		champ2.setFont(font2);
		pan2.add(champ2);
		pan2.add(boutonValider);
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


			}
		}
				);

		JPanel pan3 = new JPanel();
		pan1.add(pan3, BorderLayout.SOUTH);
		boutonQuitter.setFont(font2);
		boutonQuitter.addActionListener(new ActionListener() {
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
		this.setVisible(false);
		FenetreConnexion fen = new FenetreConnexion("Login", 1);
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
