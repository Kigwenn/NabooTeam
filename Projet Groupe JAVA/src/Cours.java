import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Cours {

//───── Attributs ────────────────────────────────────────────────
		
	private String nom;
	private int cou_id;	
//───── Constructeurs ────────────────────────────────────────────
		
	public Cours() {
		newCours();
		createCours();
	}
		
//───── Methodes ─────────────────────────────────────────────────
		
		public void newCours(){
			Scanner sc = new Scanner(System.in);
			System.out.println("");
			System.out.println("\t\t  ┌──────────────────────┐");
			System.out.println("\t\t  │        Cours         │");
			System.out.println("\t\t  └──────────────────────┘\n");
			System.out.print("\t\t  Nom du cours : ");
			nom = sc.nextLine();
			
		}
		
		public boolean createCours(){
			boolean	res = false;
			
			String query = "INSERT INTO cours (cou_nom) VALUES (?) RETURNING cours_id;";
					
			try {
				PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				prepare.setString(1, nom);
						
				prepare.execute();
				
				ResultSet result = prepare.getResultSet();
				if(result.first()) {
					res = true;
					System.out.println("\n             Votre cours vient d'etre créer !\n");
				}
			}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
			return res;
		}

		public boolean delCours(){
		newCours();
		boolean	res = false;
		
		String query = "SELECT * FROM cours WHERE cou_nom=? RETURNING cou_id ;";
						
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, nom);
						
			prepare.execute();
						
			ResultSet result = prepare.getResultSet();
			cou_id = result.getInt("cou_id");
			
			if(result.first()) {
				
				String query2 = "DELETE FROM cours WHERE cou_id="+cou_id+";";
				
				PreparedStatement prepare2 = LinkBdd.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//				prepare.setString(1, nom);
							
				prepare2.execute();
			
				ResultSet result2 = prepare2.getResultSet();
				
						
				res = true;
				System.out.println("\n             Le cours à été supprimer !\n");
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
