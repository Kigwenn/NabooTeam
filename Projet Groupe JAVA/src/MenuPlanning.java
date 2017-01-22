import java.util.Scanner;

public class MenuPlanning extends Reserver {
	
//───── Attributs ────────────────────────────────────────────────
		
	private int com_id = 0;
	private int dro_id = 0;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public MenuPlanning(int com_id, int dro_id) {
		super(com_id, dro_id);
		this.com_id = com_id;
		this.dro_id = dro_id;
	}
	
	public MenuPlanning() {
	}
		
//───── Methodes ─────────────────────────────────────────────────	
	
	public void menuFull() {
		
		if(dro_id == 1){
			int choix;
			
			System.out.println("");
			System.out.println("           ┌────────────────────────────────────┐");
			System.out.println("           │        Projet Planning IMIE        │");
			System.out.println("           ├───                               ──┤");
			System.out.println("           │              MENU PLANNING         │");
			System.out.println("           ├──────                        ──────┤");
			System.out.println("           │                                    │");			

			if (dro_id == 1){
				System.out.println("           │  1) - Planning                     │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  2) - Creer une Reservation        │");
				System.out.println("           │                                    │");
			}
			
			if (dro_id == 1){
				System.out.println("           │  3) - Supprimer une Reservation    │");
				System.out.println("           │                                    │");
			}
			
			System.out.println("           │  0) - retour                       │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");
	
			choix = menuEntrer(3, "\n                   Choisir une option : ");
			
			System.out.println("");
			
			switch(choix){
				
				case 1:
					super.listeReservations();
					menuFull();
					break;

				case 2:
					Promos obj162 = new Promos();
					obj162.listePromos();
					Cours obj161 = new Cours();
					obj161.listeCours();
					Salles obj163 = new Salles(com_id,dro_id);
					obj163.listeSalles();
					super.createReservations();
					Menu obj = new Menu(com_id,dro_id);
					break;
							
				case 3: 
					super.listeReservations();
					super.supprReservations();
					menuFull();
					break;
										
				case 0: 
					Menu obj1 = new Menu(com_id,dro_id);
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
		
	while(!choixValide); //tant que le choix n'est pas valide ou qu'il n'a pas demander a quitter
	return choix;
	}
}