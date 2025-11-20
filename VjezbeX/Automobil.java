package VjezbeX;

public class Automobil extends Vozilo {
	
	private double potrosnjaPoKm;
	
	public Automobil(int id, double maxBrzina, double potrosnjaPoKm) {
		super(id, maxBrzina);
		this.potrosnjaPoKm = potrosnjaPoKm;
	}


	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		double prosjecnaBrzina = maxBrzina * 0.6;
        return udaljenostKm / prosjecnaBrzina;
        }

	public double getPotrosnjaGorivaPoKm() {
        return potrosnjaPoKm;
    }
	@Override
    public void info() {
        System.out.print("Automobil -> ");
        super.info();
        System.out.println("Potrosnja goriva: " + potrosnjaPoKm + " l/km");
    }
}

