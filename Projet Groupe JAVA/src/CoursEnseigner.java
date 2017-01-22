import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CoursEnseigner {

//───── Attributs ────────────────────────────────────────────────
	
		private String nom;
		private int cou_id;	
		
//───── Constructeurs ────────────────────────────────────────────
			
		public CoursEnseigner() {
		}
		
		public CoursEnseigner(int a, int b){
		}
		
//───── Methodes ─────────────────────────────────────────────────
			
		public boolean createCours(){
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌─────────────────────────────────┐");
		System.out.println("\t\t  │   Cours - Matiere - Enseignant  │");
		System.out.println("\t\t  └─────────────────────────────────┘\n");
		System.out.print("\t\t  ID du cours : ");
		int idc = sc.nextInt();
		System.out.print("\t\t  ID de la matiere : ");
		int idm = sc.nextInt();;
		System.out.print("\t\t  ID enseignat : ");
		int ide = sc.nextInt();
			
		boolean	res = false;
				
		String query = "INSERT INTO constituer (cou_id,mat_id,mem_id) VALUES (?,?,?);";
						
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setInt(1, idc);
			prepare.setInt(2, idm);
			prepare.setInt(3, ide);				
			
			prepare.execute();
					
			ResultSet result = prepare.getResultSet();
			if(result.first()) {
				res = true;
				System.out.println("\n             Votre cours vient d'etre constitué !\n");
				}
			}
					
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return res;
			
		}

		public boolean listeCours(){
		    
		    String query = "SELECT * ";
		    query +=" FROM constituer";
	        			    
		    int i=0;
		    try {
		    	PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
		    	prepare.execute();
				ResultSet result = prepare.getResultSet();
			    //ResultSet result = state.executeQuery(query);
				    
			    System.out.println("         ┌───────────────────┬──────────┬───────────┬────────┐" );
			    System.out.println("         │  Nom du cours	 │ Matieres │ Form. Nom │ Prenom │" );
			    System.out.println("┌────────┼───────────────────┼──────────┼───────────┼────────┘" );
			    
			    while(result.next()) {
				    i+=1;
				    System.out.print("│ "+i+"\t │  "+result.getString("cou_id"));	
				    System.out.println("\t │  "+result.getString("mat_id")+"\t │");
				}
			    
			    System.out.println("└────────┴───────────────────┴──────────┴───────────┴────────┘" );
			    
		    }
		    
		    catch (SQLException e) {
				e.printStackTrace();
		    }
		   
		    return true;
		}
		
		public boolean supprCours(){
			
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

