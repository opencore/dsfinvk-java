package com.opencore.dsfinvk.models.stammdaten;

import java.util.StringJoiner;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.annotations.Column;

/**
 * Stammdaten der einzelnen Erfassungs-Terminals (sog. Slave-Kassen), über die nicht der Kassenabschluss erfolgt.
 * <p/>
 * Technischer Name: slaves.csv
 */
public class StammTerminals extends BaseModel {

  public static final String FILENAME = "slaves.csv";

  @Size(max = 50)
  @NotBlank
  @Column("TERMINAL_ID")
  private String terminalId;

  @Size(max = 50)
  @Column("TERMINAL_BRAND")
  private String terminalBrand;

  @Size(max = 50)
  @Column("TERMINAL_MODELL")
  private String terminalModell;

  @Size(max = 70)
  @Column("TERMINAL_SERIENNR")
  private String terminalSeriennr;

  @Size(max = 50)
  @Column("TERMINAL_SW_BRAND")
  private String terminalSwBrand;

  @Size(max = 50)
  @Column("TERMINAL_SW_VERSION")
  private String terminalSwVersion;

  /**
   * Eindeutige ID für eine Kasse.
   * Die ID führt zur eindeutigen Identifikation und Zuordnung von Vorgängen auf eine Kasse.
   * Sie wird nur zur Referenzierung innerhalb eines Kassenabschlusses verwendet.
   */
  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }

  /**
   * Das Feld "TERMINAL_BRAND" bezeichnet den Marken-/Herstellernamen der eingesetzten Slave-Kasse.
   */
  public String getTerminalBrand() {
    return terminalBrand;
  }

  public void setTerminalBrand(String terminalBrand) {
    this.terminalBrand = terminalBrand;
  }

  /**
   * Das Feld bezeichnet das Modell der eingesetzten Slave-Kasse.
   */
  public String getTerminalModell() {
    return terminalModell;
  }

  public void setTerminalModell(String terminalModell) {
    this.terminalModell = terminalModell;
  }

  /**
   * Hier ist die Identifikationsnummer (ID) der Slave-Kasse einzutragen, die der jeweilige Hersteller vergibt, um diese eindeutig zu identifizieren.
   */
  public String getTerminalSeriennr() {
    return terminalSeriennr;
  }

  public void setTerminalSeriennr(String terminalSeriennr) {
    this.terminalSeriennr = terminalSeriennr;
  }

  /**
   * Hier wird die Softwarebezeichnung der innerhalb der Slave-Kasse verwendeten Software aufgeführt.
   */
  public String getTerminalSwBrand() {
    return terminalSwBrand;
  }

  public void setTerminalSwBrand(String terminalSwBrand) {
    this.terminalSwBrand = terminalSwBrand;
  }

  /**
   * Hier erfolgt die Versionsangabe der jeweilig eingesetzten Software der Slave-Kasse.
   */
  public String getTerminalSwVersion() {
    return terminalSwVersion;
  }

  public void setTerminalSwVersion(String terminalSwVersion) {
    this.terminalSwVersion = terminalSwVersion;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammTerminals.class.getSimpleName() + "[", "]")
      .add("terminalId='" + terminalId + "'")
      .add("terminalBrand='" + terminalBrand + "'")
      .add("terminalModell='" + terminalModell + "'")
      .add("terminalSeriennr='" + terminalSeriennr + "'")
      .add("terminalSwBrand='" + terminalSwBrand + "'")
      .add("terminalSwVersion='" + terminalSwVersion + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
