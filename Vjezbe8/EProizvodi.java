package Vjezbe8;

public class EProizvodi {
	protected String opis;
	protected String sifra;
    protected double uvoznaCijena;
	public EProizvodi(String opis, String sifra, double uvoznaCijena) {
		super();
		this.opis = opis;
		this.sifra = sifra;
		this.uvoznaCijena = uvoznaCijena;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public double getUvoznaCijena() {
		return uvoznaCijena;
	}
	public void setUvoznaCijena(double uvoznaCijena) {
		this.uvoznaCijena = uvoznaCijena;
	}
	
	 public double izracunajMaloprodajnuCijenu() {
	       return uvoznaCijena * 1.05;
	 }
	       
	@Override
	public String toString() {
		return "EProizvodi [opis=" + opis + ", sifra=" + sifra + ", uvoznaCijena=" + uvoznaCijena + "]";
	}
	public String getTip() {
	    return this.getClass().getSimpleName(); 
	}
}
	