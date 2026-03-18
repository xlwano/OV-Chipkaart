package ovchipkaart;

import java.time.LocalDate;

public class Kaart
{
  private double saldo;
  private LocalDate vervalDatum;
  private int kaartnummer;
  private boolean ingecheckt;

  public Kaart(double saldo, LocalDate geldig, int kaartnummer) {
    this.saldo = saldo;
    this.vervalDatum = geldig;
    this.kaartnummer = kaartnummer;
    this.ingecheckt = false;
  }

  public double getSaldo() {return saldo;}

  public void setSaldo(double saldo) {this.saldo = saldo;}

  public void setVervalDatum(LocalDate vervalDatum) { this.vervalDatum = vervalDatum; }

  public LocalDate getVervalDatum() {return vervalDatum;}

  public int getKaartnummer() {return kaartnummer;}

  public boolean isIngecheckt() {return ingecheckt;}

  public void setIngecheckt(boolean ingecheckt) {this.ingecheckt = ingecheckt;}
}

