import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Promos {
//───── Attributs ────────────────────────────────────────────────
	
	private String nom;
	private int capacite;
	private String description;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Promos() {
		newPromo();
		createPromo();
	}
	
//───── Methodes ─────────────────────────────────────────────────
	
	public void newPromo(){
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │        Promos        │");
		System.out.println("\t\t  └──────────────────────┘\n");
		System.out.print("\t\t  Nom de la promo : ");
		nom = sc.nextLine();
		System.out.print("\n\t\t  Capacité : ");
		capacite = sc.nextInt();
		sc.nextLine();
		System.out.print("\n\t\t  Descriptions : ");
		description = sc.nextLine();
	}
	
	public boolean createPromo(){
	boolean	res = false;
		
	String query = "INSERT INTO promo (pro_nom, pro_nb, pro_description) VALUES (?,?,?) RETURNING pro_id;";
				
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, nom);
			prepare.setInt(2, capacite);
			prepare.setString(3, description);
					
			prepare.execute();
			
			ResultSet result = prepare.getResultSet();
			if(result.first()) {
				res = true;
				System.out.println("\n             Votre promos vient d'etre créer !\n");
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}					





