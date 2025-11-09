package vezbe8;

public class Konobar extends Zaposleni {
	private double prekovremeniSati;

	public Konobar(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati,
			double prekovremeniSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		this.prekovremeniSati = prekovremeniSati;
	}

	public double getPrekovremeniSati() {
		return prekovremeniSati;
	}

	public void setPrekovremeniSati(double prekovremeniSati) {
		this.prekovremeniSati = prekovremeniSati;
	}
	

	@Override
    public double izracunajPlatu() {
        double redovna = ukupanBrojSati * getPlataPoSatu();
        double prekovremeni = prekovremeniSati * getPlataPoSatu() * 1.2;
        return (redovna + prekovremeni) * 4; 
    }

	@Override
	public String toString() {
		return "Konobar [prekovremeniSati=" + prekovremeniSati + "]";
	}


	
	

}
