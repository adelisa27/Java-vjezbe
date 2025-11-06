package Vjezbe8;
public class testKlasa {

	public static void main(String[] args) {
		EProizvodi[] proizvodi = new EProizvodi[3];

		proizvodi[0] = new Racunari("Laptop Lenovo", "RA001", 800.0, "Intel i7", 16);
		proizvodi[1] = new Telefon("iPhone 14", "TE999", 1100.0, "iOS", 6.1);
		proizvodi[2] = new TV("LG Smart TV", "TV222", 900.0, 70);

		System.out.println("Svi proizvodi");
		for (EProizvodi p : proizvodi) {
		    System.out.println(p);
		    
		}


	}

}