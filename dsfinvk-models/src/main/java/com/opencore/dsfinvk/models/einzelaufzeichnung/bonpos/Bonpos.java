package com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.GvTyp;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * Die Datei Bonpos enthält die einzelnen Positionen eines Vorgangs mit der Zuordnung des korrekten USt-Satzes, der Menge und der Art der gelieferten Gegenstände (§ 14 Abs. 4 UStG; § 22 Abs. 2 UStG i. V. m. § 63 Abs. 3 UStDV).
 * Zusätzlich ist die Berechnungsmethode der ausweisbaren USt ersichtlich (Brutto- oder Nettomethode).
 * Bei der Bruttomethode wird nur der Bruttopreis aufgeführt, bei der Nettomethode der Nettopreis und die darauf entfallende Umsatzsteuer.
 * <p/>
 * Weitere Informationen befinden sich in den Detail-Dateien.
 * <p/>
 * Technischer Name der Datei: {@code lines.csv}
 */
public class Bonpos extends BaseBonpos {

  public static final String FILENAME = "lines.csv";

  @Size(max = 50)
  @Column("GUTSCHEIN_NR")
  private String gutscheinNr;

  @NotBlank
  @Size(max = 255)
  @Column("ARTIKELTEXT")
  private String artikeltext;

  @Size(max = 50)
  @Column("POS_TERMINAL_ID")
  private String posTerminalId;

  // Maximum size: 30 according to spec but we're using an enum here
  @NotNull
  @Column("GV_TYP")
  private GvTyp gvTyp;

  @Size(max = 40)
  @Column("GV_NAME")
  private String gvName;

  @Column("INHAUS")
  private boolean inhaus;

  @Column("P_STORNO")
  private boolean pStorno;

  // TODO: In der Dokumentation steht nicht, dass dieses Feld positiv sein muss, ich nehme es nur an
  @PositiveOrZero
  @Column("AGENTUR_ID")
  private Long agenturId;

  @NotBlank
  @Size(max = 50)
  @Column("ART_NR")
  private String artNr;

  @Size(max = 50)
  @Column("GTIN")
  private String gtin;

  @Size(max = 40)
  @Column("WARENGR_ID")
  private String warengrId;

