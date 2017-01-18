import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public abstract class Membres_copie {

//───── Attributs ────────────────────────────────────────────────
		
	protected int idMembres;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected int cp;
	protected String ville;
	protected MaDate dateEntree;
	protected MaDate dateSortie;
	protected boolean Actvif;
		
	private String login ;
	private String pw ;	
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Membres_copie() {
	}
	
//───── Methodes ─────────────────────────────────────────────────
	
	public void identification(){
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │      Connection      │");
		System.out.println("\t\t  └──────────────────────┘\n");
		System.out.print("\t\t    login : ");
		login = sc.nextLine();
		System.out.print("\n\t\t    Mot de passe : ");
		pw = sc.nextLine();
	}
	
	public void newUser(){
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │     Nouveau Compte   │");
		System.out.println("\t\t  └──────────────────────┘\n");
		System.out.print("\t\t    login : ");
		login = sc.nextLine();
		System.out.print("\n\t\t    Mot de passe : ");
		pw = sc.nextLine();
	}
	
	
	public boolean check() {
		
		String query = "SELECT * FROM membres WHERE mem_nom=? AND mem_prenom=?";

		
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, nom);
			prepare.setString(2, prenom);
			
			ResultSet result = prepare.executeQuery();
				
			//───── Utilisateur identifié ─────────────────────────────────────────────────
				
			if(result.first())	{
				System.out.println("\n L'utilisateur est deja connue !\n");
				return false;
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean checkConnection(){
		
		String query ="SELECT com_login, com_id FROM comptes WHERE com_login = ?";
		String query2 ="SELECT com_login, com_id, com_pw FROM comptes WHERE com_login = ? AND com_pw = ?";
	
		try{
			//utilisation de PreparedStatement pour l'utilisation de trou dans les query on peut lire le resultat dans les 2 senses les changements ne seront
			//pas visible et les données seront que consultablent.
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, login);
			ResultSet result = prepare.executeQuery();
			
			if(result.first()){
				PreparedStatement prepare2 = LinkBdd.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepare2.setString(1, login);
				prepare2.setString(2, pw);
				
				ResultSet result2 = prepare2.executeQuery();
				
				//user identifie
				
				if(result2.first()){
					System.out.println("\nIdentification OK...\n");
					
					//On remplit nos attibuts
					int id = result2.getInt("com_id");
					
					if(result2.getString("com_login") != null){
						login = result2.getString("com_login");
					//	System.out.println(login);
						return true;	
					}	
							
				}				
			
				//Mot de passe non valide !
				else {
					System.out.println("\n      Attention le mot de passe est invalide !\n");
					return false;
				}
			}
			
			else {
				System.out.println("\n        Attention le login saisi n'existe pas !\n");
				return false;
			}
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean newCompte() {
		
		boolean	res = false;
		String query = "INSERT INTO comptes (com_login, com_pw, dro_id) VALUES (?,?,4) RETURNING com_id;";
				
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			prepare.setString(1, login);
			prepare.setString(2, pw);
			
			//Execution de la requete
			prepare.execute();
			
			//Si tout va bien on a id du compte
			ResultSet result = prepare.getResultSet();
			
			if(result.first()) {
				int id = result.getInt(1);
				res = true;
					System.out.println("\n        Votre compte vient d'etre créer !\n");
			}
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	
//───── Getter / Setter ──────────────────────────────────────────
				
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}					

}

