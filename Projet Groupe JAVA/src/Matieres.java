import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Matieres {

	//───── Attributs ────────────────────────────────────────────────
	
		private String nom;
				
	//───── Constructeurs ────────────────────────────────────────────
		
		public Matieres() {
			newMatieres();
			createMatieres();
		}
		
	//───── Methodes ─────────────────────────────────────────────────
		
		public void newMatieres(){
			Scanner sc = new Scanner(System.in);
			System.out.println("");
			System.out.println("\t\t  ┌──────────────────────┐");
			System.out.println("\t\t  │        Matieres      │");
			System.out.println("\t\t  └──────────────────────┘\n");
			System.out.print("\t\t  Nom de la matiere : ");
			nom = sc.nextLine();
			
		}
		
		public boolean createMatieres(){
		boolean	res = false;
			
		String query = "INSERT INTO matieres (mat_nom) VALUES (?) RETURNING mat_id;";
					
			try {
				PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				prepare.setString(1, nom);
										
				prepare.execute();
				
				ResultSet result = prepare.getResultSet();
				if(result.first()) {
					res = true;
					System.out.println("\n             Une matiere vient d'etre créer !\n");
				}
			}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
			return res;
		}


	//───── Getter / Setter ──────────────────────────────────────────

		public String getNom() {
			return nom;
		}
		
		public void setNom(String nom) {
			this.nom = nom;
		}
			
}
