package vezbe8;

public class Kuvar extends Zaposleni {
	private double fiksniIznos;
	

	public double getFiksniIznos() {
		return fiksniIznos;
	}


	public void setFiksniIznos(double fiksniIznos) {
		this.fiksniIznos = fiksniIznos;
	}


	public Kuvar(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
	}
	@Override
    public double izracunajPlatu() {
        return 1500 + 4 * ukupanBrojSati * plataPoSatu;
    }

	
}
	
