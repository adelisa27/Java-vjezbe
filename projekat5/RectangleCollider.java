package projekat5;

public class RectangleCollider implements Collidable {

    public int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Dimenzije moraju biti > 0");

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean intersects(Collidable other) {

        if (other instanceof RectangleCollider r) {
            return this.x < r.x + r.width &&
                   this.x + this.width > r.x &&
                   this.y < r.y + r.height &&
                   this.y + this.height > r.y;
        }

        if (other instanceof CircleCollider c)
            return c.intersects(this);

        return false;
    }
}