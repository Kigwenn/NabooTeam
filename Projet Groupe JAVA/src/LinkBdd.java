import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class LinkBdd {

	private static Connection connect;
	public static final String URL_BDD = "jdbc:postgresql://localhost:5432/imie";
	private static String user_bdd = "admin";
	private static String pwd_bdd = "admin";
	private static boolean status = false;
	
	public static Connection getInstance(){
		
		if(connect == null){
			
			try {
//				Console cons = System.console();
//				Scanner sc = new Scanner(System.in);
				if(user_bdd.isEmpty()){
					System.out.print("Login PostgresQL : ");
//					user_bdd = sc.nextLine();					
				}
				
				if(pwd_bdd.isEmpty()){
					System.out.print("Password PostgresQL : ");
									
					//ATTENTION l'instruction ci-dessous ne fonctionne pas sous eclipse, seulement dans une vraie console
					//pwd_bdd = new String(cons.readPassword());
					//permet de saisir un mot de passe qui n'apparait pas en console
//					pwd_bdd = sc.nextLine();
				}
				
				connect = DriverManager.getConnection(URL_BDD, user_bdd, pwd_bdd);
				//System.out.println(connect);
				System.out.println("\nConnexion à la BDD... OK");
				
			} 
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return connect;
	}
}
	
	
/*	
public class Connect {
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
   
		    String url = "jdbc:postgresql://localhost:5432/mastermind";
		    String user = "kigwenn";
		    String passwd = "1234";

		    Connection conn = DriverManager.getConnection(url, user, passwd);
		    System.out.println("Connexion effective !\n");

	*/	    
//======================  Creation compte utilisateur ==============================
/*		    Statement state = conn.createStatement();
		    		    
		    String query = "INSERT INTO compte (login,pw) VALUES ('gest','gest')";
		    
		    state.executeUpdate(query);
		    
		    System.out.println("Votre compte a bien ete creer");
		    
		    state.close();
		    
	*/	    
		    
//======================  historiques  =============================================
/*
		    Statement state = conn.createStatement();
  		    
		    String query = "SELECT compte.login, partie.id_partie, sol_val1, sol_val2, sol_val3, sol_val4  FROM partie";
		    query +=" INNER JOIN solution ON solution.id_solution = partie.id_solution";
		    query +=" INNER JOIN compte ON compte.id_compte= partie.id_compte";
		    query +=" limit 5";
		    int i=0;
		    ResultSet result = state.executeQuery(query);
		    System.out.println("         ┌───────────┬────────────┬────────┐" );
		    System.out.println("         │ Solutions │ nb / coups │ Gagner │" );
		    System.out.println("┌────────┼───────────┼────────────┼────────┤" );
		    while(result.next()){
			    i+=1;
			    System.out.print("│ "+i+"\t │  "+result.getString("sol_val1"));	
			    System.out.print(" "+result.getString("sol_val2")+" "+result.getString("sol_val3"));
			    System.out.println(" "+result.getString("sol_val4")+"  │");
		    }
		    System.out.println("└────────┴───────────┴────────────┴────────┘" );
	   		result.close();
		    state.close();
	*/	    
//======================  Creation partie  =============================================
/*
		    Statement state = conn.createStatement();
  		    
		    String query = "SELECT compte.login, partie.id_partie, sol_val1, sol_val2, sol_val3, sol_val4  FROM partie";
		    query +=" INNER JOIN solution ON solution.id_solution = partie.id_solution";
		    query +=" INNER JOIN compte ON compte.id_compte= partie.id_compte";
		    query +=" limit 5";
		    int i=0;
		    ResultSet result = state.executeQuery(query);
		    System.out.println("         ┌───────────┬────────────┬────────┐" );
		    System.out.println("         │ Solutions │ nb / coups │ Gagner │" );
		    System.out.println("┌────────┼───────────┼────────────┼────────┤" );
		    while(result.next()){
			    i+=1;
			    System.out.print("│ "+i+"\t │  "+result.getString("sol_val1"));	
			    System.out.print(" "+result.getString("sol_val2")+" "+result.getString("sol_val3"));
			    System.out.println(" "+result.getString("sol_val4")+"  │");
		    }
		    System.out.println("└────────┴───────────┴────────────┴────────┘" );
	   		result.close();
		    state.close();
		    
		}
		catch (Exception e) {
			e.printStackTrace();
		}      
	}
}*/
