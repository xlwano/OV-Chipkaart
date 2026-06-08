package ovchipkaart;

public class OvMachine {

    private Ovchipkaart kaart;

    public OvMachine() {

    }

    public void setKaart(Ovchipkaart kaart) {

        this.kaart = kaart;

    }

    public Ovchipkaart getKaart() {

        return kaart;

    }

    public void toonSaldo() {

        if (kaart == null) {

            System.out.println("Geen kaart gescand.");

            return;

        }

        System.out.println("Saldo: " + kaart.getSaldo());

    }

    public void laadOp(double bedrag) {

        if (kaart == null) {

            System.out.println("Geen kaart gescand.");

            return;

        }

        kaart.addSaldo(bedrag);

        System.out.println("Saldo opgeladen met: " + bedrag);

    }

    public void laadOpTot(double doelbedrag) {

        if (kaart == null) {

            System.out.println("Geen kaart gescand.");

            return;

        }

        double verschil = doelbedrag - kaart.getSaldo();

        if (verschil > 0) {

            kaart.addSaldo(verschil);

            System.out.println("Saldo opgeladen naar: " + doelbedrag);

        } else {

            System.out.println("Saldo is al hoger dan " + doelbedrag);

        }

    }

}
