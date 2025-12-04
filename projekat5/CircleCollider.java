package projekat5;

public class CircleCollider implements Collidable {

	    private int cx, cy, radius;

	    public CircleCollider(int cx, int cy, int radius) {
	        if (radius <= 0) throw new IllegalArgumentException("Poluprečnik mora biti > 0");

	        this.cx = cx;
	        this.cy = cy;
	        this.radius = radius;
	    }

	    private double clamp(double val, double min, double max) {
	        return Math.max(min, Math.min(max, val));
	    }

	    @Override
	    public boolean intersects(Collidable other) {

	        if (other instanceof CircleCollider c) {
	            double dist = Math.hypot(cx - c.cx, cy - c.cy);
	            return dist <= this.radius + c.radius;
	        }

	        if (other instanceof RectangleCollider r) {

	            double closestX = clamp(cx, r.x, r.x + r.width);
	            double closestY = clamp(cy, r.y, r.y + r.height);

	            double dist = Math.hypot(cx - closestX, cy - closestY);

	            return dist <= radius;
	        }

	        return false;
	    }
	}

	
