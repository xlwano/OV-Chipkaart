package ovchipkaart;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) {
        Inchecken poortje = new Inchecken(5.00);

        // Normaal geval
        Kaart kaart1 = new Kaart(10.00, LocalDate.of(2027, 1, 1), 1001);
        poortje.checkIn(kaart1);

        // Al ingecheckt
        poortje.checkIn(kaart1);

        // Verlopen kaart
        Kaart kaart2 = new Kaart(10.00, LocalDate.of(2023, 1, 1), 1002);
        poortje.checkIn(kaart2);

        // Onvoldoende saldo
        Kaart kaart3 = new Kaart(1.00, LocalDate.of(2027, 1, 1), 1003);
        poortje.checkIn(kaart3);
    }
}
