package VjezbeV;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite rijec koju zelite provjeriti da li je palindrom: ");
		
		String x = sc.nextLine().trim();
		
		String y = new StringBuilder(x).reverse().toString();
		
		if (x.equalsIgnoreCase(y)) {
			System.out.print("Jeste palindrom");
		}
		else {
			System.out.print("Nije palindrom");

			
		}
		
		
		
		
	}

}
