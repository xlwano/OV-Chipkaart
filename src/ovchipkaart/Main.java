package ovchipkaart;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) {
        Paal paal1 = new Paal(5.00, "Nijmegen", 8.0, 8.0, 0.30);
        Paal paal2 = new Paal(5.00, "Arnhem", 6.0, 7.0, 0.30);

        // Inchecken
        Kaart kaart1 = new Kaart(50.0, LocalDate.of(2027, 1, 1), 1001);
        paal1.checkIn(kaart1);

        // Al ingecheckt
        paal1.checkIn(kaart1);

        // Verlopen kaart
        Kaart kaart2 = new Kaart(50.0, LocalDate.of(2022, 1, 1), 1002);
        paal1.checkIn(kaart2);

        // Onvoldoende saldo
        Kaart kaart3 = new Kaart(1.0, LocalDate.of(2027, 1, 1), 1003);
        paal1.checkIn(kaart3);

        // Uitchecken
        paal2.checkUit(kaart1);

        // Nog niet ingecheckt
        Kaart kaart4 = new Kaart(50.0, LocalDate.of(2027,1,1), 1004);
        paal2.checkUit(kaart4);
    }
}
