package Projekat4;

public class RectangleCollider implements Collidable{
	private double x;
    private double y;
    private double width;
    private double height;
	public RectangleCollider(double x, double y, double width, double height) {
		if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimenzije moraju biti veće od nule!");
        }
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	 public void setPosition(double x, double y) {
	        this.x = x;
	        this.y = y;
	    }
	 public double getX() { return x; }
	 public double getY() { return y; }
	 public double getwidth() { return width; }
	 public double getHeight() { return height; }


	 @Override
	    public boolean intersects(Collidable other) {
	        if (other instanceof RectangleCollider) {
	            RectangleCollider r = (RectangleCollider) other;

	            boolean overlapX = this.x < r.x + r.width && this.x + this.width > r.x;
	            boolean overlapY = this.y < r.y + r.height && this.y + this.height > r.y;

	            return overlapX && overlapY;
	        }
	            
	            return false;
	            
	        }

	public int getWidth() {
		
		return 0;
	}
	        
	 }

	 

    


