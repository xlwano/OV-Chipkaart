package ovchipkaart;

import java.time.LocalDate;

public class inchecken
{
    double instaptarief;

    public inchecken(double instaptarief) {
        this.instaptarief = instaptarief;
    }

    public boolean checkIn(Kaart kaart) {
        if (kaart.isIngecheckt()) {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is al ingecheckt.");
            return false;
        }
        if (kaart.getVervalDatum().isBefore(LocalDate.now())) {
            System.out.println("Kaart " + kaart.getKaartnummer() + " is verlopen.");
            return false;
        }
        if (kaart.getSaldo() < instaptarief) {
            System.out.println(kaart.getKaartnummer() + "Onvoldoende saldo. Huidig saldo: " + kaart.getSaldo());
            return false;
        }

        kaart.setSaldo(kaart.getSaldo() - instaptarief);
        kaart.setIngecheckt(true);
        System.out.println("Ingecheckt! Nieuw saldo: " + kaart.getSaldo());
        return true;
    }
}
