package projekat5;

public class Player extends GameObject {

    private String name;
    private int health;

    public Player(String name, int x, int y, Collidable col, int health) {
        super(x, y, col);

        name = name.trim();
        if (name.isEmpty()) throw new IllegalArgumentException("Ime ne može biti prazno!");

        this.name = name.substring(0,1).toUpperCase() + name.substring(1);

        if (health < 0 || health > 100)
            throw new IllegalArgumentException("Health mora biti 0-100!");

        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    @Override
    public String getDisplayName() {
        return name;
    }
}