  @Size(max = 50)
  @Column("WARENGR")
  private String warengr;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 3)
  @Column("MENGE")
  private BigDecimal menge;

  @Digits(integer = Integer.MAX_VALUE, fraction = 3)
  @Column("FAKTOR")
  private BigDecimal faktor;

  @Size(max = 50)
  @Column("EINHEIT")
  private String einheit;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column("STK_BR")
  private BigDecimal stkBr;

  /**
   * Möglichkeit der Erfassung einer Gutscheinnummer bei Einlösung des Gutscheins.
   */
  public String getGutscheinNr() {
    return gutscheinNr;
  }

  public void setGutscheinNr(String gutscheinNr) {
    this.gutscheinNr = gutscheinNr;
  }

  /**
   * Hierbei handelt es sich um die Bezeichnung die pro Position vergeben werden kann.
   * Dabei kann es sich um Artikelnamen oder Bezeichnungen für Rabatte handeln (z. B. Happy Hour).
   */
  public String getArtikeltext() {
    return artikeltext;
  }

  public void setArtikeltext(String artikeltext) {
    this.artikeltext = artikeltext;
  }

  /**
   * ID der Slave-Kasse (Terminal), an der die Position (Line) erfasst wird.
   */
  public String getPosTerminalId() {
    return posTerminalId;
  }

  public void setPosTerminalId(String posTerminalId) {
    this.posTerminalId = posTerminalId;
  }

  /**
   * Zuordnung der Position zu einem festdefinierten Geschäftsvorfalltypen.
   */
  public GvTyp getGvTyp() {
    return gvTyp;
  }

  public void setGvTyp(GvTyp gvTyp) {
    this.gvTyp = gvTyp;
  }

  /**
   * Zur Differenzierung und weitergehenden Untergliederung von Geschäftsvorfällen können hier zusätzliche Beschreibungen definiert werden.
   * <p/>
   * Die Angaben zu den Geschäftsvorfalltypen sind mit den vorgegebenen Werten ({@link #getGvTyp() GV_TYP}) zu füllen, um eine automatisierte Weiterverarbeitung und Auswertung zu er- möglichen.
   * Durch die zusätzliche Angabe unter „GV_NAME“ können die Geschäftsvorfälle untergliedert werden.
   * <p/>
   * Die weitergehende Untergliederung wird – in Abhängigkeit vom verwendeten Kassensys- tem – vom Kassenhersteller, dem Kassenhändler oder dem Unternehmer selbst durch- geführt.
   * <p/>
   * Der große Vorteil der Untergliederung (GV_NAME) liegt in der inhaltlichen Tiefe.
   * Diese erlaubt es, weiterverarbeitende Prozesse besser zu automatisieren bzw. die inhaltliche Aussagekraft weiterer Auswertungen zu erhöhen.
   */
  public String getGvName() {
    return gvName;
  }

  public void setGvName(String gvName) {
    this.gvName = gvName;
  }

  /**
   * Bei Aktivierung des Feldes handelt es sich um einen „Inhausverkauf“, bei Deaktivierung um einen „Außerhausverkauf“
   */
  public boolean getInhaus() {
    return inhaus;
  }

  public void setInhaus(boolean inhaus) {
    this.inhaus = inhaus;
  }

  /**
   * Positionsstorno-Kennzeichnung.
   * Bei Aktivierung des Feldes handelt es sich um eine (sofort während der Erfassung) stornierte Position.
   */
  public boolean getpStorno() {
    return pStorno;
  }

  public void setpStorno(boolean pStorno) {
    this.pStorno = pStorno;
  }

  /**
   * Zuordnung einer Position zu einer Agentur.
   * <p/>
   * Sofern der Geschäftsvorfall keiner Agentur zuzuordnen ist, ist das Feld mit "false" zu befüllen.
   */
  public @PositiveOrZero Long getAgenturId() {
    return agenturId;
  }

  public void setAgenturId(@PositiveOrZero Long agenturId) {
    this.agenturId = agenturId;
  }

  /**
   * Artikelnummer der einzelnen Position.
   */
  public String getArtNr() {
    return artNr;
  }

  public void setArtNr(String artNr) {
    this.artNr = artNr;
  }

  /**
   * GTIN (Global Trade Item Number) des Artikels
   * <p/>
   * Die Global Trade Item Number (GTIN) ist eine internationale, unverwechselbare Nummer zur Kennzeichnung von Produkten.
   * Die früher übliche Bezeichnung European Article Number (EAN) wurde 2009 von der GTIN abgelöst.
   */
  public String getGtin() {
    return gtin;
  }

  public void setGtin(String gtin) {
    this.gtin = gtin;
  }

  /**
   * Nummer der Warengruppe
   */
  public String getWarengrId() {
    return warengrId;
  }

  public void setWarengrId(String warengrId) {
    this.warengrId = warengrId;
  }

  /**
   * Name der Warengruppe
   */
  public String getWarengr() {
    return warengr;
  }

  public void setWarengr(String warengr) {
    this.warengr = warengr;
  }

  /**
   * Mengenangabe der einzelnen Position
   * <p/>
   * Beispiel: Fleisch kostet z. B. 5 € pro 1,5 kg, verkaufte Menge: 2 kg. Mengenangabe der einzelnen Position: 2.000
   */
  public BigDecimal getMenge() {
    return menge;
  }

  public void setMenge(BigDecimal menge) {
    this.menge = menge;
  }

  /**
   * Referenzmenge des Preises
   * <p/>
   * Beispiel: Fleisch kostet z. B. 5 € pro 1,5 kg, verkaufte Menge: 2 kg. Referenzmenge: 1.500
   */
  public BigDecimal getFaktor() {
    return faktor;
  }

  public void setFaktor(BigDecimal faktor) {
    this.faktor = faktor;
  }

  /**
   * Maßeinheit des Artikels
   * <p/>
   * Ist das Feld Maßeinheit leer, so gilt automatisch die Einheit Stück
   * <p/>
   * Beispiel: Fleisch kostet z. B. 5 € pro 1,5 kg, verkaufte Menge: 2 kg. Maßeinheit: kg.
   */
  public String getEinheit() {
    return einheit;
  }

  public void setEinheit(String einheit) {
    this.einheit = einheit;
  }

  /**
   * (Grund)Preis pro Maßeinheit in der Basiswährung der Kasse
   * <p/>
   * Beispiel: Fleisch kostet z. B. 5 € pro 1,5 kg, verkaufte Menge: 2 kg. Preis pro Maßeinheit: 5,00.
   */
  public BigDecimal getStkBr() {
    return stkBr;
  }

  public void setStkBr(BigDecimal stkBr) {
    this.stkBr = stkBr;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Bonpos.class.getSimpleName() + "[", "]")
      .add("gutscheinNr='" + gutscheinNr + "'")
      .add("artikeltext='" + artikeltext + "'")
      .add("posTerminalId='" + posTerminalId + "'")
      .add("gvTyp=" + gvTyp)
      .add("gvName='" + gvName + "'")
      .add("inhaus=" + inhaus)
      .add("pStorno=" + pStorno)
      .add("agenturId=" + agenturId)
      .add("artNr='" + artNr + "'")
      .add("gtin='" + gtin + "'")
      .add("warengrId='" + warengrId + "'")
      .add("warengr='" + warengr + "'")
      .add("menge=" + menge)
      .add("faktor=" + faktor)
      .add("einheit='" + einheit + "'")
      .add("stkBr=" + stkBr)
      .add("posZeile='" + getPosZeile() + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
