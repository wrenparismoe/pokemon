
public class Pokemon {
	String name;
	int health;
	Move[] moves;
	String type;
	int speed;
	
	public Pokemon(){
		
	}
	public Pokemon(String name, int health,	Move[] moves, String type, int speed){
		this.name = name;
		this.health = health;
		this.moves = moves;
		this.type = type;
		this.speed = speed;
	}
	public void doDamage(Move x, Pokemon y){
		if(x.cHealth < 0){
			this.health -= x.cHealth;
		} else{
			y.health -= x.cHealth;
		}	
	}
	public void changeSpeed(Move x, Pokemon y){
		if(x.cSpeed < 0){
			this.speed -= x.cSpeed;
		} else{
			y.speed -= x.cSpeed;
		}
	}
	public void weaknessStrength(Pokemon x){
		if(this.type.equals("fire") && x.type.equals("water")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("water") && x.type.equals("electric")){
			for(int i = 0; i < x.moves.length; i++){
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("water") && x.type.equals("water")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("electric") && x.type.equals("electric")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("fire") && x.type.equals("fire")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("ghost") && x.type.equals("ghost")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("psychic") && x.type.equals("psychic")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth /= 2;
			}
		}	
	}
	public void undoWeaknessStrength(Pokemon x){
		// int moveNumber is a user input for which move to use
		if(this.type.equals("fire") && x.type.equals("water")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("water") && x.type.equals("electric")){
			for(int i = 0; i < x.moves.length; i++){
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("water") && x.type.equals("water")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("electric") && x.type.equals("electric")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("fire") && x.type.equals("fire")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth *= 2;
			}
		}
		if(this.type.equals("ghost") && x.type.equals("ghost")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth /= 2;
				x.moves[i].cHealth /= 2;
			}
		}
		if(this.type.equals("psychic") && x.type.equals("psychic")){
			for(int i = 0; i < this.moves.length; i++){
				this.moves[i].cHealth *= 2;
				x.moves[i].cHealth *= 2;
			}
		}	
	}		
}
