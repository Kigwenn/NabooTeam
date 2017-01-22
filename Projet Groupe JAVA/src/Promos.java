import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Promos {
//───── Attributs ────────────────────────────────────────────────
	
	protected String nom;
	protected int capacite;
	protected String description;
	protected int com_id = 0; 
	protected int dro_id = 0; 
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Promos() {
	}
	
	public Promos(int a, int b){
	}
//───── Methodes ─────────────────────────────────────────────────
	
	public boolean createPromo(){
	boolean	res = false;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("");
	System.out.println("\t\t  ┌────────────────────────────┐");
	System.out.println("\t\t  │      Nouvelle  Promos      │");
	System.out.println("\t\t  └────────────────────────────┘\n");
	System.out.print("\t\t  Nom de la promo : ");
	nom = sc.nextLine();
	System.out.print("\n\t\t  Capacité : ");
	capacite = sc.nextInt();
	sc.nextLine();
	System.out.print("\n\t\t  Descriptions : ");
	description = sc.nextLine();
	
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
	
	public boolean listePromos(){
		    
	    String query = "SELECT pro_id, pro_nom, pro_nb, pro_description";
	    query +=" FROM promo";
	        			    
	    int i=0;
	    try {
	    	PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
	    	prepare.execute();
			ResultSet result = prepare.getResultSet();
		    //ResultSet result = state.executeQuery(query);
			    
		    System.out.println("         ┌───────┬───────────────┬───────┬───────────────┐" );
		    System.out.println("         │ id    │ Nom		 │ Cap.  │ Description	 │" );
		    System.out.println("┌────────┼───────┼───────────────┼───────┼───────────────┘" );
		    
		    while(result.next()) {
			    i+=1;
			    System.out.print("│ "+i+"\t │  "+result.getString("pro_id"));	
			    System.out.print("\t │  "+result.getString("pro_nom")+"\t │   "+result.getString("pro_nb"));
			    System.out.println("\t │  "+result.getString("pro_description")+"\t ");
			}
		    
		    System.out.println("└────────┴───────┴───────────────┴───────┘" );
		    
	    }
	    
	    catch (SQLException e) {
			e.printStackTrace();
	    }
	   
	    return true;
	}
	
	public boolean supprPromos(){
		
		boolean	res = false;
		
	    Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌───────────────────────┐");
		System.out.println("\t\t  │ SUPPRIMER UNE PROMOS  │");
		System.out.println("\t\t  └───────────────────────┘\n");
		
		System.out.print("\t\t    ID : ");
		int id = sc.nextInt();
		
		//if(super.checkId()){
				
		String query = "DELETE FROM promo WHERE pro_id=?;"; 
		    
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setInt(1, id);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
							
			System.out.println("Supprimer !");
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		//}
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





