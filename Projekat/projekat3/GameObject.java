//Adelisa Palavrtić 22/019, Daris Velović 24/016

package projekat3;

public class GameObject {

	       protected int x , y , width , height, health;

			public GameObject(int x, int y, int width, int height) {
				super();
				this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
			}
			public boolean intersects(GameObject other) {
				 return (this.x < other.x + other.width &&
			                this.x + this.width > other.x &&
			                this.y < other.y + other.height &&
			                this.y + this.height > other.y);
			    }
			public String toString() {
				return String.format("( %d,%d) %dx%d", x, y, width, height);
			}
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			public int getY() {
				return y;
			}
			public void setY(int y) {
				this.y = y;
			}
			public int getWidth() {
				return width;
			}
			public void setWidth(int width) {
				this.width = width;
			}
			public int getHeight() {
				return height;
			}
			public void setHeight(int height) {
				this.height = height;
			}
			public int getHealth() {
				return health;
			}
			public void setHealth(int health) {
				this.health = x;
			}
			
		
	}


