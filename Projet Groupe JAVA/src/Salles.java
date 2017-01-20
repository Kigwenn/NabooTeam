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
	}
	
	public Salles(int a, int b){
	}
	
//───── Methodes ─────────────────────────────────────────────────
	
	public boolean createSalles(){
		boolean	res = false;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │   Nouvelle  Salles   │");
		System.out.println("\t\t  └──────────────────────┘\n");
		System.out.print("\t\t  Nom de la salle : ");
		nom = sc.nextLine();
		System.out.print("\n\t\t  Capacité : ");
		capacite = sc.nextInt();
		sc.nextLine();	
			
		String query = "INSERT INTO salle (sal_nom, sal_capacite) VALUES (?,?) RETURNING sal_id;";
				
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, nom);
			prepare.setInt(2, capacite);

			prepare.execute();
			
			ResultSet result = prepare.getResultSet();
			if(result.first()) {
				res = true;
				System.out.println("\n             Votre salle vient d'etre créer !\n");
			}
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean listeSalles(){
	    
	    String query = "SELECT sal_id, sal_nom";
	    query +=" FROM salle";
	        			    
	    int i=0;
	    try {
	    	PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
	    	prepare.execute();
			ResultSet result = prepare.getResultSet();
		    //ResultSet result = state.executeQuery(query);
			    
		    System.out.println("         ┌───────┬───────────────┐" );
		    System.out.println("         │ id    │ Nom		 │" );
		    System.out.println("┌────────┼───────┼───────────────┤" );
		    
		    while(result.next()) {
			    i+=1;
			    System.out.print("│ "+i+"\t │  "+result.getString("sal_id"));	
			    System.out.println("\t │  "+result.getString("sal_nom")+"\t │");
			}
		    
		    System.out.println("└────────┴───────┴───────────────┘" );
		    
	    }
	    
	    catch (SQLException e) {
			e.printStackTrace();
	    }
	   
	    return true;
	}
	
	public boolean supprSalles(){
		
		boolean	res = false;
		
	    Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌─────────────────────┐");
		System.out.println("\t\t  │ SUPPRIMER UNE SALLE │");
		System.out.println("\t\t  └─────────────────────┘\n");
				
		System.out.print("\t\t    ID : ");
		int id = sc.nextInt();
		
		String query = "DELETE FROM salle WHERE sal_id=?;";
				
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setInt(1, id);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
				
			res = true;
			System.out.println("\n             La salle à été supprimer !\n");
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
