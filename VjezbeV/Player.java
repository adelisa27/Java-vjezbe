package projekat2;

       class Player {
		    private String name;
		    private int x, y;
		    private int width;
		    private int height;
		    private int health;
			
		    public Player(String name, int x, int y, int width, int height, int health) {
				super();
				this.name = name.trim().replaceAll("\\s+"," ");
				if (name.isEmpty()) {
		        return;
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

				 sb.toString().trim();
			    this.x = x;
				this.y = y;
				this.width = width;
				this.height = height;
				this.health = health;
				if(health >= 0 && health <= 100) {
					this.health = health;
			}   else {
		   }        this.health = 100;
		  
		    }

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
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
				if(health >= 0 && health <= 100)
				this.health = health;
			}

			@Override
			public String toString() {
				return "Player[" + name + "]@(" + x + "," + y + ")"+  width +"x" +  height + "HP=" + health;
			}
			
			
		    
		
	}


