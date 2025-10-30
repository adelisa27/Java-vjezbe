//Adelisa Palavrtić 22/019, Daris Velović 24/016
package projekat3;


	

	public class Enemy extends GameObject {

	    private String tip;
	    private int damage;

	    public Enemy(String tip, int x, int y, int width, int height, int damage, int health) {
	        super(x, y, width, height);
	        setTip(tip);
	        setDamage(damage);
	    }

	    public String getTip() {
	        return tip;
	    }

	    public void setTip(String tip) {
	        if (tip == null || tip.trim().isEmpty()) {
	            System.out.println("Tip neprijatelja ne smije biti prazan!");
	            return;
	        }

	        String[] rijeci = tip.trim().split("\\s+");
	        StringBuilder formatiranoIme = new StringBuilder();

	        for (int i = 0; i < rijeci.length; i++) {
	            String r = rijeci[i];
	            formatiranoIme.append(Character.toUpperCase(r.charAt(0)));

	            if (r.length() > 1) {
	                formatiranoIme.append(r.substring(1).toLowerCase());
	            }

	            if (i < rijeci.length - 1) {
	                formatiranoIme.append(" ");
	            }
	        }

	        this.tip = formatiranoIme.toString();
	    }

	    public int getDamage() {
	        return damage;
	    }

	    public void setDamage(int damage) {
	        if (damage < 0) {
	            this.damage = 0;
	        } else {
	            this.damage = Math.min(damage, 100);
	        }
	    }
	    public int getHealth() {
			return health;
		}
		public void setHealth(int health) {
			this.health = x;
		}
		

	    @Override
	    public String toString() {
	        return String.format("Enemy[%s] @ (%d,%d) %dx%d DMG=%d",
	                tip, x, y, width, height, damage);
	    }
	}
	class MeleeEnemy extends Enemy {
	    public MeleeEnemy(String tip, int x, int y, int width, int height, int damage, int health) {
	        super(tip, x, y, width, height, damage, health);
	    }
	}

	class BossEnemy extends Enemy {
	    public BossEnemy(String tip, int x, int y, int width, int height, int damage, int health) {
	        super(tip, x, y, width, height, damage, health);
	    }

	    @Override
	    public String toString() {
	        return "BossEnemy[" + getTip() + "] @ (" + getX() + "," + getY() + ") " +
	               getWidth() + "x" + getHeight() + " DMG=" + getDamage() + "x2 HP=" + getHealth();
	    }
	}



