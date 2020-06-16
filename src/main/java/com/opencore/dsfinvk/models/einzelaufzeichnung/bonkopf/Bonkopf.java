package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
import com.opencore.dsfinvk.util.NumericBooleanDeserializer;
import com.opencore.dsfinvk.util.ValidIso3166Alpha3Country;
import com.opencore.dsfinvk.util.ValidVatId;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * Da es sich im Bonkopf im Regelfall nur um die kumulierten Zahlen aus den einzelnen Bonpositionen handelt, ist die o. b. Aufgliederung der einzelnen Zahlen des Bonkopfes auf der Positionsebene erforderlich.
 * Aus den Positionsdaten müssen die Daten des Bonkopfes ermittelt und insbesondere die Aufteilung des Gesamtumsatzes auf die unterschiedlichen Steuersätze nachvollzogen werden können.
 * <p/>
 * Um die Nachvollziehbarkeit gewährleisten zu können, ist eine weitgehend homogene Behandlung der verschiedenen Vorgänge in der DSFinV-K erforderlich.
 * Hierbei muss genügend Raum bleiben, um den Besonderheiten des einzelnen Kassensystems gerecht zu werden.
 * Aus diesem Grund sind nicht nur die Bezeichnungen standardisiert.
 * Auch die Darstellung der besonderen Geschäftsvorfälle ist festgelegt, um eine möglichst reibungslose Prüfung zu gewährleisten.
 * <p/>
 * Im Prinzip handelt es sich bei den Angaben im Bonkopf um ein elektronisches "Rechnungsdoppel", d. h. alle Werte müssen exakt den auf dem Bon aufgedruckten Werten entsprechen.
 * Die Werte sollen nicht aus den Positionen "aufsummiert" werden.
 * Insbesondere die USt-Werte dienen der Prüfbarkeit des richtigen USt-Ausweises (Hinweis auf § 14c UStG).
 * <p/>
 * Zu speichern sind gem. § 14 Abs. 4 UStG getrennt nach USt-Sätzen insbesondere
 * <ul>
 *  <li>Entgelt (netto)</li>
 *  <li>USt-Betrag (Steuerausweis)</li>
 * </ul>
 * Zusätzlich ist in der DSFinV-K auch der Umsatz (brutto) auszuweisen.
 */
public class Bonkopf extends BaseBon {

  public static final String FILENAME = "transactions.csv";

  @NotNull
  @Column("BON_NR")
  private Long bonNr;

  @NotNull
  @Column("BON_TYP")
  private BonTyp bonTyp;

  // TODO: Braucht Validator falls bonTyp = AVSonstige
  @Size(max = 60)
  @Column("BON_NAME")
  private String bonName;

  @Size(max = 50)
  @Column("TERMINAL_ID")
  private String terminalId;

  @JsonDeserialize(using = NumericBooleanDeserializer.class)
  @Column("BON_STORNO")
  private Boolean bonStorno;

  @NotNull
  @Column("BON_START")
  private LocalDateTime bonStart;

  @NotNull
  @Column("BON_ENDE")
  private LocalDateTime bonEnde;

  @Size(max = 50)
  @NotBlank
  @Column("BEDIENER_ID")
  private String bedienerId;

  @Size(max = 50)
  @Column("BEDIENER_NAME")
  private String bedienerName;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column("UMS_BRUTTO")
  private BigDecimal umsBrutto;

  @NotBlank
  @Size(max = 50)
  @Column("KUNDE_NAME")
  private String kundeName;

  @NotBlank
  @Size(max = 50)
  @Column("KUNDE_ID")
  private String kundeId;

  @NotBlank
  @Size(max = 50)
  @Column("KUNDE_TYP")
  private String kundeTyp;

  @Size(max = 60)
  @Column("KUNDE_STRASSE")
  private String kundeStrasse;

  @Size(max = 10)
  @Column("KUNDE_PLZ")
  private String kundePlz;

  @Size(max = 62)
  @Column("KUNDE_ORT")
  private String kundeOrt;

  @Size(max = 3)
  @ValidIso3166Alpha3Country
  @Column("KUNDE_LAND")
  private String kundeLand;

  @ValidVatId
  @Column("KUNDE_USTID")
  private String kundeUstid;

  @Size(max = 255)
  @Column("BON_NOTIZ")
  private String bonNotiz;

