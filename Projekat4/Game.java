package Projekat4;
import java.util.*;

public class Game {

	    private Player player;
	    private ArrayList<Enemy> enemies = new ArrayList<>();
	    private ArrayList<String> eventLog = new ArrayList<>();

	    public Game(Player p) {
	        this.player = p;
	    }

	    public void addEnemy(Enemy e) {
	        if (e == null)
	            throw new IllegalArgumentException("Enemy null");
	        enemies.add(e);
	        eventLog.add("Added enemy: " + e.getDisplayName());
	    }

	    public boolean checkCollision(Player p, Enemy e) {
	        return p.intersects(e);
	    }

	    public void decreaseHealth(Player p, Enemy e) {
	        if (p == null || e == null)
	            throw new IllegalArgumentException("Null refs");

	        int before = p.getHealth();
	        p.decrease(e.getEffectiveDamage());
	        int after = p.getHealth();

	        eventLog.add("HIT: " + p.getDisplayName() + " by " + e.getDisplayName() +
	                     " for " + e.getEffectiveDamage() +
	                     " - HP " + before + " -> " + after);
	    }

	    public List<Enemy> collidingWithPlayer() {
	        ArrayList<Enemy> list = new ArrayList<>();
	        for (Enemy e : enemies)
	            if (checkCollision(player, e))
	                list.add(e);
	        return list;
	    }

	    public void resolveCollisions() {
	        for (Enemy e : enemies)
	            if (checkCollision(player, e))
	                decreaseHealth(player, e);
	    }

	    public static Enemy parseEnemy(String line) {
	        try {
	            String[] p = line.split(";");
	            String type = p[0];
	            String[] pos = p[1].split(",");
	            int x = Integer.parseInt(pos[0]);
	            int y = Integer.parseInt(pos[1]);

	            String[] size = p[2].split("x");
	            int w = Integer.parseInt(size[0]);
	            int h = Integer.parseInt(size[1]);

	            int dmg = Integer.parseInt(p[3]);
	            boolean boss = p[4].equalsIgnoreCase("boss");

	            Collidable col = new RectangleCollider(x, y, w, h);

	            if (boss)
	                return new BossEnemy(type, x, y, col, dmg, 100);

	            return new MeleeEnemy(type, x, y, col, dmg, 60);
	        }
	        catch (Exception e) {
	            throw new IllegalArgumentException("Invalid enemy format: " + line);
	        }
	    }

	    public List<String> getEventLog() { return eventLog; }

		public Object findByType(String string) {
			return null;
		}

		public List<Enemy> getEnemies() {
			return null;
		}
	}


