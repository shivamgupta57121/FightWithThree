import java.util.Scanner;
import java.util.Random;

public class FightingWithThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();

		System.out.print("Your Attack Points : ");
		int yourAttack = generator.nextInt(30)+1;
		System.out.println(yourAttack);
		System.out.print("Your Defence Points : ");
		int yourDefence = generator.nextInt(40)+1;
		System.out.println(yourDefence);
		System.out.print("Your Damage : ");
		int yourDamage = generator.nextInt(20)+1;
		System.out.println(yourDamage);
		System.out.print("Your Life Points : ");
		int yourLife = 50;
		System.out.println(yourLife);
		
		for(int i=0;i<3;i++) {
			
			String monsterName;
			int num = generator.nextInt(5)+1;
			switch(num) {
				case 1: monsterName ="Black Daemon"; break;
				case 2: monsterName = "The Rabbit"; break;
				case 3: monsterName = "Silver Dragon"; break;
				case 4: monsterName = "Mountain Troll"; break;
				case 5: monsterName = "Alien"; break;
				default :monsterName = "N/A";
			}
		
			System.out.println();
			
			System.out.print("Attack Points of "+monsterName+" : ");
			int monsterAttack = generator.nextInt(60)+1;
			System.out.println(monsterAttack);
			System.out.print("Defence Points of "+monsterName+" : ");
			int monsterDefence = generator.nextInt(30)+1;
			System.out.println(monsterDefence);
			System.out.print("Damage of "+monsterName+" : ");
			int monsterDamage = generator.nextInt(20)+1;
			System.out.println(monsterDamage);
			System.out.print("Life Points of "+monsterName+" : ");
			int monsterLife = 50;
			System.out.println(monsterLife);
			System.out.println();
		
			Boolean runaway = false;
			
			//scan.nextLine();
			do {
				boolean attacker = generator.nextBoolean();
				if(attacker) {
					System.out.println("Your attack");
					int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
					int attackValue = yourAttack + dice;
					System.out.println("Rolled Value : "+dice);
					System.out.println("Your attack value : "+attackValue);
					if (attackValue > monsterDefence) {
						System.out.println("Your attack was successful. ");
						monsterLife = monsterLife - yourDamage;
						System.out.println(monsterName+"'s remaining Life : "+monsterLife);
					}
					else {
						System.out.println("Your attack was not successful. ");
					}
					
				}
				else {
					System.out.println(monsterName+" attacks. ");
					int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
					int attackValue = monsterAttack + dice;
					System.out.println("Rolled Value : "+dice);
					System.out.println(monsterName+"'s attack value : "+attackValue);
					if (attackValue > yourDefence) {
						System.out.println(monsterName+"'s attack was successful. ");
						yourLife = yourLife - monsterDamage;
						System.out.println("Your remaining Life : "+yourLife);
					}
					else {
						System.out.println(monsterName+"'s attack was not successful. ");
					}
				}
				
				System.out.println("Press Enter to continue. Or type in 'run' to run away.");
				String command = scan.nextLine();
				
				switch(command) {
					case "run" : 
						System.out.println("You ran away. you coward! -4 Life points. ");
						yourLife-=4;
						runaway = true;
						break;
					default : 
				}
				
			}while(yourLife>0 && monsterLife>0 && !runaway);
			
			if(yourLife <= 0) {
				System.out.println("You are dead. :-( ");
			    break;
			}
			else if(monsterLife <= 0)
				System.out.println("You won. The "+monsterName+" is dead. :-) ");
			
		}

	}

}