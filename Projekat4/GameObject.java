package Projekat4;

public abstract class GameObject {
	protected String naziv;
    private double x;
    private double y;
    private Collidable collider;
	
    public GameObject(String naziv, double x, double y, Collidable collider) {
		super();
		this.naziv = naziv;
		this.x = x;
		this.y = y;
		this.collider = collider;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Collidable getCollider() {
		return collider;
	}

	public void setCollider(Collidable collider) {
		this.collider = collider;
	}

	public boolean intersects(GameObject other) {
        if (this.collider == null || other.collider == null) {
            return false;
        }
        return this.collider.intersects(other.collider);
	}
	
	public abstract String getDisplayName();
	
	@Override
	public String toString() {
		return "GameObject [naziv=" + naziv + ", x=" + x + ", y=" + y + ", collider=" + collider + "]";
	}

	public int getEffectiveDamage() {
		return 0;
	}
    


}
