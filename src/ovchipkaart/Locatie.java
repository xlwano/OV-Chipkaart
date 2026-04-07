package ovchipkaart;

public class Locatie
{
    private static String naam;
    private static double x;
    private static double y;

    public Locatie(String naam, double x, double y)
    {
        this.naam = naam;
        this.x = x;
        this.y = y;
    }

    public static String getNaam() {return naam;}

    public void setNaam() {this.naam = naam;}

    public static double getX() {return x;}

    public void setX() {this.x = x;}

    public static double getY() {return y;}

    public void setY() {this.y = y;}
}
