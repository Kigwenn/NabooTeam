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
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GestionMembre extends FenetreDeBase implements MouseListener {

	public GestionMembre() {
		this.setTitle("Gestion des membres");


		JMenuBar barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);

		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setFont(font2);
		barreMenus.add(deconnexion);
		JButton menu = new JButton("Menu");
		menu.setFont(font2);
		barreMenus.add(menu);
		menu.addMouseListener(this);
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


		JPanel pan3 = new JPanel();
		pan2.add(pan3, BorderLayout.NORTH);

		JPanel pan4 = new JPanel();
		pan2.add(pan4, BorderLayout.CENTER);
		JLabel messageAccueil = new JLabel();
		messageAccueil.setText("Bienvenue sur la gestion des membres de l'IMIE. Enjoy!");
		messageAccueil.setFont(font4);
		pan1.add(messageAccueil, BorderLayout.NORTH);
		
		String[] columnNames = {"Salle",
                "Nom de Promotion",
                "Formateur",
                "Cours",
                "Date"};
		
		Object[][] data = {
			    {"Naboo", "JMQ DL",
			     "Johan", "Java", "du 16/01/2017 au 20/01/2017"},
			   
			};
		
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollpane = new JScrollPane(table);
		
		
		pan2.add(table, BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}

	
	public void mouseClicked(MouseEvent arg0) {
		this.setVisible(false);
		FenetreAdmin fen = new FenetreAdmin();
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
