package vezbe8;
import java.util.ArrayList;
public class Smjena {
	private String datum;
	private String pocetak;
	private String kraj;
	private String tip; // jutarnja, popodnevna, nocna
    private ArrayList<Zaposleni> radnici;
	
    public Smjena(String datum, String pocetak, String kraj, String tip, ArrayList<Zaposleni> radnici) {
		super();
		this.datum = datum;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tip = tip;
		this.radnici = radnici;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public ArrayList<Zaposleni> getRadnici() {
		return radnici;
	}

	public void setRadnici(ArrayList<Zaposleni> radnici) {
		this.radnici = radnici;
	}
    
	public void dodajRadnika(Zaposleni z) { radnici.add(z); }
	
	public double TrajanjeUSatima() {
		String[] pocetakDijelovi = pocetak.split(":");
        String[] krajDijelovi = kraj.split(":");
        int pocetakSati = Integer.parseInt(pocetakDijelovi[0]);
        int pocetakMinute = Integer.parseInt(pocetakDijelovi[1]);
        
        int krajSati = Integer.parseInt(krajDijelovi[0]);
        int krajMinute = Integer.parseInt(krajDijelovi[1]);
        
        int ukupnoMinute = (krajSati * 60 + krajMinute) - (pocetakSati * 60 + pocetakMinute);
	
        if (ukupnoMinute < 0) {
            ukupnoMinute += 24 * 60; 
        }
            return ukupnoMinute / 60.0;
	}

	public void evidentirajSate() {
        double satiSmjene = TrajanjeUSatima();
        for (Zaposleni z : radnici) {
            z.setUkupanBrojSati(z.getUkupanBrojSati() + satiSmjene);
        }
    }

    @Override
    public String toString() {
        return "Smjena [datum=" + datum + ", pocetak=" + pocetak + ", kraj=" + kraj +
                ", tip=" + tip + ", brojRadnika=" + radnici.size() + "]";
    }
}


