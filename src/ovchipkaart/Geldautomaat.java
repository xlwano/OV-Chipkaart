package ovchipkaart;

import java.time.LocalDate;

public class Geldautomaat
{

    private double maximumBedrag;
    private boolean stop;

    public Geldautomaat(double maximumBedrag, boolean stop)
    {
        this.maximumBedrag = maximumBedrag;
        this.stop = stop;
    }


    public void stoppen() {
            stop = true;

            }

            public boolean isGestopt() { return stop;}

    public void controleerSaldo(Kaart kaart) {

        if (kaart.getVervalDatum().isBefore(LocalDate.now()))
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is verlopen. Opladen niet mogelijk.");
            System.out.println();
            return;
        }
        else {
            System.out.println("Uw huidige saldo is: " + kaart.getSaldo());
        }

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

        kaart.verhoogSaldo(bedrag);
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
    public void storten(Kaart kaart, double bedrag) {
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

        if (bedrag > kaart.getSaldo()) {
            System.out.println("Bedrag moet lager zijn dan huidige bedrag.");
            System.out.println();
            return;
        }
    }


}