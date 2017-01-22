import java.util.Scanner;

public class MenuPromos extends Promos {
	
//───── Attributs ────────────────────────────────────────────────
		
	private int com_id = 0;
	private int dro_id = 0;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public MenuPromos(int com_id, int dro_id) {
		super(com_id, dro_id);
			this.com_id = com_id;
			this.dro_id = dro_id;
		//	menuFull();
	}
	
	public MenuPromos() {
	}
		
//───── Methodes ─────────────────────────────────────────────────	
	
	public void menuFull() {

		if(dro_id == 1){
			int choix;
			
			System.out.println("");
			System.out.println("           ┌────────────────────────────────────┐");
			System.out.println("           │        Projet Planning IMIE        │");
			System.out.println("           ├───                               ──┤");
			System.out.println("           │            MENU Promos             │");
			System.out.println("           ├──────                        ──────┤");
			System.out.println("           │                                    │");			

			if (dro_id == 1){
				System.out.println("           │  1) - Liste des promos             │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  2) - Créer une promo              │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  3) - Supprimer une promo          │");
				System.out.println("           │                                    │");
			}
			
			System.out.println("           │  0) - retour                       │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");
	
			choix = menuEntrer(3, "\n                   Choisir une option : ");
			
			System.out.println("");
			
			switch(choix){
				
				case 1:
					super.listePromos();
					menuFull();
					break;

				case 2:
					
					super.createPromo();
					menuFull();
					break;
							
				case 3: 
					super.listePromos();
					super.supprPromos();
					menuFull();
					break;
										
				case 0: 
					Menu obj = new Menu(com_id,dro_id);
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