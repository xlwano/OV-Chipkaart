package ovchipkaart;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) {
        inchecken poortje = new inchecken(1.50);

        // Normaal geval
        Kaart kaart1 = new Kaart(10.00, LocalDate.of(2027, 1, 1), 1001);
        System.out.println("Kaart 1: normaal");
        poortje.checkIn(kaart1);

        // Al ingecheckt
        System.out.println("Kaart 1: opnieuw inchecken ");
        poortje.checkIn(kaart1);

        // Verlopen kaart
        Kaart kaart2 = new Kaart(10.00, LocalDate.of(2023, 1, 1), 1002);
        System.out.println("Kaart 2: verlopen");
        poortje.checkIn(kaart2);

        // Onvoldoende saldo
        Kaart kaart3 = new Kaart(1.00, LocalDate.of(2027, 1, 1), 1003);
        System.out.println("Kaart 3: te weinig saldo");
        poortje.checkIn(kaart3);
    }
}
