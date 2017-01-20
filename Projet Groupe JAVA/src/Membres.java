import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class Membres {

//───── Attributs ────────────────────────────────────────────────
		
	protected int idMembres;
	protected String nom;
	protected String prenom;
	protected String tel;
	protected boolean actif;
	protected String login ;
	protected String pw ;	
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Membres(){
	}
	
	public Membres(String nom, String prenom, String tel, String login, String pw) {
	this.actif = true;
	}
	
//───── Methodes ─────────────────────────────────────────────────
	
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
	
public boolean checkId() {
		
		String query = "SELECT * FROM membres WHERE mem_id=?";
		
		int id = 0;
		
		try {
			PreparedStatement prepare = LinkBdd.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setInt(1, id);
						
			ResultSet result = prepare.executeQuery();
				
			//───── Utilisateur identifié ─────────────────────────────────────────────────
				
			if(result.first())	{
				System.out.println("\n l'id est n'existe pas !\n");
				return false;
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

//───── Getter / Setter ──────────────────────────────────────────
				
	public int getidMembres() {
		return idMembres;
	}

	public void setidMembres(int idMembres) {
		this.idMembres = idMembres ;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public boolean isactif() {
		return actif;
	}

	public void setactif(boolean actvif) {
		actvif = actif;
	}

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

