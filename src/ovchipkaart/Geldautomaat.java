package ovchipkaart;

import java.time.LocalDate;

public class Geldautomaat
{

    private double maximumBedrag;

    public Geldautomaat(double maximumBedrag)
    {
        this.maximumBedrag = maximumBedrag;
    }

    public void opwaarderenMet(Kaart kaart, double bedrag)
    {

        if (kaart.getVervalDatum().isBefore(LocalDate.now()))
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is verlopen. Opladen niet mogelijk.");
            System.out.println();
            return;
        }
        if (bedrag <= 0)
        {
            System.out.println("Bedrag moet groter zijn dan 0.");
            System.out.println();
            return;
        }
        if (bedrag > maximumBedrag)
        {
            System.out.println("Bedrag van " + bedrag + " overschrijdt het maximum van " + maximumBedrag + ".");
            System.out.println();
            return;
        }

        kaart.setSaldo(bedrag);
        System.out.println("Kaart " + kaart.getKaartnummer() + " is opgeladen met " + bedrag + " euro.");
        System.out.println("Nieuw saldo: " + kaart.getSaldo());
        System.out.println();
    }


        public void opwaarderenTot(Kaart kaart, double bedrag) {

            if (kaart.getVervalDatum().isBefore(LocalDate.now()))
            {
                System.out.println("Kaart " + kaart.getKaartnummer() + " is verlopen. Opladen niet mogelijk.");
                System.out.println();
                return;
            }
            if (bedrag <= 0)
            {
                System.out.println("Bedrag moet groter zijn dan 0.");
                System.out.println();
                return;
            }
            if (bedrag > maximumBedrag)
            {
                System.out.println("Bedrag van " + bedrag + " overschrijdt het maximum van " + maximumBedrag + ".");
                System.out.println();
                return;
            }

            if (bedrag <= kaart.getSaldo()) {
                System.out.println("Bedrag moet hoger zijn dan huidige bedrag.");
                System.out.println();
                return;
            }

            kaart.setSaldo(bedrag);
            System.out.println("Kaart " + kaart.getKaartnummer() + " is opgeladen tot " + kaart.getSaldo() + " euro.");
            System.out.println("Nieuw saldo: " + kaart.getSaldo());
            System.out.println();
    }
}