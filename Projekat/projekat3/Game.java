//Adelisa Palavrtić 22/019, Daris Velović 24/016
package projekat3;
import java.util.ArrayList;
public class Game {
	
	    private Player player;
	    private ArrayList<Enemy> enemies = new ArrayList<>();
	    private ArrayList<String> eventLog = new ArrayList<>();

	    public Game(Player player) {
	        this.player = player;
	    }

	    public void addEnemy(Enemy e) {
	        enemies.add(e);
	        eventLog.add("ADD: " + e.toString());
	    }

	    public boolean checkCollision(Player p, Enemy e) {
	        return p.intersects(e);
	    }

	    public void decreaseHealth(Player p, Enemy e) {
	        int dmg = e.getDamage();
	        if (e instanceof BossEnemy) dmg *= 2;

	        int oldHp = p.getHealth();
	        int newHp = Math.max(0, oldHp - dmg);
	        p.setHealth(newHp);

	        eventLog.add("HIT: Player by " + e.getTip() + " for " + dmg + " -> HP " + oldHp + " > " + newHp);
	    }

	    public ArrayList<Enemy> findByType(String query) {
	        ArrayList<Enemy> result = new ArrayList<>();
	        String q = query.toLowerCase();
	        for (Enemy e : enemies) {
	            if (e.getTip().toLowerCase().contains(q)) result.add(e);
	        }
	        return result;
	    }

	    public ArrayList<Enemy> collidingWithPlayer() {
	        ArrayList<Enemy> result = new ArrayList<>();
	        for (Enemy e : enemies) {
	            if (checkCollision(player, e)) result.add(e);
	        }
	        return result;
	    }

	    public void resolveCollisions() {
	        for (Enemy e : enemies) {
	            if (checkCollision(player, e)) decreaseHealth(player, e);
	        }
	    }

	    public void printEventLog() {
	        for (String log : eventLog) System.out.println(log);
	    }

	    public void printEnemies() {
	        for (Enemy e : enemies) System.out.println(e);
	    }

	    public Player getPlayer() { return player; }
	}


