package Projekat4;

import java.util.ArrayList;

public class TestKlasa {

    public static void main(String[] args) {

        Player player = new Player(
                "  peTar   petroviC  ",
                10, 5,
                new RectangleCollider(10, 5, 32, 32),
                85
        );

        System.out.println("Player created: " + player);

        Game game = new Game(player);

        Enemy e1 = new MeleeEnemy(
                "Goblin",
                12, 5,
                new RectangleCollider(12, 5, 16, 16),
                20, 60
        );
        game.addEnemy(e1);

        Enemy e2 = Game.parseEnemy("Orc;20,10;20x20;15;boss");
        game.addEnemy(e2);

        System.out.println("\nEnemies colliding with player (na početku):");
        ArrayList<Enemy> colliding = (ArrayList<Enemy>) game.collidingWithPlayer();
        for (Enemy e : colliding) {
            System.out.println(" * " + e);
        }

        System.out.println("\nPretraga po tipu (\"gob\"):");
        ArrayList<Enemy> found = (ArrayList<Enemy>) game.findByType("gob");
        for (Enemy e : found) {
            System.out.println(" * " + e);
        }

        System.out.println("\nPlayer BEFORE collisions: " + player);
        game.resolveCollisions();
        System.out.println("Player AFTER collisions:  " + player);

        System.out.println("\nEvent log:");
        ArrayList<String> log = (ArrayList<String>) game.getEventLog();
        for (String s : log) {
            System.out.println(" - " + s);
        }
    }
}
