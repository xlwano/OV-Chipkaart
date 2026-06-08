package ovchipkaart;
import java.util.Scanner;
public class Driver
{

    public static void main(String[] args) {
        Paal paal1 = new Paal(2.0, new Locatie("Nijmegen", 1.6, 2.3), 1.5);
        Paal paal2 = new Paal(2.0, new Locatie("Arnhem", 3.0, 3.0), 1.5);

        Ovchipkaart kaart = new Ovchipkaart(3528);
        OvMachine machine = new OvMachine();
        machine.setKaart(kaart);

        Reiziger reiziger = new Reiziger(kaart, "Issam");
        Scanner scanner = new Scanner(System.in);

        int keuze = 0;
        while (keuze != 4) {
            System.out.println("1. Saldo bekijken");
            System.out.println("2. Saldo opladen (bedrag erbij)");
            System.out.println("3. Saldo opladen (tot bedrag)");
            System.out.println("4. Doorgaan naar inchecken");
            keuze = scanner.nextInt();

            if (keuze == 1) {
                machine.toonSaldo();
            } else if (keuze == 2) {
                System.out.println("Hoeveel wil je opladen?");
                double bedrag = scanner.nextDouble();
                machine.laadOp(bedrag);
            } else if (keuze == 3) {
                System.out.println("Tot hoeveel wil je opladen?");
                double doelbedrag = scanner.nextDouble();
                machine.laadOpTot(doelbedrag);
            } else if (keuze != 4) {
                System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }

        reiziger.checkIn(paal1);
        System.out.println("Saldo na inchecken: " + kaart.getSaldo());
        reiziger.checkOut(paal2);
        System.out.println("Saldo na uitchecken: " + kaart.getSaldo());

        scanner.close();
    }
}