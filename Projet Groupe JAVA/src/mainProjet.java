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
			System.out.println("           │  1) - Connection                   │");
			System.out.println("           │                                    │");
			System.out.println("           │  0) - Quitter                      │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");

			choix = menuEntrer(3, "\n                   Choisir une option : ");
			System.out.println("");
			
			switch(choix){
					
				case 1:

					System.out.println("\t\t  ┌──────────────────────┐");
					System.out.println("\t\t  │      Connection      │");
					System.out.println("\t\t  └──────────────────────┘\n");
					Utilisateur obj1 = new Utilisateur();
					break;
							
				case 0: 
					break;			
			} 
		}				
				
		while(choix != 0);
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
			if(choix >= 0 && choix <=n){
				choixValide = true;
			}
			else {
				System.out.print("Attention, vous devez saisir un entier entre 1 et " + n + ".");
			}
		}
		while(!choixValide);
	
		return choix;
	}
}
