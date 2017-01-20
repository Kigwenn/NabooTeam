import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//───── Attributs ────────────────────────────────────────────────
public class Utilisateur extends Membres {
	
	protected int com_id = 0; 
	protected int dro_id = 0; 
	protected int id;
	
//───── Constructeurs ────────────────────────────────────────────

	public Utilisateur(){
		saisirLogin();
		checkLogin();
	}
	
	public Utilisateur(int a, int b){
		
	}

//───── Methodes ─────────────────────────────────────────────────

	public void saisirLogin()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Nom d'utilisateur : ");
		login = sc.nextLine();
		System.out.print("mot de passe : ");
		pw = sc.nextLine();
	}
	
	
	public boolean checkLogin()
	{
		String query = "SELECT com_login FROM comptes WHERE com_login=?;";
		String query2 = "SELECT * FROM comptes WHERE com_login=? AND com_pw=?;";
	
	
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, login);
			
			ResultSet result = prepare.executeQuery();
			
			//Si login existe
			if(result.first()) {
				
				PreparedStatement prepare2 = LinkBdd.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepare2.setString(1, login);
				prepare2.setString(2, pw);
				
				ResultSet result2 = prepare2.executeQuery();
				
				//user identifie
				if(result2.first())	{
					
					//System.out.println("\n Login OK !\n");
					
					//On remplit nos attibuts
					com_id = result2.getInt("com_id");
					dro_id = result2.getInt("dro_id");
					//System.out.println("com_id :"+com_id);
					//System.out.println("dro_id :"+dro_id);
					
					String query3 = "SELECT * FROM membres WHERE com_id="+com_id+";";
					
					PreparedStatement prepare3 = LinkBdd.getInstance().prepareStatement(query3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet result3 = prepare3.executeQuery();
					
					if(result3.first())	{
						
						if(result3.getString("mem_nom") != null)
							nom = result3.getString("mem_nom");
						if(result3.getString("mem_prenom") != null)
							prenom = result3.getString("mem_prenom");
						System.out.println("\nIdentification de "+nom+" "+prenom+" Ok !\n");
					}
				
					Menu objMenu = new Menu(com_id,dro_id);
					
				return true;
				}
					
				//Mot de passe non valide !
				else
				{
					System.out.println("\nMot de passe est invalide !\n");
					return false;
				}
			}
			else
			{
				System.out.println("\nLe login saisi n'existe pas !\n");
				return false;
			}
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}		
	
	public boolean listeUtilisateur(){
				  		    
	    String query = "SELECT membres.mem_id, membres.mem_nom, membres.mem_prenom, membres.mem_adresse, membres.mem_cp, membres.mem_ville, membres.mem_tel, droits.dro_nom";
	    query +=" FROM comptes";
	    query +=" INNER JOIN membres ON comptes.com_id = membres.com_id";
	    query +=" INNER JOIN droits ON droits.dro_id = comptes.dro_id";
		    			    
	    int i=0;
	    try {
	    	PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
	    	prepare.execute();
			ResultSet result = prepare.getResultSet();
		    //ResultSet result = state.executeQuery(query);
			    
		    System.out.println("         ┌───────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬───────────────┐" );
		    System.out.println("         │ id    │ Nom		 │ Prenom        │ Adresse	 │ Code post.    │ Ville         │ tel.          │ Droits        │" );
		    System.out.println("┌────────┼───────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┼───────────────┤" );
		    while(result.next()){
			    i+=1;
			    System.out.print("│ "+i+"\t │  "+result.getString("mem_id"));	
			    System.out.print("\t │  "+result.getString("mem_nom")+"\t │   "+result.getString("mem_prenom"));
			    System.out.print("\t │  "+result.getString("mem_adresse")+"\t │   "+result.getString("mem_cp"));
			    System.out.print("\t │  "+result.getString("mem_ville")+"\t │   "+result.getString("mem_tel"));
			    System.out.println("\t │  "+result.getString("dro_nom")+"\t │");
		    }
		    System.out.println("└────────┴───────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴───────────────┘" );
		    
	    }
	    
	    catch (SQLException e) {
			e.printStackTrace();
	    }
	   
	    return true;
	}
	
	public boolean supprUtilisateur(){
		
		boolean	res = false;
		
	    Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │ SUPPRIMER UN COMPTE  │");
		System.out.println("\t\t  └──────────────────────┘\n");
		
		
		
		System.out.print("\t\t    ID : ");
		id = sc.nextInt();
		
		if(super.checkId()){
				
			String query = "DELETE FROM membres WHERE mem_id=?;"; 
		    
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
			
		}
	return res;
	}
	
	
}
	