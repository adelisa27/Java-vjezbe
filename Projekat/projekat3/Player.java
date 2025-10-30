//Adelisa Palavrtić 22/019, Daris Velović 24/016
package projekat3;

        public class Player extends GameObject {

		     private String ime;
		     private int health;



		   public Player(String ime, int x, int y, int width, int height, int health) {
			   super(x,y,width,height);
			   setIme(ime);
			   setHealth(health);
		      
		   }



		   public String getIme() {

		       return ime;

		   }



		   public void setIme(String ime) {

		       if (ime.isEmpty()) {

		           System.out.print("Ime igraca ne smije biti prazno");

		       }

		       String [] rijeci = ime.trim().split("\\s+");

		       StringBuilder formatiranoIme = new StringBuilder();

		       for (int i = 0; i < rijeci.length; i++) {

		           String rijec = rijeci[i];

		           if (!rijec.isEmpty()) {

		               formatiranoIme.append(Character.toUpperCase(rijec.charAt(0)));

		               if (rijec.length() > 1) {

		                   formatiranoIme.append(rijec.substring(1).toLowerCase());

		               }

		               if (i < rijeci.length - 1) {

		                   formatiranoIme.append(" ");

		               }

		           }
		       }

		      this.ime = formatiranoIme.toString();

		   }

		   



		   public int getHealth() {

		       return health;

		   }

		   public void setHealth(int health) {

		       if (health < 0) {

		           this.health = 0;

		       } else {
		    	   this.health = Math.min(health, 100);
		       }

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





		@Override

		public String toString() {



		    return String.format("Igrac '%s' | Pozicija: (%d, %d) | Dimenzije: %dx%d | Health: %d/100",

		            ime, x, y, width, height, health );

		}

		}


