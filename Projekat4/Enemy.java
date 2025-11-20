package Projekat4;

public abstract class Enemy extends GameObject implements Attacker {

    protected String type;
    protected int damage;
    protected int health;

    public Enemy(String type, double x, double y, Collidable collider, int damage, int health) {
        super(type, x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() {
        return type;
    }

    public void setType(String t) {
        if (t == null) {
            throw new IllegalArgumentException("Tip neprijatelja ne smije biti null");
        }
        t = t.trim();
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan");
        }
        this.type = t;
        setNaziv(t);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int d) {
        if (d < 0 || d > 100) {
            throw new IllegalArgumentException("Damage mora biti u opsegu 0–100");
        }
        this.damage = d;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        if (h < 0 || h > 100) {
            throw new IllegalArgumentException("Health mora biti u opsegu 0–100");
        }
        this.health = h;
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return "Enemy: " + getType();
    }

    @Override
    public String toString() {
        return "Enemy[type=" + type +
               ", x=" + getX() +
               ", y=" + getY() +
               ", dmg=" + damage +
               ", hp=" + health + "]";
    }
}
