package projekat5;

public abstract class GameObject {

    protected int x, y;
    protected Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null)
            throw new IllegalArgumentException("Collider ne može biti null");

        this.x = x;
        this.y = y;
        this.collider = collider;
    }

    public boolean intersects(GameObject other) {
        return this.collider.intersects(other.collider);
    }

    public abstract String getDisplayName();
}
