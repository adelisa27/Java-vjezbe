package Projekat4;

public class Player extends GameObject {
	private int health;
	

	public Player(String naziv, double x, double y, Collidable collider, int health) {
		super(formatName(naziv), x, y, collider);
		this.health = health;
	}
	private static String formatName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Ime ne smije biti null"); 
        }
        
        name = name.trim().replaceAll("\\s+", " ");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Ime ne smije biti prazno");
	}
        String[] rijeci = name.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String r : rijeci) {
            if (!r.isEmpty()) {
                sb.append(Character.toUpperCase(r.charAt(0)))
                  .append(r.substring(1).toLowerCase())
                  .append(" ");
            }
            
        }

        return sb.toString().trim();
	}
	public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti u opsegu 0–100");
        }
        this.health = health;
    }
	
    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
        if (getCollider() instanceof RectangleCollider) {
            ((RectangleCollider) getCollider()).setPosition(x, y);
        }
    }


    @Override
    public String toString() {
        return "Player[naziv=" + getNaziv() +
               ", x=" + getX() +
               ", y=" + getY() +
               ", health=" + health + "]";
    }
	@Override
	public String getDisplayName() {
		return null;
	}
	public void decrease(int effectiveDamage) {
		
	}

}


