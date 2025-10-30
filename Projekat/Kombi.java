package Projekat;

          public class Kombi extends Vozilo {
		    private int kapacitetPutnika; 

		    public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
		                 int kapacitetPutnika) {
		        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		        this.kapacitetPutnika = kapacitetPutnika;
		    }

		    public int getKapacitetPutnika() { return kapacitetPutnika; }
		    public void setKapacitetPutnika(int kapacitetPutnika) { this.kapacitetPutnika = kapacitetPutnika; }

		    @Override
		    public double racunajRegistraciju() {
		        double cijena = super.racunajRegistraciju();
		        if (kapacitetPutnika > 8) {
		            cijena += 30.0;
		        }
		        return cijena;
		    }

		    @Override
		    public void prikaziInfo() {
		        System.out.println("=== Kombi ===");
		        super.prikaziInfo();
		        System.out.println("Kapacitet putnika: " + kapacitetPutnika);
		        System.out.println("Ukupna cijena registracije: " + racunajRegistraciju() + " EUR");
		        System.out.println();
		    }
		


	}


