package projekat5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();


    public Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() { return player; }
    public ArrayList<Enemy> getEnemies() { return enemies; }
    public ArrayList<String> getLog() { return log; }


    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Enemy added: " + e.getDisplayName());
    }


    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }


    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int before = p.getHealth();

        p.decreaseHealth(dmg);

        log.add("Player hit by " + e.getDisplayName() +
                " for " + dmg + " damage. HP: " + before + " -> " + p.getHealth());
    }


    public ArrayList<Enemy> findByType(String s) {
        ArrayList<Enemy> found = new ArrayList<>();

        for (Enemy e : enemies) {
            if (e.getDisplayName().toLowerCase().contains(s.toLowerCase())) {
                found.add(e);
            }
        }
        return found;
    }


    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> list = new ArrayList<>();

        for (Enemy e : enemies) {
            if (checkCollision(player, e))
                list.add(e);
        }
        return list;
    }


    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }


    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath) {
        ArrayList<Enemy> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // preskoči header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");


                String type = parts[0].trim();
                String cls = parts[1].trim();
                int dmg = Integer.parseInt(parts[2].trim());
                int hp = Integer.parseInt(parts[3].trim());
                int x = Integer.parseInt(parts[4].trim());
                int y = Integer.parseInt(parts[5].trim());
                String shape = parts[6].trim();

                Collidable collider;

                if (shape.equals("rectangle")) {
                    int w = Integer.parseInt(parts[7].trim());
                    int h = Integer.parseInt(parts[8].trim());
                    collider = new RectangleCollider(x, y, w, h);
                }
                else if (shape.equals("circle")) {
                    int r = Integer.parseInt(parts[9].trim());
                    collider = new CircleCollider(x, y, r);
                }
                else {
                    throw new IllegalArgumentException("Nepoznat shape: " + shape);
                }

                Enemy e = cls.equals("boss")
                        ? new BossEnemy(type, x, y, collider, dmg, hp)
                        : new MeleeEnemy(type, x, y, collider, dmg, hp);

                list.add(e);
            }

        } catch (Exception ex) {
            throw new IllegalArgumentException("Greška u CSV fajlu: " + ex.getMessage());
        }

        return list;
    }
}
