package Projekat;

public class Automobil extends Vozilo {
    private int brojVrata;
    private String tipMotora; 

    public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja,
                     int brojVrata, String tipMotora) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja); //Pozivanje super, za uzimanje osnovnih izračuna iz klase Vozilo
        this.brojVrata = brojVrata;
        this.tipMotora = tipMotora;
    }

    public int getBrojVrata() { return brojVrata; }
    public void setBrojVrata(int brojVrata) { this.brojVrata = brojVrata; }

    public String getTipMotora() { return tipMotora; }
    public void setTipMotora(String tipMotora) { this.tipMotora = tipMotora; }

    @Override
    public double racunajRegistraciju() {
        double cijena = super.racunajRegistraciju(); 
        if (tipMotora != null && tipMotora.trim().equalsIgnoreCase("dizel")) {
            cijena += 20.0;
        }
        return cijena;
    }

    @Override //informacije o automobilu
    public void prikaziInfo() {
        System.out.println("=== Automobil ===");
        super.prikaziInfo(); 
        System.out.println("Broj vrata: " + brojVrata);
        System.out.println("Tip motora: " + tipMotora);
        System.out.println("Ukupna cijena registracije: " + racunajRegistraciju() + " EUR");
        System.out.println();
    }
}