  /**
   * Die Bonnummer (oder Belegnummer) ist die von der eingesetzten Kasse vergebene eindeutige Nummerierung innerhalb eines Kassenabschlusses und entspricht der auf dem Bon gedruckten Nummer.
   */
  public Long getBonNr() {
    return bonNr;
  }

  public void setBonNr(Long bonNr) {
    this.bonNr = bonNr;
  }

  /**
   * Der Vorgangstyp (BON_TYP) ordnet und unterteilt alle Vorgänge in zwei Kategorien
   * <ul>
   *   <li>"Beleg" -> zu verbuchen</li>
   *   <li>Andere Vorgänge -> nicht zu verbuchen.</li>
   * </ul>
   * Durch diese Zuordnung wird die Weiterverarbeitung im Kassenabschluss gesteuert.
   */
  public BonTyp getBonTyp() {
    return bonTyp;
  }

  public void setBonTyp(BonTyp bonTyp) {
    this.bonTyp = bonTyp;
  }

  /**
   * Der BON_NAME dient zur weitergehenden Untergliederung der im Vorgangstyp (BON_TYP) enthaltenen Positionen.
   * Beim Vorgangstyp "AVSonstige" ist der BON_NAME zwingend zu füllen.
   */
  public String getBonName() {
    return bonName;
  }

  public void setBonName(String bonName) {
    this.bonName = bonName;
  }

  /**
   * ID des Terminals, mit dem der Vorgang erfasst wurde.
   */
  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

  /**
   * Die Aktivierung (Wert: "1") dieses Feldes kennzeichnet die Stornierung eines einzelnen Beleges.
   * Eine Angabe ist zwingend erforderlich ("0" oder "1").
   * BON_STORNO darf nur auf "1" gesetzt werden, wenn ein kompletter Vorgang sofort und ohne Gegenbuchung "aufgehoben" wird, nicht aber, wenn eine negative Rückbuchung des Vorgangs erfolgt.
   * Vgl. hierzu Ausführungen zu Tz. 4.2.1 und 4.2.2.
   */
  public Boolean getBonStorno() {
    return bonStorno;
  }

  public void setBonStorno(Boolean bonStorno) {
    this.bonStorno = bonStorno;
  }

  /**
   * Der Start-Zeitstempel bezeichnet den Zeitpunkt der ersten Erfassung innerhalb eines Vorgangs.
   * <p/>
   * Inhalt muss folgendem Muster entsprechen: ISO 8601 und RFC3339 (z. B. 2016-09-27T17:00:01)
   */
  public LocalDateTime getBonStart() {
    return bonStart;
  }

  public void setBonStart(LocalDateTime bonStart) {
    this.bonStart = bonStart;
  }

  /**
   * Der Ende-Zeitstempel bezeichnet den Zeitpunkt des Abschlusses eines Vorgangs.
   * Nach § 14 Abs. 4 UStG ist das Ausstellungsdatum eine Pflichtangabe auf der Rechnung.
   * Aus diesem Grund muss der Ende-Zeitstempel für jede Einzelbewegung vorhanden sein.
   * <p/>
   * Inhalt muss folgendem Muster entsprechen: ISO 8601 und RFC3339 (z. B. 2016-09-27T17:00:01)
   */
  public LocalDateTime getBonEnde() {
    return bonEnde;
  }

  public void setBonEnde(LocalDateTime bonEnde) {
    this.bonEnde = bonEnde;
  }

  /**
   * Unternehmensinterne Kennung der Person, die den Vorgang erfasst.
   */
  public String getBedienerId() {
    return bedienerId;
  }

  public void setBedienerId(String bedienerId) {
    this.bedienerId = bedienerId;
  }

  /**
   * Unternehmensinterner Name der Person, die den Vorgang erfasst.
   */
  public String getBedienerName() {
    return bedienerName;
  }

  public void setBedienerName(String bedienerName) {
    this.bedienerName = bedienerName;
  }

  /**
   * Gesamtsumme über alle Geschäftsvorfalltypen, Umsatzsteuersätze und anderen Unterscheidungskriterien eines Vorgangs hinweg.
   */
  public BigDecimal getUmsBrutto() {
    return umsBrutto;
  }

  public void setUmsBrutto(BigDecimal umsBrutto) {
    this.umsBrutto = umsBrutto;
  }

