import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Etudiant extends Membres {

	//───── Attributs ────────────────────────────────────────────────
	
		protected String adresse;
		protected String cp;
		protected String ville;
		protected MaDate dateEntree;
		protected MaDate dateSortie;
		private int droits = 4;
		
	//───── Constructeurs ────────────────────────────────────────────

		public Etudiant(String nom, String prenom,String adresse, int cp, String ville, String tel, String login, String pw) {
		super(nom, prenom, tel, login, pw);
		this.droits = 4 ;
		this.actif = true;
		System.out.println("Un humain est né !");
		}
		
		public Etudiant(){
			newEtudiant();
		}
			
		
	//───── Methodes ─────────────────────────────────────────────────
		
		public boolean newEtudiant(){
			
			boolean	res = false;
			int com_id = 0;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("");
			System.out.println("\t\t┌───────────────────────────┐");
			System.out.println("\t\t│ Creation Compte  Etudiant │");
			System.out.println("\t\t└───────────────────────────┘\n");
		
			System.out.print("\t\t    Nom : ");
			nom = sc.nextLine();
			System.out.print("\n\t\t    Prenom : ");
			prenom = sc.nextLine();
			System.out.print("\n\t\t    adresse : ");
			adresse = sc.nextLine();
			System.out.print("\n\t\t    code postal : ");
			cp = sc.nextLine();
			System.out.print("\n\t\t    ville : ");
			ville = sc.nextLine();
			System.out.print("\n\t\t    Tel : ");
			tel = sc.nextLine();
			System.out.print("\n\t\t    login : ");
			login = sc.nextLine();
			System.out.print("\n\t\t    Mot de passe : ");
			pw = sc.nextLine();
		
			if(super.check()){
					
				String query = "INSERT INTO comptes (com_login, com_pw, dro_id) VALUES (?,?,4) RETURNING com_id;";
				
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
					String query2 = "INSERT INTO membres (mem_nom, mem_prenom, mem_adresse, mem_cp, mem_ville, mem_tel, com_id) VALUES (?,?,?,?,?,?,"+com_id+") RETURNING mem_id;";
					PreparedStatement prepare2 = LinkBdd.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					prepare2.setString(1, nom);
					prepare2.setString(2, prenom);
					prepare2.setString(3, adresse);
					prepare2.setString(4, cp);
					prepare2.setString(5, ville);
					prepare2.setString(6, tel);
					ResultSet result2 = prepare2.executeQuery();
					System.out.println("Un humain est né !");
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
					
		
		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getCp() {
			return cp;
		}

		public void setCp(String cp) {
			this.cp = cp;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}
		
		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public MaDate getDateEntree() {
			return dateEntree;
		}

		public void setDateEntree(MaDate dateEntree) {
			this.dateEntree = dateEntree;
		}

		public MaDate getDateSortie() {
			return dateSortie;
		}

		public void setDateSortie(MaDate dateSortie) {
			this.dateSortie = dateSortie;
		}

	
	}

