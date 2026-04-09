package ovchipkaart;

public class Locatie
{
    private String naam;
    private double x;
    private double y;

    public Locatie(String naam, double x, double y)
    {
        this.naam = naam;
        this.x = x;
        this.y = y;
    }

    public String getNaam() {return naam;}

    public void setNaam(String naam) {this.naam = naam;}

    public double getX() {return x;}

    public void setX(double x) {this.x = x;}

    public double getY() {return y;}

    public void setY(double y) {this.y = y;}
}
