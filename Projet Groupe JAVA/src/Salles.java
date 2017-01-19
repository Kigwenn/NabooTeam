import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Salles {
//───── Attributs ────────────────────────────────────────────────
	
	private String nom;
	private int capacite;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Salles() {
		newSalles();
		createSalles();
	}
	
//───── Methodes ─────────────────────────────────────────────────
	
	public void newSalles(){
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │        Salles        │");
		System.out.println("\t\t  └──────────────────────┘\n");
		System.out.print("\t\t  Nom de la salle : ");
		nom = sc.nextLine();
		System.out.print("\n\t\t  Capacité : ");
		capacite = sc.nextInt();
		sc.nextLine();

	}
	
	public boolean createSalles(){
	boolean	res = false;
		
	String query = "INSERT INTO promo (sal_nom, sal_nb) VALUES (?,?) RETURNING sal_id;";
				
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, nom);
			prepare.setInt(2, capacite);

					
			prepare.execute();
			
			ResultSet result = prepare.getResultSet();
			if(result.first()) {
				res = true;
				System.out.println("\n             Votre salles vient d'etre créer !\n");
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
	
	public int getCapacite() {
		return capacite;
	}
	
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

}					
