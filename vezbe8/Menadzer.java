package vezbe8;

public class Menadzer extends Zaposleni {
	private double bonus;
	private double osnovica;
	
	public Menadzer(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus,
			double osnovica) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		this.bonus = bonus;
		this.osnovica = osnovica;
	}
	
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getOsnovica() {
		return osnovica;
	}
	
	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}
	
	@Override
    public double izracunajPlatu() {
        double osnovica = 1300; 
        return osnovica + 4 * ukupanBrojSati * plataPoSatu + bonus;
	}
        
	@Override
	public String toString() {
	    return "Menadzer [ID=" + ID + ", ime=" + ime + ", prezime=" + prezime +
	           ", plataPoSatu=" + plataPoSatu + ", ukupanBrojSati=" + ukupanBrojSati +
	           ", bonus=" + bonus + ", Plata=" + izracunajPlatu() + "]";
	}

	
}	
        
	

	
	


