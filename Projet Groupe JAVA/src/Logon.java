
public abstract class Logon {

//───── Attributs ────────────────────────────────────────────────
	
	protected int com_id;
	protected String comp_login;

//───── Constructeurs ────────────────────────────────────────────	
		
	public Logon(){ 
	}

//───── Getter / Setter ──────────────────────────────────────────
	
		public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public String getComp_login() {
		return comp_login;
	}

	public void setComp_login(String comp_login) {
		this.comp_login = comp_login;
	}
}