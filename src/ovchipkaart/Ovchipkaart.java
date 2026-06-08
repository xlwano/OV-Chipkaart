package ovchipkaart;
import java.time.LocalDate;
public class Ovchipkaart {
  private double saldo;
  private LocalDate vervaldatum;
  private int kaartnummer;
  private boolean ingecheckt;
  private Locatie incheckLocatie;
  private double incheckTarief;

  public Ovchipkaart(int kaartnummer) {
    this.kaartnummer = kaartnummer;
    this.saldo = 0.0;
    this.ingecheckt = false;
    this.vervaldatum = LocalDate.now().plusYears(5);
  }

  public void addSaldo(double bedrag) {
    saldo += bedrag;
  }

  public double getSaldo() {
    return saldo;
  }

  public boolean isIngecheckt() {
    return ingecheckt;
  }

  public int getKaartnummer() {
    return kaartnummer;
  }

  public LocalDate getVervaldatum() {
    return vervaldatum;
  }

  public Locatie getIncheckLocatie() {
    return incheckLocatie;
  }

  public void checkIn(Locatie locatie, double instapTarief) {
    this.ingecheckt = true;
    this.incheckLocatie = locatie;
    this.incheckTarief = instapTarief;
    this.saldo -= instapTarief;
  }

  public void checkOut(double kosten) {
    this.saldo -= kosten;
    this.ingecheckt = false;
    this.incheckLocatie = null;
    this.incheckTarief = 0;
  }
}