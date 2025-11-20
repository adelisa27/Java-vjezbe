package VjezbeX;

public class Bicikl extends Vozilo implements Ekonomican {
	
	public Bicikl(int id, double maxBrzina) {
        super(id, maxBrzina);
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		double prosjecnaBrzina = maxBrzina * 0.7;
        return udaljenostKm / prosjecnaBrzina; 
	}
	@Override
    public double potrosnjaPoKm() {
        
        return 0.0;
    }

    @Override
    public void info() {
        System.out.print("Bicikl -> ");
        super.info();
    }
}

