
public class Move {
	String name;
	String type;
	int pp;
	int cHealth;
	int cSpeed;
	public Move(){
		
	}
	public Move(String name, String type, int pp, int cHealth, int cSpeed){
		this.name = name;
		this.type = type;
		this.pp = pp;
		this.cHealth = cHealth;
		this.cSpeed = cSpeed;
	}
	
	public void changePP(){
		this.pp -= 1;
	}
}
