package ovchipkaart;
import java.time.LocalDate;
public class Paal {
    private double instaptarief;
    private Locatie locatie;
    private double tariefperkm;

    public Paal(double instaptarief, Locatie locatie, double tariefperkm) {
        this.instaptarief = instaptarief;
        this.locatie = locatie;
        this.tariefperkm = tariefperkm;
    }

    public double getInstaptarief() { return instaptarief; }
    public Locatie getLocatie() { return locatie; }
    public double getTariefperkm() { return tariefperkm; }

    public void checkIn(Ovchipkaart kaart) {
        if (kaart.getVervaldatum().isBefore(LocalDate.now())) {
            System.out.println("inchecken mislukt, datum is verlopen");
            return;
        }
        if (kaart.isIngecheckt()) {
            System.out.println("inchecken mislukt, al ingecheckt");
            return;
        }
        if (kaart.getSaldo() < instaptarief) {
            System.out.println("inchecken mislukt, onvoldoende saldo");
            return;
        }
        kaart.checkIn(this.locatie, instaptarief);
        System.out.println("inchecken voldaan");
    }

    public void checkOut(Ovchipkaart kaart) {
        if (!kaart.isIngecheckt()) {
            System.out.println("Uitchecken mislukt: niet ingecheckt.");
            return;
        }
        double kosten = locatie.afstandBerekenen(kaart.getIncheckLocatie()) * tariefperkm;
        kaart.checkOut(kosten);
        System.out.println("Uitchecken geslaagd. Kosten: " + kosten);
    }
}