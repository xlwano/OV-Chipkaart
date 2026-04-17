package ovchipkaart;

import java.time.LocalDate;

public class Kaart
{
  private double saldo;
  private LocalDate vervalDatum;
  private int kaartnummer;
  private boolean ingecheckt = false;
  private Locatie incheckLocatie;


  public Kaart(double saldo, LocalDate geldig, int kaartnummer) {
    this.saldo = saldo;
    this.vervalDatum = geldig;
    this.kaartnummer = kaartnummer;
  }

  public double getSaldo() {return saldo;}

  public void setSaldo(double saldo)
  {
    this.saldo = saldo; // voor opwaarderen tot
  }

  public void verhoogSaldo(double bedrag) {
    saldo += bedrag; // voor opwaarderen met
  }

  public LocalDate getVervalDatum() {return vervalDatum;}

  public int getKaartnummer() {return kaartnummer;}

  public boolean isIngecheckt() {return ingecheckt;}

  public void setIngecheckt(boolean ingecheckt) {this.ingecheckt = ingecheckt;}

  public Locatie getIncheckLocatie() { return incheckLocatie; }

  public void setIncheckLocatie(Locatie locatie) { this.incheckLocatie = locatie; }
}

