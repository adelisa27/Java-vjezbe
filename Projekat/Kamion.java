package Projekat;



		public class Kamion extends Vozilo {
		    private double kapacitetTereta; 
		    private boolean imaPrikolicu;

		    public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
		                  double kapacitetTereta, boolean imaPrikolicu) {
		        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		        this.kapacitetTereta = kapacitetTereta;
		        this.imaPrikolicu = imaPrikolicu;
		    }

		    public double getKapacitetTereta() { return kapacitetTereta; }
		    public void setKapacitetTereta(double kapacitetTereta) { this.kapacitetTereta = kapacitetTereta; }

		    public boolean isImaPrikolicu() { return imaPrikolicu; }
		    public void setImaPrikolicu(boolean imaPrikolicu) { this.imaPrikolicu = imaPrikolicu; }

		    @Override
		    public double racunajRegistraciju() {
		        double cijena = super.racunajRegistraciju();
		      
		        if (imaPrikolicu) {
		            cijena += 50.0;
		        }
		        return cijena;
		    }

		    @Override
		    public void prikaziInfo() {
		        System.out.println("=== Kamion ===");
		        super.prikaziInfo();
		        System.out.println("Kapacitet tereta: " + kapacitetTereta + " t");
		        System.out.println("Ima prikolicu: " + (imaPrikolicu ? "Da" : "Ne"));
		        System.out.println("Ukupna cijena registracije: " + racunajRegistraciju() + " EUR");
		        System.out.println();
		    }
		


	}


