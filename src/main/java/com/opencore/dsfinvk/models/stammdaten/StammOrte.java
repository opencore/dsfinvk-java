package com.opencore.dsfinvk.models.stammdaten;

import java.util.StringJoiner;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.ValidIso3166Alpha3Country;
import com.opencore.dsfinvk.util.ValidVatId;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * Namen und Orte der einzelnen Betriebsstätten mit Kassen.
 * <p/>
 * Die Felder stellen den Abrechnungsort der Kasse dar.
 * Der Abrechnungsort kann z. B. eine Abteilungsbezeichnung, eine Filiale oder ein variabler Punkt sein.
 * <p/>
 * Technischer Name der Datei: {@code location.csv}
 */
public class StammOrte extends BaseModel {

  public static final String FILENAME = "location.csv";

  @NotBlank
  @Size(max = 60)
  @Column("LOC_NAME")
  private String locName;

  @NotBlank
  @Size(max = 60)
  @Column("LOC_STRASSE")
  private String locStrasse;

  @NotBlank
  @Size(max = 10)
  @Column("LOC_PLZ")
  private String locPlz;

  @NotBlank
  @Size(max = 62)
  @Column("LOC_ORT")
  private String locOrt;

  @NotBlank
  @ValidIso3166Alpha3Country
  @Column("LOC_LAND")
  private String locLand;

  @Size(max = 15)
  @ValidVatId
  @Column("LOC_USTID")
  private String locUstid;

  /**
   * Name der Betriebsstätte/ Filiale
   */
  public String getLocName() {
    return locName;
  }

  public void setLocName(String locName) {
    this.locName = locName;
  }

  /**
   * Straße und Hausnummer der Betriebsstätte/Filiale
   */
  public String getLocStrasse() {
    return locStrasse;
  }

  public void setLocStrasse(String locStrasse) {
    this.locStrasse = locStrasse;
  }

  /**
   * Postleitzahl der Betriebsstätte/Filiale
   */
  public String getLocPlz() {
    return locPlz;
  }

  public void setLocPlz(String locPlz) {
    this.locPlz = locPlz;
  }

  /**
   * Örtliche Belegenheit der Betriebsstätte/Filiale
   */
  public String getLocOrt() {
    return locOrt;
  }

  public void setLocOrt(String locOrt) {
    this.locOrt = locOrt;
  }

  /**
   * Ländercode der Betriebsstätte/Filiale nach ISO 3166 ALPHA-3 Variante
   * <p/>
   * Weiterführende Informationen finden Sie hier: <a href="https://www.iso.org/iso-3166-country-codes.html">https://www.iso.org/iso-3166-country-codes.html</a>
   */
  public String getLocLand() {
    return locLand;
  }

  public void setLocLand(String locLand) {
    this.locLand = locLand;
  }

  /**
   * Hier handelt es sich um die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) der Betriebsstätte/Filiale.
   * <p/>
   * Aufteilung in Länderkürzel (2 Zeichen) und laufende Nummer (13 Zeichen).
   */
  public String getLocUstid() {
    return locUstid;
  }

  public void setLocUstid(String locUstid) {
    this.locUstid = locUstid;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammOrte.class.getSimpleName() + "[", "]")
      .add("locName='" + locName + "'")
      .add("locStrasse='" + locStrasse + "'")
      .add("locPlz='" + locPlz + "'")
      .add("locOrt='" + locOrt + "'")
      .add("locLand='" + locLand + "'")
      .add("locUstid='" + locUstid + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
