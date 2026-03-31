package ovchipkaart;

public class Paal
{
    private double instaptarief;
    private String locatie;
    private double x;
    private double y;
    private double prijsPerKm;



    public Paal(double instaptarief, String locatie, double x, double y, double prijsPerKm){
        this.instaptarief = instaptarief;
        this.locatie = locatie;
        this.x = x;
        this.y = y;
        this.prijsPerKm = prijsPerKm;
    }
}
