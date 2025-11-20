package Projekat4;

public class CircleCollider implements Collidable {

    private double x;
    private double y;
    private double radius;

    public CircleCollider(double x, double y, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Poluprečnik mora biti veći od nule!");
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    @Override
    public boolean intersects(Collidable other) {

        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;

            double dx = this.x - c.x;
            double dy = this.y - c.y;

            double dist2 = dx * dx + dy * dy;
            double sumR = this.radius + c.radius;

            return dist2 <= sumR * sumR;
        }

        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            double closestX = clamp(this.x, r.getX(), r.getX() + r.getWidth());
            double closestY = clamp(this.y, r.getY(), r.getY() + r.getHeight());

            double dx = this.x - closestX;
            double dy = this.y - closestY;

            return dx * dx + dy * dy <= radius * radius;
        }

        return false;
    }
}
