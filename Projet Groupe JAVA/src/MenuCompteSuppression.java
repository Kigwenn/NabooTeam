import java.util.Scanner;


public class MenuCompteSuppression extends Utilisateur {
	
//───── Attributs ────────────────────────────────────────────────
		
	private int com_id = 0;
	private int dro_id = 0;
	
//───── Constructeurs ────────────────────────────────────────────
	
	public MenuCompteSuppression(int com_id, int dro_id) {
		super(com_id, dro_id);
			this.com_id = com_id;
			this.dro_id = dro_id;
			menuFull();
		}
		
//───── Methodes ─────────────────────────────────────────────────	
	

	public void menuFull() {
		
		if(dro_id == 1){
			int choix;
			
			System.out.println("");
			System.out.println("           ┌────────────────────────────────────┐");
			System.out.println("           │        Projet Planning IMIE        │");
			System.out.println("           ├───                               ──┤");
			System.out.println("           │      MENU  Creation de compte      │");
			System.out.println("           ├──────                        ──────┤");
			System.out.println("           │                                    │");			

			if (dro_id == 1){
				System.out.println("       	   │ 1) - Supprimer un compte           │");
				System.out.println("           │                                    │");
			}
		
			
			System.out.println("           │ 0) - retour                        │");
			System.out.println("           │                                    │");			
			System.out.println("           └────────────────────────────────────┘");
	
			choix = menuEntrer(1, "\n                   Choisir une option : ");
			
			System.out.println("");
			
			switch(choix){
				
				case 1:
					super.listeUtilisateur();
					super.supprUtilisateur();
					
					MenuCompte obj1 = new MenuCompte(com_id,dro_id);
					obj1.menuFull();
					break;
												
				case 0: 
					MenuCompte obj = new MenuCompte(com_id,dro_id);
					obj.menuFull();
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