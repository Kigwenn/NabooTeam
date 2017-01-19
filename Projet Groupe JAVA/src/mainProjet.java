import java.util.Scanner;

public class mainProjet {

	public static void main(String[] args) {
		
		if(LinkBdd.getInstance() != null){
			menuPrincipal();
		}	
		else{
			System.out.println("La connexion à la BDD a échoué ! Aurevoir !");
		}
	}
			
	public static void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		int choix;
		do {	

			System.out.println("");
			System.out.println("           ┌────────────────────────────────────┐");
			System.out.println("           │        Projet Planning IMIE        │");
			System.out.println("           ├───                               ──┤");
			System.out.println("           │            MENU PRINCIPAL          │");
			System.out.println("           ├──────                        ──────┤");
			System.out.println("           │                                    │");			
			System.out.println("           │  1 - Connexion                     │");
			System.out.println("           │                                    │");
			System.out.println("           │  2 - Création d'un new compte Adm  │");
			System.out.println("           │                                    │");
			System.out.println("           │  3 - Création d'un new compte Res  │");
			System.out.println("           │                                    │");
			System.out.println("           │  4 - Création d'un new compte Etu  │");
			System.out.println("           │                                    │");
			System.out.println("           │  5 - Création d'un new compte For  │");
			System.out.println("           │                                    │");
			System.out.println("           │  6 - Modifi d'un new compte Adm    │");
			System.out.println("           │                                    │");
			System.out.println("           │  7 - Création d'une promos         │");
			System.out.println("           │                                    │");
			System.out.println("           │  8 - Création d'un cours           │");
			System.out.println("           │                                    │");
			System.out.println("           │  9 - Effacer un cours              │");
			System.out.println("           │                                    │");
			System.out.println("           │  0 - Quitter                       │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");

			choix = menuEntrer(10, "\n                   Choisir une option : ");
			System.out.println("");
			
			switch(choix){
					
				case 1:
					Utilisateur bob = new Utilisateur();
					break;
							
				case 2:
					Administrateur adm = new Administrateur();
					break;
							
				case 3: 
					Responsable res = new Responsable();
					break;
						
				case 4:
					Etudiant etu = new Etudiant();
					break;
							
				case 5:
					//Formateur Etu = new Formateur();
					break;
					
				case 6:
					//Administrateur adm = new ();
					break;
							
				case 7: 
					Promos promo = new Promos();
					break;
						
				case 8:
					Cours test = new Cours();
					break;
							
				case 9:
					test.delCours();	
					break;
					
				case 0:
					break;


			}
		}				
				
		while(choix != 4);
				
		System.out.println("Bye bye !");
	}
		

	public static int menuEntrer(int n, String message){
		
		Scanner sc = new Scanner(System.in);
		int choix;
		boolean choixValide;
		choixValide = false;
			
		do{
			System.out.print(message);
			choix = sc.nextInt();
					
			if(choix >= 1 && choix <=n){
				choixValide = true;
			}
				
			else {
				System.out.print("Attention, vous devez saisir un entier entre 1 et " + n + ".");
			}
		}
		while(!choixValide); //tant que le choix n'est pas valide ou qu'il n'a pas demander a quitter
	
		return choix;
	
	}
	
}
