package vezbe8;
import java.util.ArrayList;

public class Restoran extends Zaposleni {
    private String naziv;
    private String adresa;
    private String PIB;
    private ArrayList<Zaposleni> zaposleni;
    private ArrayList<Smjena> smjene = new ArrayList<>();
    private ArrayList<ObracunPlate> istorijaObracuna = new ArrayList<>();

    public void dodajSmjenu(Smjena s) {
        if (s != null) smjene.add(s);
    }

    public boolean ukloniSmjenu(String datum, String tip) {
        return smjene.removeIf(sm -> sm.getDatum().equals(datum) && sm.getTip().equals(tip));
    }

    public ArrayList<Smjena> getSmjene() {
        return smjene;
    }

    public void izracunajSateIzSmjena() {
        for (Smjena s : smjene) {
            double sati = s.TrajanjeUSatima();
            for (Zaposleni z : s.getRadnici()) {
                z.setUkupanBrojSati(z.getUkupanBrojSati() + sati);
            }
        }
    }
    
    public Restoran(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, String naziv, String adresa, String pIB, ArrayList<Zaposleni> zaposleni) {
    	super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.naziv = naziv;
        this.adresa = adresa;
        PIB = pIB;
        this.zaposleni = new ArrayList<>();
    }
    
    public Restoran(String naziv, String adresa, String PIB) {
    	super(0, "Restoran", "-", 0, 0);
        this.naziv = naziv;
        this.adresa = adresa;
        this.PIB = PIB;
        this.zaposleni = new ArrayList<>();
    }

   
    public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ArrayList<ObracunPlate> getIstorijaObracuna() {
		return istorijaObracuna;
	}

	public void setIstorijaObracuna(ArrayList<ObracunPlate> istorijaObracuna) {
		this.istorijaObracuna = istorijaObracuna;
	}

	public void setSmjene(ArrayList<Smjena> smjene) {
		this.smjene = smjene;
	}
	
	
	public void dodajZaposlenog(Zaposleni z) { zaposleni.add(z); }
    public boolean ukloniZaposlenog(int ID) { return zaposleni.removeIf(z -> z.getID() == ID); }
    public Zaposleni pretraziPoID(int ID) {
        for (Zaposleni z : zaposleni) {
            if (z.getID() == ID) return z;
        }
        return null;
    }

    public void obracunPlata() {
    	System.out.println("Obračun plata za restoran");
        System.out.printf("Šifra Ime Prezime Pozicija Sati Dodatak Plata\n");
        for (Zaposleni z : zaposleni) {
            String dodatak = "-";
            
            if (z.getTip().equals("Konobar")) {
            	Konobar k = (Konobar) z;
                dodatak = "" + k.getPrekovremeniSati();
                
            } else if (z.getTip().equals("Menadzer")) {
            	Menadzer m = (Menadzer) z;
                dodatak = String.valueOf(m.getBonus());
            }
            
            System.out.printf("%-5d %-10s %-10s %-10s %-10.1f %-10s %-10.2f\n",
                    z.getID(), z.getIme(), z.getPrezime(), z.getTip(),
                    z.getUkupanBrojSati(), dodatak, z.izracunajPlatu());
        }
    }
    
    public double ukupniTrosak() {
    	double ukupno = 0;
        for (Zaposleni z : zaposleni) {
            ukupno += z.izracunajPlatu();
        }
        return ukupno;
    }

    public void ObracunPlata(int mjesec, int godina) {
        System.out.println(this);
        System.out.println("Obračun plata za restoran:");
        System.out.printf("%-6s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Šifra", "Ime", "Prezime", "Pozicija", "Sati", "Dodatak", "Plata");
        
        double ukupno = 0;

        for (Zaposleni z : zaposleni) {
            double dodatak = 0;
            String tip = z.getClass().getSimpleName(); // "Konobar", "Kuvar", "Menadzer"
            double plata = z.izracunajPlatu();

            if (tip.equals("Konobar")) {
                Konobar k = (Konobar) z;
                dodatak = k.getPrekovremeniSati();
                
            } else if (tip.equals("Menadzer")) {
                Menadzer m = (Menadzer) z;
                dodatak = m.getBonus();
                
            } else if (tip.equals("Kuvar")) {
                dodatak = 0;
            }

            System.out.printf("%-6d %-10s %-10s %-10s %-10.1f %-10.1f %-10.2f\n",
                    z.getID(), z.getIme(), z.getPrezime(), tip, z.getUkupanBrojSati(), dodatak, plata);

            ukupno += plata;
            
            String napomena = "";
            if (tip.equals("Konobar")) napomena = "Prekovremeni rad uračunat";
            if (tip.equals("Menadzer") && dodatak > 0) napomena = "Bonus uračunat";

            istorijaObracuna.add(new ObracunPlate(mjesec, godina, z, plata, napomena));
        }

        System.out.printf("\nUkupni trošak plata: %.2f EUR\n", ukupno);
    }
    
    public void ispisiIstorijuObracuna() {
        System.out.println("Istorija obračuna plata:");
        for (ObracunPlate op : istorijaObracuna) {
            System.out.printf("Mjesec: %d, Godina: %d, Zaposleni: %s %s, Plata: %.2f, Napomena: %s\n",
            		op.getMjesec(), op.getGodina(),
                    op.getZaposleni().getIme(), op.getZaposleni().getPrezime(),
                    op.getIznos(), op.getNapomena());
        }
    }

    @Override
    public String toString() {
        return "Restoran [naziv=" + naziv + ", adresa=" + adresa + ", PIB=" + PIB + "]";
    }
}
