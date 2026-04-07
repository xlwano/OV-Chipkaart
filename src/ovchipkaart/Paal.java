package ovchipkaart;

import java.time.LocalDate;

public class Paal
{
    private double instaptarief;
    private Locatie locatie;
    private double prijsPerKm;


    public Paal(double instaptarief, Locatie locatie, double prijsPerKm)
    {
        this.instaptarief = instaptarief;
        this.locatie = locatie;
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
            System.out.println("Kaart " + kaart.getKaartnummer() + " is ingechekt in " + Locatie.getNaam());
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
            System.out.println("Kaart " + kaart.getKaartnummer() + " is uitgecheckt in " + Locatie.getNaam());
            Paal incheckPaal = kaart.getIncheckPaal();

            double deltaX = this.locatie.getX() - Locatie.getX();
            double deltaY = this.locatie.getY() - Locatie.getY();
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
