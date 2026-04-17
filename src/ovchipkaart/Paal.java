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
            System.out.println("Kaart " + kaart.getKaartnummer() + " is ingecheckt in " + this.locatie.getNaam());
            System.out.println("Je saldo is: " + kaart.getSaldo());
            System.out.println();
            kaart.setIncheckLocatie(this.locatie);
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
            System.out.println("Kaart " + kaart.getKaartnummer() + " is uitgecheckt in " + this.locatie.getNaam());
            Locatie locatie = kaart.getIncheckLocatie();


            double afstand = this.locatie.berekenAfstand(locatie);
            double kosten = Math.round(((afstand * 10) * this.prijsPerKm) * 100.0) / 100.0;
            kaart.verhoogSaldo(-kosten);
            kaart.setIncheckLocatie(null);
            System.out.println("Je saldo is: " + kaart.getSaldo());
            System.out.println();
            kaart.setIngecheckt(false);
        }
    }
}
