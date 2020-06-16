package com.opencore.dsfinvk.models;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.opencore.gdpdu.index.annotations.Column;

public abstract class BaseModel {

  @NotBlank
  @Size(max = 50)
  @Column("Z_KASSE_ID")
  private String zKasseId;

  @NotNull
  @PastOrPresent
  @Column("Z_ERSTELLUNG")
  private LocalDateTime zErstellung;

  @Column("Z_NR")
  private int zNr;

  /**
   * Eindeutige ID für eine Kasse.
   * Die ID führt zur eindeutigen Identifikation und Zuordnung von Vorgängen auf eine Kasse.
   * Sie wird nur zur Referenzierung innerhalb eines Kassenabschlusses verwendet.
   */
  public String getzKasseId() {
    return zKasseId;
  }

  public void setzKasseId(String zKasseId) {
    this.zKasseId = zKasseId;
  }

  /**
   * Zeitstempel der Erstellung des Kassenabschlusses.
   * <p/>
   * Inhalt muss folgendem Muster entsprechen: ISO 8601 und RFC3339 (z. B. 2016-09-27T17:00:01)
   */
  public LocalDateTime getzErstellung() {
    return zErstellung;
  }

  public void setzErstellung(LocalDateTime zErstellung) {
    this.zErstellung = zErstellung;
  }

  /**
   * Der Kassenabschluss wird einmalig bzw. mehrmals am Tag oder auch kalendertagübergreifend für eine Kasse erstellt.
   * Jede Kasse besitzt eine „Z_NR“, eine Kassenabschlussnummer.
   * Diese ist aufsteigend, fortlaufend und nicht zurücksetzbar.
   */
  public int getzNr() {
    return zNr;
  }

  public void setzNr(int zNr) {
    this.zNr = zNr;
  }

}
