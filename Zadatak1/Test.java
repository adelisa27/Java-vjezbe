package Zadatak1;
import java.util.ArrayList;
public class Test {

	public static void main(String[] args) {
		
		ArrayList<Vozilo> vozila = new ArrayList<>();

		vozila.add(new Bicikl(1, 20));          // id=1, maxBrzina=20
	    vozila.add(new Motor(2, 60, 0.04));     // id=2, maxBrzina=60, potrosnja 0.04
		vozila.add(new Automobil(3, 80, 0.07)); // id=3, maxBrzina=80, potrosnja 0.07
		
		double udaljenost = 10;
		
		System.out.println("Dostava za " + udaljenost + " km\n");

		for (Vozilo v : vozila) {

			v.info();
			double vrijeme = v.izracunajVrijemeDostave(udaljenost);
			System.out.println("Vrijeme dostave: " + vrijeme + " h");
			
			if (v instanceof Ekonomican) {
				Ekonomican e = (Ekonomican) v;
				double potrosnja = e.potrosnjaPoKm() * udaljenost;
				System.out.println("Potrošnja na " + udaljenost + " km: " + potrosnja);
				
			}
			
			System.out.println();
			
		}
		
	}
	
}


