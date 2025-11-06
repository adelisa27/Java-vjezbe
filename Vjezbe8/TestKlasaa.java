package Vjezbe8;
import java.util.ArrayList;
import java.util.Scanner;
public class TestKlasaa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<EProizvodi> proizvodi = new ArrayList<>();
		
		while (true) {
			System.out.println("\n--- Meni ---");
		    System.out.println("1. Unos uređaja");
		    System.out.println("2. Prikaz svih uređaja");
		    System.out.println("3. Prikaz uređaja određenog tipa");
		    System.out.println("0. Izlaz");
		    System.out.print("Izbor: ");
		    int izbor = sc.nextInt();
		    sc.nextLine(); 
		    
		    if (izbor == 0) break;
		    
		    switch (izbor) {
		    
		    case 1:
		    	
		    	System.out.print("Unesi opis: ");
		    	
		    	String opis = sc.nextLine();
		    	System.out.print("Unesi šifru (RA/TE/TV...): ");
		    	String sifra = sc.nextLine();
		    	System.out.print("Unesi uvoznu cijenu: ");
		    	double cijena = sc.nextDouble();
		    	sc.nextLine();
		    	
		    	if (sifra.startsWith("RA")) {
		    		System.out.print("Procesor: ");
		    		String proc = sc.nextLine();
		    		System.out.print("Memorija (GB): ");
		    		int mem = sc.nextInt();
		    		sc.nextLine();
		    		proizvodi.add(new Racunari(opis, sifra, cijena, proc, mem));
		    		
		    	} else if (sifra.startsWith("TE")) {
		    		System.out.print("Operativni sistem: ");
		    		String os = sc.nextLine();
		    		System.out.print("Veličina ekrana (inči): ");
		    		double vel = sc.nextDouble();
		    		sc.nextLine();
		    		proizvodi.add(new Telefon(opis, sifra, cijena, os, vel));
		    		
		    	} else if (sifra.startsWith("TV")) {
		    		System.out.print("Veličina ekrana (inči): ");
		    		double vel = sc.nextDouble();
		    		sc.nextLine();
		    		proizvodi.add(new TV(opis, sifra, cijena, vel));
		    		
		    	} else {
		    		
		    		System.out.println("Nepoznat tip proizvoda!");
		    		
		    	}
		    	
		    	break;
		    	
		    case 2:
		    	
		    	System.out.println("\n--- Svi uređaji ---");
		    	
		    	for (EProizvodi p : proizvodi) {
		    		System.out.println(p);
		    		
		    	}
		    	
		    	break;
		    	
		    case 3:
		    	
		    	System.out.print("Unesi tip uređaja (Racunari/Telefoni/TV): ");
		    	
		    	String tip = sc.nextLine();
		    	System.out.println("\n--- Uređaji tipa: " + tip + " ---");
		    	
		    	for (EProizvodi p : proizvodi) {
		    		if (p.getTip().equalsIgnoreCase(tip)) {
		    			System.out.println(p);
		    			}
		    		}
		    	
		    	break;
		    	
		    default:
		    	
		    	System.out.println("Pogrešan izbor!");
		            }
		        }

		        sc.close();
		        System.out.println("Kraj programa.");
		    }
		}

