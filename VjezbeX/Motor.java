package VjezbeX;

public class Motor extends Vozilo implements Ekonomican {

	private double potrosnjaPoKm;

	public Motor(int id, double maxBrzina, double potrosnjaPoKm) {
		super(id, maxBrzina);
		this.potrosnjaPoKm = potrosnjaPoKm;
	}
	
	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
    double prosjecnaBrzina = maxBrzina * 0.8;
    return udaljenostKm / prosjecnaBrzina;
	}

	@Override
    public double potrosnjaPoKm() {
        return potrosnjaPoKm;
    }
	 @Override
	    public void info() {
	        System.out.print("Motor -> ");
	        super.info();
	        System.out.println("Potrosnja goriva: " + potrosnjaPoKm + " l/km");
	    }
	}
