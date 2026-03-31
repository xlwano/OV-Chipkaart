package ovchipkaart;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) {
        Paal paal = new Paal(5.00, );

        // Normaal geval
        Kaart kaart1 = new Kaart(10.00, LocalDate.of(2027, 1, 1), 1001);
        paal.checkIn(kaart1);

        // Al ingecheckt
        paal.checkIn(kaart1);

        // Verlopen kaart
        Kaart kaart2 = new Kaart(10.00, LocalDate.of(2023, 1, 1), 1002);
        paal.checkIn(kaart2);

        // Onvoldoende saldo
        Kaart kaart3 = new Kaart(1.00, LocalDate.of(2027, 1, 1), 1003);
        paal.checkIn(kaart3);
    }
}
