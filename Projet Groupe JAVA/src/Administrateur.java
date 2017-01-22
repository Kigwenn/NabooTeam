import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Administrateur extends Membres {
	
//───── Attributs ────────────────────────────────────────────────		

	private int droits = 1;
		
//───── Constructeurs ────────────────────────────────────────────
	
	public Administrateur( String nom, String prenom, String tel, String login, String pw) {
		super (nom, prenom, tel, login, pw);
		this.droits = 1 ;
		this.actif = true;
		System.out.println("Un dieu est né !");
		System.out.println("");
	}
		
	public Administrateur() {
		newAdministrateur();
	}

//───── Methodes ─────────────────────────────────────────────────

	public boolean newAdministrateur(){
	
		boolean	res = false;
		int com_id = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t  ┌──────────────────────┐");
		System.out.println("\t\t  │ Creation Compte  Adm │");
		System.out.println("\t\t  └──────────────────────┘\n");
	
		System.out.print("\t\t    Nom : ");
		nom = sc.nextLine();
		System.out.print("\n\t\t    Prenom : ");
		prenom = sc.nextLine();
		System.out.print("\n\t\t    Tel : ");
		tel = sc.nextLine();
		System.out.print("\n\t\t    login : ");
		login = sc.nextLine();
		System.out.print("\n\t\t    Mot de passe : ");
		pw = sc.nextLine();
	
		if(super.check()){
				
			String query = "INSERT INTO comptes (com_login, com_pw, dro_id) VALUES (?,?,"+droits+") RETURNING com_id;";
			try {
				PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepare.setString(1, login);
				prepare.setString(2, pw);
				prepare.execute();
				ResultSet result = prepare.getResultSet();
				
				if(result.first()) {
					com_id = result.getInt(1);
					//System.out.println(com_id);
					res = true;
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				String query2 = "INSERT INTO membres (mem_nom, mem_prenom, mem_tel,com_id) VALUES (?,?,?,"+com_id+") RETURNING mem_id;";
				PreparedStatement prepare2 = LinkBdd.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepare2.setString(1, nom);
				prepare2.setString(2, prenom);
				prepare2.setString(3, tel);
				ResultSet result2 = prepare2.executeQuery();
				System.out.println("Un dieu est né !");
				System.out.println("");
				res = true;
			}
				
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return res;
	}

//───── Getter / Setter ──────────────────────────────────────────
	
	public int getDroits() {
		return droits;
	}

	public void setDroits(int droits) {
		this.droits = droits;
	}
}	