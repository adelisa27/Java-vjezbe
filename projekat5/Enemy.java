package projekat5;

public class Enemy extends GameObject implements Attacker {

	    protected String type;
	    protected int damage;
	    protected int health;

	    public Enemy(String type, int x, int y, Collidable col, int damage, int health) {
	        super(x, y, col);

	        this.type = type;

	        if (damage < 0 || damage > 100)
	            throw new IllegalArgumentException("DMG 0–100!");

	        if (health < 0 || health > 150)  
	            throw new IllegalArgumentException("Enemy HP nevažeći!");

	        this.damage = damage;
	        this.health = health;
	    }

	    @Override
	    public int getEffectiveDamage() {
	        return damage;
	    }

	    @Override
	    public String getDisplayName() {
	        return type;
	    }
}

	

	
