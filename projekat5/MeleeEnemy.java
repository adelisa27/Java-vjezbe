package projekat5;

public class MeleeEnemy extends Enemy {

    public MeleeEnemy(String type, int x, int y, Collidable col, int damage, int health) {
        super(type, x, y, col, damage, health);
    }

    @Override
    public String toString() {
        return "MeleeEnemy: " + super.toString();
    }
}
