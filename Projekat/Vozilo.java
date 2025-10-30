package Projekat;

public class Vozilo {
	
        protected String proizvodjac;
	    protected int godinaProizvodnje;
	    protected int kubikaza;
	    protected String boja;

	    public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
	        this.proizvodjac = proizvodjac;
	        this.godinaProizvodnje = godinaProizvodnje;
	        this.kubikaza = kubikaza;
	        this.boja = boja;
	    }

	    //geteri i seteri
	    public String getProizvodjac() { return proizvodjac; }
	    public void setProizvodjac(String proizvodjac) { this.proizvodjac = proizvodjac; }

	    public int getGodinaProizvodnje() { return godinaProizvodnje; }
	    public void setGodinaProizvodnje(int godinaProizvodnje) { this.godinaProizvodnje = godinaProizvodnje; }

	    public int getKubikaza() { return kubikaza; }
	    public void setKubikaza(int kubikaza) { this.kubikaza = kubikaza; }

	    public String getBoja() { return boja; }
	    public void setBoja(String boja) { this.boja = boja; }

	    // racunanje cijene registracije 
	    public double racunajRegistraciju() {
	        double cijena = 100.0; 
	        // ako je vozilo starije od 2010- uvecati za 30 EUR
	        if (this.godinaProizvodnje < 2010) {
	            cijena += 30.0;
	        }
	        // ako je kubikaza veca od 2000 uvecati  za 50 EUR
	        if (this.kubikaza > 2000) {
	            cijena += 50.0;
	        }
	        return cijena;
	    }

	    
	    public void prikaziInfo() {
	        System.out.println("Proizvođač: " + proizvodjac);
	        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
	        System.out.println("Kubikaža: " + kubikaza + " cm3");
	        System.out.println("Boja: " + boja);
	    }
	}



