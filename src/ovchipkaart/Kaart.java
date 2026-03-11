package ovchipkaart;

import java.time.LocalDate;

public class Kaart
{
  private double saldo;
  private LocalDate geldig;
  private int kaartnummer;
  private boolean ingecheckt;

  public Kaart(double saldo, LocalDate geldig, int kaartnummer) {
    this.saldo = saldo;
    this.geldig = geldig;
    this.kaartnummer = kaartnummer;
    this.ingecheckt = false;
  }

  public double getSaldo() {return saldo;}

  public void setSaldo(double saldo) {this.saldo = saldo;}

  public void setGeldig(LocalDate geldig) { this.geldig = geldig; }

  public boolean isIngecheckt() {return ingecheckt;}
  }

  