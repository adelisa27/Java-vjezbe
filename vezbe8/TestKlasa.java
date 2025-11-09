package vezbe8;

import java.util.ArrayList;

public class TestKlasa {
    public static void main(String[] args) {
        
        Restoran r = new Restoran("Fast Food King", "Glavna 5", "123456789");

        Konobar k1 = new Konobar(1, "Marko", "Marković", 5.5, 0, 12);
        Konobar k2 = new Konobar(2, "Ivana", "Ivić", 5.5, 0, 8);
        Kuvar kuvar = new Kuvar(3, "Luka", "Lukić", 6.0, 0);
        Menadzer m1 = new Menadzer(4, "Petar", "Perić", 8.0, 0, 250, 1300);
        Konobar k3 = new Konobar(5, "Ana", "Anić", 5.0, 0, 5); 
        
        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(kuvar);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(k3);

        ArrayList<Zaposleni> radniciJutarnja = new ArrayList<>();
        radniciJutarnja.add(k1);
        radniciJutarnja.add(kuvar);
        Smjena jutarnjaSmjena = new Smjena("09-11-2025", "08:00", "16:00", "jutarnja", radniciJutarnja);

        ArrayList<Zaposleni> radniciPopodnevna = new ArrayList<>();
        radniciPopodnevna.add(k2);
        radniciPopodnevna.add(m1);
        Smjena popodnevnaSmjena = new Smjena("09-11-2025", "12:00", "20:00", "popodnevna", radniciPopodnevna);

        ArrayList<Zaposleni> radniciNocna = new ArrayList<>();
        radniciNocna.add(k3);
        radniciNocna.add(kuvar);
        Smjena nocnaSmjena = new Smjena("10-11-2025", "22:00", "06:00", "noćna", radniciNocna);

        r.dodajSmjenu(jutarnjaSmjena);
        r.dodajSmjenu(popodnevnaSmjena);
        r.dodajSmjenu(nocnaSmjena);

        r.izracunajSateIzSmjena();

        r.ObracunPlata(11, 2025);
        
        r.ispisiIstorijuObracuna();
    }
}
