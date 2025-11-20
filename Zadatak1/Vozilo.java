package Zadatak1;

public abstract class Vozilo {
	private int id;
	protected double maxBrzina;
	
	public Vozilo(int id, double maxBrzina) {
		super();
		this.id = id;
		this.maxBrzina = maxBrzina;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMaxBrzina() {
		return maxBrzina;
	}

	public void setMaxBrzina(double maxBrzina) {
		this.maxBrzina = maxBrzina;
	}
	public void info() {
        System.out.println("Vozilo ID: " + id + ", max brzina: " + maxBrzina + " km/h");
    }
	 public abstract double izracunajVrijemeDostave(double udaljenostKm);
	}
