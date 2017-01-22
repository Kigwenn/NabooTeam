import java.util.Scanner;

public class Menu extends Utilisateur {
	
//───── Attributs ────────────────────────────────────────────────
		
	private int com_id = 0;
	private int dro_id = 0;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public Menu(int com_id, int dro_id) {
		super(com_id, dro_id);
		this.com_id = com_id;
		this.dro_id = dro_id;
		menuFull();
	}
		
//───── Methodes ─────────────────────────────────────────────────	
	
	public void menuFull() {
		
		if(dro_id != 0){
			int choix;
			
			System.out.println("");
			System.out.println("           ┌────────────────────────────────────┐");
			System.out.println("           │        Projet Planning IMIE        │");
			System.out.println("           ├───                               ──┤");
			System.out.println("           │                MENU                │");
			System.out.println("           ├──────                        ──────┤");
			System.out.println("           │                                    │");			

			if (dro_id == 1){
				System.out.println("           │  1) - Compte                       │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  2) - Promo                        │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  3) - Cours                        │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  4) - Salles                       │");
				System.out.println("           │                                    │");
			}
			if (dro_id == 1){
				System.out.println("           │  5) - Matieres                     │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  6) - Creer un cours               │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  7) - Liste des cours              │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1||dro_id == 2 || dro_id == 3 || dro_id == 4){
				System.out.println("           │  8) - Planning                     │");
				System.out.println("           │                                    │");
			}
			
			System.out.println("           │  0) - retour                       │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");
	
			choix = menuEntrer(8, "\n                   Choisir une option : ");
			
			System.out.println("");
			
			switch(choix){
				
				case 1:
					MenuCompte obj11 = new MenuCompte(com_id,dro_id);
					obj11.menuFull();
					break;
							
				case 2: 
					MenuPromos obj12 = new MenuPromos(com_id,dro_id);
					obj12.menuFull();
					break;
					
				case 3: 
					MenuCours obj13 = new MenuCours(com_id,dro_id);
					obj13.menuFull();
					break;
										
				case 4: 
					MenuSalles obj14 = new MenuSalles(com_id,dro_id);
					obj14.menuFull();
					break;
					
				case 5: 
					MenuMatieres obj15 = new MenuMatieres(com_id,dro_id);
					obj15.menuFull();
					break;
				
				case 6: 
					Cours obj161 = new Cours();
					obj161.listeCours();
					Matieres obj162 = new Matieres();
					obj162.listeMatieres();
					MenuCompte obj163 = new MenuCompte(com_id,dro_id);
					obj163.listeUtilisateur();
					CoursEnseigner obj164 = new CoursEnseigner();
					obj164.createCours();
					obj164.listeCours();
					Menu obj16 = new Menu(com_id,dro_id);
					obj16.menuFull();
					break;
					
				case 7: 
					CoursEnseigner obj171 = new CoursEnseigner(com_id,dro_id);
					obj171.listeCours();
						break;
						
				case 8: 
					MenuPlanning obj181 = new MenuPlanning(com_id,dro_id);
					obj181.menuFull();
						break;
					
				case 0: 
					break;
			}	
		}	
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