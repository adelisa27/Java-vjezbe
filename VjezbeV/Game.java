package projekat2';

public class Game {

	
		
		import java.util.ArrayList;
		

			public static void main(String[] args) {
				ArrayList<Player> igraci = new ArrayList<>();
				Player player1 = new Player("player1",10,5,32,32,85);
				igraci.add(player1);
				
				ArrayList<Enemy> protivnik = new ArrayList<>();
				Enemy Goblin = new Enemy("Golbin",12,5,16,15,20);
				protivnik.add(Goblin);
				
				
				
				
				
				
				System.out.println(igraci.get(0));
				System.out.println(protivnik.get(0));
				
				
				
       
		 }
			
  

	


