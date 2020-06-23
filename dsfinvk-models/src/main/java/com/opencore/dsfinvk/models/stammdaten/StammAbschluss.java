package com.opencore.dsfinvk.models.stammdaten;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.ValidIso3166Alpha3Country;
import com.opencore.dsfinvk.util.ValidStammAbschluss;
import com.opencore.dsfinvk.util.ValidVatId;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

/**
 * Daten des Kassenabschlusses, dazu gehören Datum, Uhrzeit und Start- sowie End-ID.
 * Ebenfalls werden die Unternehmensdaten inkl. Steuernummer bzw. Umsatzsteuer-Identifikationsnummer hier gespeichert.
 * <p/>
 * Technischer Name der Datei: {@code cashpointclosing.csv}
 */
@ValidStammAbschluss
public class StammAbschluss extends BaseModel {

  public static final String FILENAME = "cashpointclosing.csv";

  @PastOrPresent
  @Column(value = "Z_BUCHUNGSTAG", type = DataType.AlphaNumeric)
  private LocalDate zBuchungstag;

  @Pattern(regexp = "2\\.[0,1]")
  @Size(max = 10)
  @NotBlank
  @Column(value = "TAXONOMIE_VERSION", type = DataType.AlphaNumeric)
  private String taxonomieVersion;

  @Size(max = 40)
  @NotBlank
  @Column(value = "Z_START_ID", type = DataType.AlphaNumeric)
  private String zStartId;

  @Size(max = 40)
  @NotBlank
  @Column(value = "Z_ENDE_ID", type = DataType.AlphaNumeric)
  private String zEndeId;

  @Size(max = 60)
  @NotBlank
  @Column(value = "NAME", type = DataType.AlphaNumeric)
  private String name;

  @Size(max = 60)
  @NotBlank
  @Column(value = "STRASSE", type = DataType.AlphaNumeric)
  private String strasse;

  @Size(max = 10)
  @NotBlank
  @Column(value = "PLZ", type = DataType.AlphaNumeric)
  private String plz;

  @Size(max = 62)
  @NotBlank
  @Column(value = "ORT", type = DataType.AlphaNumeric)
  private String ort;

  @NotBlank
  @ValidIso3166Alpha3Country
  @Column(value = "LAND", type = DataType.AlphaNumeric)
  private String land;

  @Column(value = "STNR", type = DataType.AlphaNumeric)
  private String stnr;

  @ValidVatId
  @Column(value = "USTID", type = DataType.AlphaNumeric)
  private String ustid;

  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column(value = "Z_SE_ZAHLUNGEN", type = DataType.Numeric)
  private BigDecimal zSeZahlungen;

  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column(value = "Z_SE_BARZAHLUNGEN", type = DataType.Numeric)
  private BigDecimal zSeBarzahlungen;

  /**
   * Das Buchungsdatum kann angegeben werden, wenn dieses vom Erstellungstag des Kassenabschlusses abweicht.
   * <p/>
   * Inhalt muss folgendem Muster entsprechen: ISO 8601 und RFC3339 (z. B. 2016-09-27)
   */
  public LocalDate getzBuchungstag() {
    return zBuchungstag;
  }

  public void setzBuchungstag(LocalDate zBuchungstag) {
    this.zBuchungstag = zBuchungstag;
  }

  /**
   * Die für den erstellten Kassenabschluss verwendete Version der DSFinV-K.
   */
  public String getTaxonomieVersion() {
    return taxonomieVersion;
  }

  public void setTaxonomieVersion(String taxonomieVersion) {
    this.taxonomieVersion = taxonomieVersion;
  }

  /**
   * Start-Vorgangs-ID und damit Vorgangs-ID des ersten Vorgangs, der in den Kassenabschluss einfließt.
   */
  public String getzStartId() {
    return zStartId;
  }

  public void setzStartId(String zStartId) {
    this.zStartId = zStartId;
  }

  /**
   * Ende-Vorgangs-ID und damit Vorgangs-ID des letzten Vorgangs, der in den Kassenabschluss einfließt.
   */
  public String getzEndeId() {
    return zEndeId;
  }

  public void setzEndeId(String zEndeId) {
    this.zEndeId = zEndeId;
  }

  /**
   * Hier ist der aktuelle offizielle Unternehmensname anzugeben.
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Straße und Hausnummer des Unternehmens.
   */
  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  /**
   * Postleitzahl des Unternehmens.
   */
  public String getPlz() {
    return plz;
  }

  public void setPlz(String plz) {
    this.plz = plz;
  }

  /**
   * Örtliche Begebenheit des Unternehmens.
   */
  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  /**
   * Ländercode des Unternehmens nach ISO 3166 ALPHA-3 Variante
   * Ausprägungen / Enum: z. B. „DEU“, „DNK“, „FRA“, „AUT“, „SWE“
   * <p/>
   * Weiterführende Informationen finden Sie hier: <a href="https://www.iso.org/iso-3166-country-codes.html">https://www.iso.org/iso-3166-country-codes.html</a>
   */
  public String getLand() {
    return land;
  }

  public void setLand(String land) {
    this.land = land;
  }

  /**
   * Steuernummer des Unternehmens.
   * <p/>
   * Es muss entweder die Steuernummer oder die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Unternehmens angegeben werden (§ 14 Abs. 4 Nr. 2 UStG).
   */
  public String getStnr() {
    return stnr;
  }

  public void setStnr(String stnr) {
    this.stnr = stnr;
  }

  /**
   * Hier handelt es sich um die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Unternehmens.
   * <p/>
   * Es muss entweder die Steuernummer oder die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Unternehmens angegeben werden (§ 14 Abs. 4 Nr. 2 UStG).
   * Aufteilung in Länderkürzel (2 Zeichen) und laufende Nummer (13 Zeichen).
   */
  public String getUstid() {
    return ustid;
  }

  public void setUstid(String ustid) {
    this.ustid = ustid;
  }

  /**
   * Summe der Beträge aller Zahlarten
   */
  public BigDecimal getzSeZahlungen() {
    return zSeZahlungen;
  }

  public void setzSeZahlungen(BigDecimal zSeZahlungen) {
    this.zSeZahlungen = zSeZahlungen;
  }

  /**
   * In die Basiswährung der Kasse umgerechnete Summe der Zahlart "Bar".
   */
  public BigDecimal getzSeBarzahlungen() {
    return zSeBarzahlungen;
  }

  public void setzSeBarzahlungen(BigDecimal zSeBarzahlungen) {
    this.zSeBarzahlungen = zSeBarzahlungen;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammAbschluss.class.getSimpleName() + "[", "]")
      .add("zBuchungstag=" + zBuchungstag)
      .add("taxonomieVersion='" + taxonomieVersion + "'")
      .add("zStartId='" + zStartId + "'")
      .add("zEndeId='" + zEndeId + "'")
      .add("name='" + name + "'")
      .add("strasse='" + strasse + "'")
      .add("plz='" + plz + "'")
      .add("ort='" + ort + "'")
      .add("land='" + land + "'")
      .add("stnr='" + stnr + "'")
      .add("ustid='" + ustid + "'")
      .add("zSeZahlungen=" + zSeZahlungen)
      .add("zSeBarzahlungen=" + zSeBarzahlungen)
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }
}
