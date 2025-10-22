package VjezbeV;
import java.util.Scanner;
public class zadatak3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Unesite string: ");
		String rijec = sc.nextLine();
		
		boolean nadjeno = false;
		
		for(int i=0; i<rijec.length()-1;i++) {
			
			if(rijec.charAt(i)==rijec.charAt(i+1)) {
				System.out.println("Nasli smo dva ista slova u rijeci i to:" + rijec.charAt(i) + "' na pozicijama "+ i + " i " + (i + 1));
				nadjeno=true;
			}
		}
	if(nadjeno) {
		System.out.println("Nema povezanih slova");
	}

}
}