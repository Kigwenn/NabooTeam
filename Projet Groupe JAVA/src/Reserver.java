import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Reserver {

//───── Attributs ────────────────────────────────────────────────
	
	private String nom;
	private int cou_id;	
		
//───── Constructeurs ────────────────────────────────────────────
			
	public Reserver() {
	}
		
	public Reserver(int a, int b){
	}
		
//───── Methodes ─────────────────────────────────────────────────
			
	public boolean createReservations(){
	
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌─────────────────────────────────┐");
		System.out.println("\t\t  │   Promo - Cours - Salle - Date  │");
		System.out.println("\t\t  └─────────────────────────────────┘\n");
		System.out.print("\t\t  ID promo : ");
		int idp = sc.nextInt();
		System.out.print("\t\t  ID cours : ");
		int idc = sc.nextInt();;
		System.out.print("\t\t  ID salle : ");
		int ids = sc.nextInt();
		sc.nextLine();
		System.out.print("\t\t  dates : ");
		String idd = sc.nextLine();
				
		boolean	res = false;
				
		String query = "INSERT INTO reserver (pro_id,cou_id,sal_id,res_date) VALUES (?,?,?,?);";
							
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setInt(1, idp);
			prepare.setInt(2, idc);
			prepare.setInt(3, ids);				
			prepare.setString(4, idd);
				
			prepare.execute();
						
		ResultSet result = prepare.getResultSet();
		
		if(result.first()) {
			res = true;
			System.out.println("\n             Votre reservation a d'été valider !\n");
			}
		}
				
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean listeReservations(){
		    
	    String query = "SELECT promo.pro_nom, cours.cou_nom, salle.sal_nom, membres.mem_nom, membres.mem_prenom, reserver.res_date ";
	    query +=" FROM promo";
	    query +=" INNER JOIN reserver ON promo.pro_id = reserver.pro_id";
	    query +=" INNER JOIN salle ON reserver.pro_id = salle.sal_id";
	    query +=" INNER JOIN cours ON reserver.cou_id = cours.cou_id";
	    query +=" INNER JOIN constituer ON cours.cou_id = constituer.cou_id";
	    query +=" INNER JOIN membres ON constituer.mem_id = membres.mem_id";
		    
	    int i=0;
	    try {
	    	PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
	    	prepare.execute();
			ResultSet result = prepare.getResultSet();
					    
		    System.out.println("┌──────────────┬──────────────┬───────────┬────────┬────────┐" );
		    System.out.println("│  Promo       │ cours        │ Form. Nom │ Prenom │  Date  │" );
		    System.out.println("┼──────────────┼──────────────┼───────────┼────────┼────────┘" );
			    
		    while(result.next()) {
			    i+=1;
			    System.out.print("│  "+result.getString("pro_nom"));	
			    System.out.print(" │  "+result.getString("cou_nom"));
			    System.out.print(" │  "+result.getString("sal_nom"));
			    System.out.print(" │  "+result.getString("mem_nom"));
			    System.out.print(" │  "+result.getString("mem_prenom"));	
			    System.out.println("\t │  "+result.getString("res_date")+"\t │");
			}
			    
		    System.out.println("└──────────────┴──────────────┴───────────┴────────┴────────┘" );
			    
		    }
		    
		    catch (SQLException e) {
				e.printStackTrace();
		    }
		   
		    return true;
		}
		
	public boolean supprReservations(){
			
		boolean	res = false;
			
	    Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌───────────────────────┐");
		System.out.println("\t\t  │   SUPPRIMER UN COURS  │");
		System.out.println("\t\t  └───────────────────────┘\n");
					
		System.out.print("\t\t    ID : ");
		int id = sc.nextInt();
			
		String query = "DELETE FROM cours WHERE cou_id=?;";
					
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setInt(1, id);
			prepare.execute();
			ResultSet result = prepare.getResultSet();
				
			res = true;
			System.out.println("\n             Le cours à été supprimer !\n");
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

