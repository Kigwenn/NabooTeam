import java.util.Calendar;

public class MaDate {
	public static int nb1=0 ;
//==== Atributs =================================================	

	private int jour;
	private int semaine;
	private int mois;
	private int an;
	private int n; 

//==== Constructeurs ============================================
	
	public MaDate(int j, int m, int a) {
		jour = j;
		mois = m;
		an = a;
	}

	public MaDate() {
		Calendar cal = Calendar.getInstance();
		
		jour = cal.get(Calendar.DAY_OF_MONTH);
		semaine = cal.get(Calendar.DAY_OF_WEEK);
		mois = cal.get(Calendar.MONTH)+1;
		an = cal.get(Calendar.YEAR);
	}
	
//==== Methodes =================================================		
	
	public boolean egale(MaDate autre){
		boolean egale = false ;
	
		if(an == autre.getAn() && mois == autre.getMois() && jour == autre.getJour()){
			egale = true;
			System.out.println("est true\n");
		}
		
		return egale;
	}
	
	public int compare(MaDate autre){
		int res = 0;
		
		if(this.an < autre.getAn()){
			res=1;
		}
		else if (this.mois < autre.getMois()){
			res=1;
		}
		else if (this.jour < autre.getJour()){
			res=1;
		}
		
		if(this.an > autre.getAn()){
			res=-1;
		}
		else if (this.mois > autre.getMois()){
			res=-1;
		}
		else if (this.jour > autre.getJour()){
			res=-1;
		}
		return res;
	}
	
	public void interpreter(int res)
	{
		if(res == -1){
			System.out.println("la date comparé est avant la date 1");
		}
		
		if(res == 1){
			System.out.println("la date comparé est apres a la date 1");
		}
	
		if(res == 0){
			System.out.println("la date comparé sont les mêmes");
		}	
	}
	
	public void interpreter(MaDate res)
	{
			System.out.println("la date comparé est avant la date 1");
	}
	
	public MaDate plusPetite(MaDate autre){
		
		int c = this.compare(autre);
		if(c == -1){
			return autre;
		}	
		return this;
	}
	
	public int avant(MaDate autre)
	{
		int  avant;
		avant = -2;

		if ( an < autre.getAn())
		{
		}
		else if ( an > autre.getAn())
		{
			avant = 3;
		}
		else if ( an == autre.getAn())
		{
			if ( mois < autre.getMois())
			{
			}
			else if ( mois > autre.getMois())
			{
				avant = 3;
			}
			else if ( mois == autre.getMois())
			{
				if ( jour < autre.getJour())
				{
				}
				else if ( jour > autre.getJour())
				{
					avant = 3;
				}
				else if (jour == autre.getJour())
				{
					avant = 0;
				}
			}					
		}	
		
		return avant;
	}
	
//==== Methodes traitement de l'affichage =========================	

	
	public void afficherDate(){
		System.out.println(toString());
	}
	
	public void afficherLettre(){
		System.out.println("Ma date "+ dateEnLettres() +"\n");
	}
	
	
	public String toString(){
		String d = jour + "/" + mois + "/" + an ;
		return d;
	}
	
	public void afficherEgale(MaDate autre)	{
		
		if (egale(autre)){
			System.out.println("dates égales");
		}
		else{
			System.out.println("dates non égales");
		}
	}
	
	public void afficherCompare(int res, MaDate d1, MaDate d2){
		if(res == 3){
			System.out.println(d1 + " est supérieure à " + d2);
		}
		else if(res == -2 ){
			System.out.println(d2 + " est supérieure à " + d1);
		}
		else{
			System.out.println(d1 + " est la même que " + d2);
		}
	}
	
	public String dateEnLettres(){
		String js ;
		String jm ;
		
		switch(this.semaine){
			case  0:
				js = "Lundi";
				break;
			case 1:
				js = "Mardi";
			break;
			case 2:
				js = "Mercredi";
			break;
			case 3:
				js = "Jeudi";
			break;
			case 4:
				js = "Vendredi";
			break;
			case 5:
				js = "Samedi";
			break;
			case 6:
				js = "Dimanche";
			break;
			default:
				js = "Big probleme!";
		}
		
		switch(this.mois){
			case 1:
				jm = "Janvier";
				break;
			case 2:
				jm = "Fevrier";
			break;
			case 3:
				jm = "Mars";
			break;
			case 4:
				jm = "Avril";
			break;
			case 5:
				jm = "Mai";
			break;
			case 6:
				jm = "Juin";
			break;
			case 7:
				jm = "Juillet";
			break;
			case 8:
				jm = "Aout";
			break;
			case 9:
				jm = "Septembre";
			break;
			case 10:
				jm = "Octobre";
			break;
			case 11:
				jm = "Novembre";
			break;
			case 12:
				jm = "Decembre";
			break;
			default:
				jm = "Big probleme!";
		}
		
		String d = js +" "+ jour + " " + jm + " "+ an;  
		return d ;
	}
	

//==== Get / Set ==================================================
	
//==== Get / Set =================================================
	
	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		if(jour > 0 && jour <= 31) {
		       this.jour = jour;
		   } else {
		        throw new IllegalArgumentException("Les mois comprennent au maximum 31 jours. Vous avez tapé :" + jour);}
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		if(mois> 0 && mois <= 12) {
			this.mois = mois;
		}
		else {
			throw new IllegalArgumentException("Les mois vont de 1 à 12. Vous avez tapé :" + mois);
		}
	}

	public int getAn() {
		return an;
	}

	public void setAn(int an) {
		this.an = an;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
