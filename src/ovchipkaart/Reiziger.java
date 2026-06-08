package ovchipkaart;

public class Reiziger {

    private String naam;
    private Ovchipkaart kaart;

    public Reiziger(Ovchipkaart kaart , String naam) {
        this.kaart = kaart;
        this.naam = naam;
    }
    public String getNaam() {
        return naam;
    }
    public Ovchipkaart getKaart() {
        return kaart;
    }
    public void checkIn(Paal paal) {
        paal.checkIn(kaart);
    }
    public void checkOut (Paal paal) {
        paal.checkOut(kaart);
    }
}