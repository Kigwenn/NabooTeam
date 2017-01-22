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
