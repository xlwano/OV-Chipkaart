package ovchipkaart;

import java.time.LocalDate;

public class Paal
{
    private double instaptarief;
    private String locatie;
    private double x;
    private double y;
    private double prijsPerKm;


    public Paal(double instaptarief, String locatie, double x, double y, double prijsPerKm)
    {
        this.instaptarief = instaptarief;
        this.locatie = locatie;
        this.x = x;
        this.y = y;
        this.prijsPerKm = prijsPerKm;
    }

    public void checkIn(Kaart kaart)
    {
        if (kaart.isIngecheckt())
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is al ingecheckt.");
            System.out.println();
            return;
        }
        if (kaart.getVervalDatum().isBefore(LocalDate.now()))
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is verlopen.");
            System.out.println();
            return;
        }
        if (kaart.getSaldo() < instaptarief)
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " heeft onvoldoende saldo.");
            System.out.println("Je saldo is: " + kaart.getSaldo());
            System.out.println();
            return;
        }
        else
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is ingechekt in " + locatie);
            System.out.println("Je saldo is: " + kaart.getSaldo());
            System.out.println();
            kaart.setIncheckPaal(this);
            kaart.setIngecheckt(true);
        }
    }

    public void checkUit(Kaart kaart)
    {
        if (!kaart.isIngecheckt())
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is niet ingecheckt.");
            System.out.println();
            return;
        }
        else
        {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is uitgecheckt in " + locatie);
            Paal incheckPaal = kaart.getIncheckPaal();

            double deltaX = this.x - incheckPaal.x;
            double deltaY = this.y - incheckPaal.y;
            double afstand = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

            double kosten = (afstand * 10) * this.prijsPerKm;
            kaart.setSaldo(-kosten);
            kaart.setIncheckPaal(null);
            System.out.println("Je saldo is: " + kaart.getSaldo());
            System.out.println();
            kaart.setIngecheckt(false);
        }
    }
}
