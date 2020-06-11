package com.opencore.dsfinvk.models.stammdaten;

import java.util.StringJoiner;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.StrictGroup;
import com.opencore.dsfinvk.util.ValidIso3166Alpha3Country;
import com.opencore.dsfinvk.util.ValidStammAgenturen;
import com.opencore.dsfinvk.util.ValidVatId;
import com.opencore.dsfinvk.util.annotations.Column;

/**
 * Werden Beträge "für Rechnung Dritter" erfasst (durchlaufende Posten), ist der Dritte verantwortlich für die korrekte Erfassung der Umsatzsteuer (z. B. Shop-in-Shop, wobei es unabhängige Unternehmer sein müssen).
 * <p/>
 * Die durchlaufenden Posten müssen von den eigenen Kasseneinnahmen getrennt aufgezeichnet werden.
 * Aus diesem Grund erfolgt die Trennung in der DSFinV-K über eine Agentur-ID.
 * Bei der Berechnung einer Umsatzsteuer-Zahllast können nun die Agenturumsätze ausgenommen werden.
 * Somit ist die Nachvollziehbarkeit der Umsatzsteuer-Zahllast sowie die Ermittlung der korrekten Tages-Kasseneinnahmen möglich.
 * Ebenso ist eine korrekte Bildung der zu verbuchenden Summen hinsichtlich der Agentur gewährleistet.
 */
@ValidStammAgenturen
public class StammAgenturen extends BaseModel {

  public static final String FILENAME = "pa.csv";

  @Column("AGENTUR_ID")
  private long agenturId;

  @NotBlank(groups = StrictGroup.class)
  @Size(max = 60)
  @Column("AGENTUR_NAME")
  private String agenturName;

  @Size(max = 60)
  @NotBlank(groups = StrictGroup.class)
  @Column("AGENTUR_STRASSE")
  private String agenturStrasse;

  @Size(max = 10)
  @NotBlank(groups = StrictGroup.class)
  @Column("AGENTUR_PLZ")
  private String agenturPlz;

  @Size(max = 62)
  @NotBlank(groups = StrictGroup.class)
  @Column("AGENTUR_ORT")
  private String agenturOrt;

  @Size(max = 3)
  @NotBlank(groups = StrictGroup.class)
  @ValidIso3166Alpha3Country
  @Column("AGENTUR_LAND")
  private String agenturLand;

  @Size(max = 20)
  @Column("AGENTUR_STNR")
  private String agenturStnr;

  @Size(max = 15)
  @ValidVatId
  @Column("AGENTUR_USTID")
  private String agenturUstid;

  /**
   * Eindeutige Identifikations-Nummer (ID) für Agenturen.
   * Die ID ermöglicht die eindeutige Identifikation und Zuordnung von Transaktionen zu einer Agentur.
   * Sie wird auf Positionsebene genutzt und stellt bei der Aufsummierung zum Kassenabschluss ein Unterscheidungskriterium für die Verbuchung dar.
   * <p/>
   * Wird das Feld mit 0 gefüllt, werden die jeweiligen Transaktionen dem eigenen Unternehmen zugeordnet (=kein Agenturbezug).
   */
  public long getAgenturId() {
    return agenturId;
  }

  public void setAgenturId(long agenturId) {
    this.agenturId = agenturId;
  }

  /**
   * Name des Agenturgebers
   */
  public String getAgenturName() {
    return agenturName;
  }

  public void setAgenturName(String agenturName) {
    this.agenturName = agenturName;
  }

  /**
   * Straße und Hausnummer des Agenturgebers
   */
  public String getAgenturStrasse() {
    return agenturStrasse;
  }

  public void setAgenturStrasse(String agenturStrasse) {
    this.agenturStrasse = agenturStrasse;
  }

  /**
   * Postleitzahl des Agenturgebers
   */
  public String getAgenturPlz() {
    return agenturPlz;
  }

  public void setAgenturPlz(String agenturPlz) {
    this.agenturPlz = agenturPlz;
  }

  /**
   * Örtliche Belegenheit des Agenturgebers
   */
  public String getAgenturOrt() {
    return agenturOrt;
  }

  public void setAgenturOrt(String agenturOrt) {
    this.agenturOrt = agenturOrt;
  }

  /**
   * Ländercode des Agenturgebers nach ISO 3166 ALPHA-3 Variante Besonderheiten:
   * <p/>
   * Weiterführende Informationen finden Sie unter <a href="https://www.iso.org/iso-3166-country-codes.html">https://www.iso.org/iso-3166-country-codes.html</a>
   */
  public String getAgenturLand() {
    return agenturLand;
  }

  public void setAgenturLand(String agenturLand) {
    this.agenturLand = agenturLand;
  }

  /**
   * Hier handelt es sich um die Steuernummer des Agenturgebers.
   * <p/>
   * Es muss entweder die Steuernummer oder die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Agenturgebers angegeben werden.
   */
  public String getAgenturStnr() {
    return agenturStnr;
  }

  public void setAgenturStnr(String agenturStnr) {
    this.agenturStnr = agenturStnr;
  }

  /**
   * Hier handelt es sich um die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Agenturgebers
   * <p/>>
   * Aufteilung in Länderkürzel (2 Zeichen) und laufende Nummer (13 Zeichen).
   * Es muss entweder die Steuernummer oder die Umsatzsteuer-Identifikationsnummer (§ 27a UStG) des Agenturgebers angegeben werden.
   */
  public String getAgenturUstid() {
    return agenturUstid;
  }

  public void setAgenturUstid(String agenturUstid) {
    this.agenturUstid = agenturUstid;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammAgenturen.class.getSimpleName() + "[", "]")
      .add("agenturId=" + agenturId)
      .add("agenturName='" + agenturName + "'")
      .add("agenturStrasse='" + agenturStrasse + "'")
      .add("agenturPlz='" + agenturPlz + "'")
      .add("agenturOrt='" + agenturOrt + "'")
      .add("agenturLand='" + agenturLand + "'")
      .add("agenturStnr='" + agenturStnr + "'")
      .add("agenturUstid='" + agenturUstid + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
