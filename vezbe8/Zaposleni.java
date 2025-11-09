package vezbe8;

public class Zaposleni {
	protected int ID;
	protected String ime;
	protected String prezime; 
	protected double plataPoSatu;
	protected double ukupanBrojSati;
	
	public Zaposleni(int iD, String ime, String prezime, double plataPoSatu, double ukpanBrojSati) {
		super();
		ID = iD;
		this.ime = ime;
		this.prezime = prezime;
		this.plataPoSatu = plataPoSatu;
		this.ukupanBrojSati = ukpanBrojSati;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public double getPlataPoSatu() {
		return plataPoSatu;
	}

	public void setPlataPoSatu(double plataPoSatu) {
		this.plataPoSatu = plataPoSatu;
	}

	public double getUkupanBrojSati() {
		return ukupanBrojSati;
	}

	public void setUkupanBrojSati(double ukupanBrojSati) {
		this.ukupanBrojSati = ukupanBrojSati;
	}
	
	public String getTip() {
        return this.getClass().getSimpleName();
    }
	
	public double izracunajPlatu() {
	    return ukupanBrojSati * plataPoSatu * 4; 
	}


	@Override
	public String toString() {
		return "Zaposleni [ID=" + ID + ", ime=" + ime + ", prezime=" + prezime + ", plataPoSatu=" + plataPoSatu
				+ ", ukupanBrojSati=" + ukupanBrojSati + "]";
	}
	
	
	
	
	

}
