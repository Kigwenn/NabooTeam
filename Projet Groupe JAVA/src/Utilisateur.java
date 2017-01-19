import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//───── Attributs ────────────────────────────────────────────────
public class Utilisateur extends Membres {
	
	private int com_id = 0; 
	private int dro_id = 0; 
	
	
	
//───── Constructeurs ────────────────────────────────────────────

	public Utilisateur(){
		saisirLogin();
		checkLogin();
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
		
		return false;
	}
	
}
