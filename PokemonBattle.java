import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class PokemonBattle {

	public static void main(String[] args) {
		// String name, String type, int pp, int cHealth, int cSpeed
		// a negative cHealth means it heals the pokemon
		Move m1 = new Move("ember", "fire", 4, 20, 0);
		Move m2 = new Move("scratch", "normal", 5, 20, 0);
		Move m3 = new Move("flamethrower", "fire", 3, 40, 0);
		Move m4 = new Move("intimidate", "psychic", 5, 0, 20);
		Move m5 = new Move("tackle", "normal", 5, 20, 0);
		Move m6 = new Move("water gun", "water", 4, 20, 0);
		Move m7 = new Move("growth", "grass", 5, -20, 0);
		Move m8 = new Move("water pulse", "water", 3, 30, 0);
		Move m9 = new Move("psybeam", "psychic", 3, 30, 0);
		Move m10 = new Move("psychic", "psychic", 3, 40, 0);
		Move m11 = new Move("shadow ball", "ghost", 3, 40, 0);
		Move m12 = new Move("shadow punch","ghost", 3, 30, 0);
		Move m13 = new Move("taunt", "normal", 5, 0, 20);
		Move m14 = new Move("thunder", "electric", 3, 100, 0);
		Move m15 = new Move("thunder shock", "electric", 5, 20, 0);
		Move m16 = new Move("psyshock", "psychic", 3, 40, 0);
		
		Move[] set1 = {m1, m2, m3, m4};
		Move[] set2 = {m5, m6, m7, m8};
		Move[] set3 = {m9, m10, m15, m5};
		Move[] set4 = {m11, m12, m9, m13};
		Move[] set5 = {m14, m15, m13, m10};
		Move[] set6 = {m9, m10, m16, m12};
		
		// String name, int health,	Move[] moves, String type, int speed
		Pokemon p1 = new Pokemon("Charmander", 80, set1, "fire", 100);
		Pokemon p2 = new Pokemon("Squirtle", 80, set2, "water", 100);
		Pokemon p3 = new Pokemon("Kadabra", 120, set3, "psychic", 100);
		Pokemon p4 = new Pokemon("Haunter", 120, set4, "ghost", 100);
		Pokemon p5 = new Pokemon("Zapdos", 150, set5, "electric", 100);
		Pokemon p6 = new Pokemon("Mew", 120, set6, "psychic", 100);
		
		Pokemon[] pset1 = new Pokemon[3];
		Pokemon[] pset2 = new Pokemon[3];
		ArrayList<Pokemon> availablePoke = new ArrayList<>();
		availablePoke.add(p1);
		availablePoke.add(p2);
		availablePoke.add(p3);
		availablePoke.add(p4);
		availablePoke.add(p5);
		availablePoke.add(p6);

		System.out.println("Welcome to the incredible pokemon battle. May the best trainer survive!");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Player 1 what is your name?");
		String name1 = input.nextLine();
		
		String chosenPoke;
		System.out.println(name1 + " assemble your pokemon (make sure to type name correctly)");
		for(int i = 0; i < 3; i++){
			System.out.print("Choose a Pokemon: ");
			for(int j = 0; j < availablePoke.size(); j++){
				System.out.print(availablePoke.get(j).name + " ");
			}
			chosenPoke = input.nextLine();
			for(int j = 0; j < availablePoke.size(); j++){
				if(availablePoke.get(j).name.toLowerCase().equals(chosenPoke.toLowerCase())){
					pset1[i] = availablePoke.get(j);
				}
			}	
		}
		System.out.println("Player 2 what is your name?");
		String name2 = input.nextLine();
		
		System.out.println(name2 + " assemble your pokemon");
		for(int i = 0; i < 3; i++){
			System.out.print("Choose a Pokemon: ");
			for(int j = 0; j < availablePoke.size(); j++){
				System.out.print(availablePoke.get(j).name + " ");
			}
			chosenPoke = input.nextLine();
			for(int j = 0; j < availablePoke.size(); j++){
				if(availablePoke.get(j).name.toLowerCase().equals(chosenPoke.toLowerCase())){
					pset2[i] = availablePoke.get(j);
				}
			}	
		}
		
		Player pl1 = new Player(name1, pset1);
		Player pl2 = new Player(name2, pset2);
		
		boolean a = true;
		Pokemon active1 = null;
		Pokemon active2 = null;
		int counter1 = 0;
		int counter2 = 0;
		while (a == true){
			// // String name, int health,	Move[] moves, String type, int speed
			if(active1 == null){
				System.out.println(pl1.name + ": Which pokemon would you like to use?");
				String active = input.next();
				boolean exists = false;
				int count = 0;
				while(exists == false){	
					count++;
					if(pl1.pokemon[count - 1].name.toLowerCase().equals(active.toLowerCase()) && count < 3){
						active1 = new Pokemon(pl1.pokemon[count - 1].name, pl1.pokemon[count - 1].health, pl1.pokemon[count - 1].moves, pl1.pokemon[count - 1].type, pl1.pokemon[count - 1].speed);
						exists = true;
					} else if (count == 3){
						System.out.println("Input incorrect. Retry");
						active = input.next();
						count = 0;
					}
				}
			}
			if(active2 == null){
				System.out.println(pl2.name + ": Which pokemon would you like to use?");
				String active = input.next();
				boolean exists = false;
				int count = 0;
				while(exists == false){	
					count++;
					if(pl2.pokemon[count - 1].name.toLowerCase().equals(active.toLowerCase()) && count < 3){
						active1 = new Pokemon(pl2.pokemon[count - 1].name, pl2.pokemon[count - 1].health, pl2.pokemon[count - 1].moves, pl2.pokemon[count - 1].type, pl2.pokemon[count - 1].speed);
						exists = true;
					} else if (count == 3){
						System.out.println("Input incorrect. Retry");
						active = input.next();
						count = 0;
					}
				}
			}
			active1.weaknessStrength(active2);
			if(active1.speed >= active2.speed){
				turn(active1, active2, pl1);
				turn(active2, active1, pl2);
			}else{
				turn(active2, active1, pl2);
				turn(active1, active2, pl1);
			}
			active1.undoWeaknessStrength(active2);
			
			if(active1.health <= 0){
				active1 = null;
				counter1 += 1;
				System.out.println(pl1.name + "'s pokemon is dead");
			} else{
				System.out.println(active1.name + "'s health is " + active1.health);
			}
			if(active2.health <= 0){
				active2 = null;
				counter2 += 1;
				System.out.println(pl2.name + "'s pokemon is dead");
			} else{
				System.out.println(active2.name + "'s health is " + active2.health);
			}
			if(counter1 != 3 && counter2 != 3){
				System.out.println("Would either player like to change pokemon? yes or no");
				String answer = input.next();
				if(answer.toLowerCase().equals("yes")){
					System.out.println("Which player wants to change pokemon? 1, 2 or both");
					String answer2 = input.next();
					if(answer.equals("1")){
						active1 = null;
					} else if(answer2.equals("2")){
						active2 = null;
					} else if(answer2.toLowerCase().equals("both")){
						active1 = null;
						active2 = null;
					}
				}
			}
			if(counter1 == 3){
				System.out.println(pl2.name + " has defeated all of " + pl1.name + "'s pokemon");
				break;
			}
			if(counter2 == 3){
				System.out.println(pl1.name + " has defeated all of " + pl2.name + "'s pokemon");
				break;
			}
			
		}
		if(counter1 == 3){
			System.out.println("Congrats " + pl2.name);
		} else{
			System.out.println("Congrats " + pl1.name);
		}


		
		

	}
	// create method and do method within turn method to do weaknesses/strengths
	public static void turn(Pokemon a, Pokemon d, Player p){
		Scanner input = new Scanner(System.in);
		Move active = null;
		boolean x = true;
		while (x == true){
			System.out.print(p.name + " choose a move: ");
			for(int j = 0; j < a.moves.length; j++){
				System.out.print(a.moves[j].name + " ");
			}
			String move = input.nextLine();
			for(int i = 0; i < a.moves.length; i++){
				if(a.moves[i].name.toLowerCase().equals(move.toLowerCase())){
					active = a.moves[i];
					if(active.pp == 0){
						System.out.println("pp for this move is zero, pick again");
					} else{
						x = false;
					}
					
				}
			}
		}
		
		a.doDamage(active, d);
		a.changeSpeed(active, d);
		active.changePP();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
