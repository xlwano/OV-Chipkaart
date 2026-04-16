package ovchipkaart;

import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Locatie nijmegen = new Locatie("Nijmegen",8.0, 8.0);
        Locatie arnhem = new Locatie("Arnhem", 6.0, 7.0);
        Paal paal1 = new Paal(5.00, nijmegen, 0.30);
        Paal paal2 = new Paal(5.00, arnhem, 0.30);
        Geldautomaat geldautomaat = new Geldautomaat(150.00);
        Kaart kaart1 = new Kaart(50.0, LocalDate.of(2027, 1, 1), 1001);


        System.out.println();
        paal1.checkIn(kaart1);










    }
}
