package ovchipkaart;

import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        Locatie nijmegen = new Locatie("Nijmegen", 8.0, 8.0);
        Locatie arnhem = new Locatie("Arnhem", 6.0, 7.0);
        Locatie utrecht = new Locatie("Utrecht", 5.0, 9.0);
        Paal paal1 = new Paal(5.00, nijmegen, 0.30);
        Paal paal2 = new Paal(5.00, arnhem, 0.30);
        Paal paal3 = new Paal(5.00, utrecht, 0.30);
        Geldautomaat geldautomaat = new Geldautomaat(150.00, false);
        Kaart kaart = new Kaart(50.0, LocalDate.of(2027, 1, 1), 1001);

        while (!geldautomaat.isGestopt())
        {
            System.out.println("Wat wil je doen?");
            System.out.println("1. reizen");
            System.out.println("2. saldo bekijken");
            System.out.println("3. opwaarderen tot");
            System.out.println("4. opwaarderen met");
            System.out.println("5. storten");
            System.out.println("6. stoppen");
            System.out.println("");

            int userInput = sc.nextInt();

            if (userInput == 1)
            {
                if (!kaart.isIngecheckt())
                {
                    System.out.println("Waar wil je inchecken?");
                    System.out.println("1. Nijmegen");
                    System.out.println("2. Arnhem");
                    System.out.println("3. Utrecht");
                    System.out.println("");

                    int incheckKeuze = sc.nextInt();

                    if (incheckKeuze == 1)
                    {
                        paal1.checkIn(kaart);
                        System.out.println("");

                        System.out.println("Waar wil je uitchecken?");
                        System.out.println("1. Arnhem");
                        System.out.println("2. Utrecht");
                        System.out.println("");

                        int uitcheckKeuze = sc.nextInt();

                        if (uitcheckKeuze == 1)
                        {
                            paal2.checkUit(kaart);
                            System.out.println("");
                        }
                        else if (uitcheckKeuze == 2)
                        {
                            paal3.checkUit(kaart);
                            System.out.println("");
                        }
                        else
                        {
                            System.out.println("Ongeldige waarde, probeer opnieuw.");
                        }
                    }


                    else if (incheckKeuze == 2)
                    {
                        paal2.checkIn(kaart);
                        System.out.println("");

                        System.out.println("Waar wil je uitchecken?");
                        System.out.println("1. Nijmegen");
                        System.out.println("2. Utrecht");
                        System.out.println("");

                        int uitcheckKeuze = sc.nextInt();

                        if (uitcheckKeuze == 1)
                        {
                            paal1.checkUit(kaart);
                            System.out.println("");
                        }
                        else if (uitcheckKeuze == 2)
                        {
                            paal3.checkUit(kaart);
                            System.out.println("");
                        }
                        else
                        {
                            System.out.println("Ongeldige waarde, probeer opnieuw.");
                        }
                    }

                    else if (incheckKeuze == 3)
                    {
                        paal3.checkIn(kaart);
                        System.out.println("");

                        System.out.println("Waar wil je uitchecken?");
                        System.out.println("1. Arnhem");
                        System.out.println("2. Nijmegen");
                        System.out.println("");

                        int uitcheckKeuze = sc.nextInt();

                        if (uitcheckKeuze == 1)
                        {
                            paal2.checkUit(kaart);
                            System.out.println("");
                        }
                        else if (uitcheckKeuze == 2)
                        {
                            paal1.checkUit(kaart);
                            System.out.println("");
                        }
                        else
                        {
                            System.out.println("Ongeldige waarde, probeer opnieuw.");
                        }
                    } else {
                        System.out.println("Ongeldige waarde, probeer opnieuw");
                    }
                }

            }

            else if (userInput == 2)
            {
                geldautomaat.controleerSaldo(kaart);
                System.out.println("");
            }

            else if (userInput == 3)
            {
                System.out.println("Tot hoeveel wilt u opwaarderen? (maximaal €150) ");
                double bedrag = sc.nextDouble();
                geldautomaat.opwaarderenTot(kaart, bedrag);

            }

            else if (userInput == 4)
            {
                System.out.println("Hoeveel euro wilt u opwaarderen? (maximaal €150) ");
                double bedrag = sc.nextDouble();
                geldautomaat.opwaarderenMet(kaart, bedrag);
            }


            else if (userInput == 5) {
                System.out.println("Hoeveel euro wilt u storten?");
                double bedrag = sc.nextDouble();
                geldautomaat.storten(kaart, bedrag);
            }

            else if (userInput == 6)
            {
                geldautomaat.stoppen();


            }
            else {
                System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
            System.out.println();

        }
    }
}