  /**
   * Name des Leistungsempfängers
   * <p/>
   * Hinweis auf § 33 UStDV (Rechnungen über Kleinbeträge).
   */
  public String getKundeName() {
    return kundeName;
  }

  public void setKundeName(String kundeName) {
    this.kundeName = kundeName;
  }

  /**
   * Kundennummer des Leistungsempfängers
   * <p/>
   * Dieses Feld ist auch zur Identifikation des Mitarbeiters zu verwenden, wenn ein Mitarbei ter Leistungsempfänger ist.
   * Einzugeben ist dann die Personalnummer oder ein anderes eindeutiges Identifizierungsmerkmal.
   */
  public String getKundeId() {
    return kundeId;
  }

  public void setKundeId(String kundeId) {
    this.kundeId = kundeId;
  }

  /**
   * Möglichkeit einen Käufer einer bestimmten Gruppe zuzuordnen (z. B. Mitarbeiter).
   */
  public String getKundeTyp() {
    return kundeTyp;
  }

  public void setKundeTyp(String kundeTyp) {
    this.kundeTyp = kundeTyp;
  }

  /**
   * Straße und Hausnummer des Leistungsempfängers.
   */
  public String getKundeStrasse() {
    return kundeStrasse;
  }

  public void setKundeStrasse(String kundeStrasse) {
    this.kundeStrasse = kundeStrasse;
  }

  /**
   * Postleitzahl des Leistungsempfängers.
   */
  public String getKundePlz() {
    return kundePlz;
  }

  public void setKundePlz(String kundePlz) {
    this.kundePlz = kundePlz;
  }

  /**
   * Örtliche Belegenheit des Leistungsempfängers.
   */
  public String getKundeOrt() {
    return kundeOrt;
  }

  public void setKundeOrt(String kundeOrt) {
    this.kundeOrt = kundeOrt;
  }

  /**
   * Ländercode des Leistungsempfängers nach ISO 3166 ALPHA-3 Variante
   * <p/>
   * Weiterführende Informationen finden Sie hier: <a href="https://www.iso.org/iso-3166-country-codes.html">https://www.iso.org/iso-3166-country-codes.html</a>
   */
  public String getKundeLand() {
    return kundeLand;
  }

  public void setKundeLand(String kundeLand) {
    this.kundeLand = kundeLand;
  }

  /**
   * Umsatzsteuer-Identifikationsnummer des Leistungsempfängers
   * <p/>
   * Aufteilung in Länderkürzel (2 Zeichen) und laufende Nummer (13 Zeichen).
   */
  public String getKundeUstid() {
    return kundeUstid;
  }

  public void setKundeUstid(String kundeUstid) {
    this.kundeUstid = kundeUstid;
  }

  /**
   * Dieses Feld kann für zusätzliche Notizen genutzt werden.
   * <p/>
   * Insbesondere bei der Abbildung nicht belegweise darzustellender Vorgänge stellt die BON_NOTIZ das einzige Feld zur genaueren Spezifizierung dar, z. B. bei Bediener-An- meldungen und -Abmeldungen.
   */
  public String getBonNotiz() {
    return bonNotiz;
  }

  public void setBonNotiz(String bonNotiz) {
    this.bonNotiz = bonNotiz;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Bonkopf.class.getSimpleName() + "[", "]")
      .add("bonNr=" + bonNr)
      .add("bonTyp=" + bonTyp)
      .add("bonName='" + bonName + "'")
      .add("terminalId='" + terminalId + "'")
      .add("bonStorno=" + bonStorno)
      .add("bonStart=" + bonStart)
      .add("bonEnde=" + bonEnde)
      .add("bedienerId='" + bedienerId + "'")
      .add("bedienerName='" + bedienerName + "'")
      .add("umsBrutto=" + umsBrutto)
      .add("kundeName='" + kundeName + "'")
      .add("kundeId='" + kundeId + "'")
      .add("kundeTyp='" + kundeTyp + "'")
      .add("kundeStrasse='" + kundeStrasse + "'")
      .add("kundePlz='" + kundePlz + "'")
      .add("kundeOrt='" + kundeOrt + "'")
      .add("kundeLand='" + kundeLand + "'")
      .add("kundeUstid='" + kundeUstid + "'")
      .add("bonNotiz='" + bonNotiz + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
