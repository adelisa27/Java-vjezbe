package VezbeXzad2;
import java.util.Scanner;

public class Zadatak2 {
	
	public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        double cijena = 0;
	        boolean validno = false;

	        while (!validno) {
	            try {
	                System.out.print("Unesite cijenu proizvoda: ");
	                String unos = sc.nextLine();

	                
	                cijena = Double.parseDouble(unos);

	                
	                if (cijena <= 0) {
	                    throw new IllegalArgumentException("Cijena mora biti veća od nule!");
	                }

	               
	                validno = true;

	            } catch (NumberFormatException e) {
	                System.out.println("Greška: morate unijeti broj!");
	            } catch (IllegalArgumentException e) {
	                System.out.println("Greška: " + e.getMessage());
	            }
	        }

	        System.out.println("Cijena uspješno unesena: " + cijena + " EUR.");
	    }
	}



