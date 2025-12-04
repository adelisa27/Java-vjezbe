package projekat5;

public class BossEnemy extends Enemy {

    public BossEnemy(String type, int x, int y, Collidable col, int dmg, int hp) {
        super(type, x, y, col, dmg, hp);
    }

    @Override
    public int getEffectiveDamage() {
        return damage * 2;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString();
    }
}
