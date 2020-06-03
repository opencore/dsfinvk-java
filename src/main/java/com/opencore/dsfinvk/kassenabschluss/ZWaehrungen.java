package com.opencore.dsfinvk.kassenabschluss;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencore.dsfinvk.BaseModel;
import com.opencore.util.ValidIso4217Currency;

/**
 * Für jede Währung ("ZAHLART_WAEH") wird die Summe in dieser Datei dargestellt.
 * Damit stellt diese Datei eine jederzeitige Kassensturz-Fähigkeit her.
 */
public class ZWaehrungen extends BaseModel {

  public static final String FILENAME = "cash_per_currency.csv";

  // TODO: Das sollte eigentlich eher direkt ein Currency Feld sein
  @NotBlank
  @Size(max = 3)
  @ValidIso4217Currency
  @JsonProperty("ZAHLART_WAEH")
  private String zahlartWaeh;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @JsonProperty("ZAHLART_BETRAG_WAEH")
  private BigDecimal zahlartBetragWaeh;

  /**
   * Währungskennzeichen dargestellt nach ISO 4217 (Spalte: ISO-Code).
   */
  public String getZahlartWaeh() {
    return zahlartWaeh;
  }

  public void setZahlartWaeh(String zahlartWaeh) {
    this.zahlartWaeh = zahlartWaeh;
  }

  /**
   * Summe des Bargeldbestandes im Kassenabschluss differenziert nach Währung.
   */
  public BigDecimal getZahlartBetragWaeh() {
    return zahlartBetragWaeh;
  }

  public void setZahlartBetragWaeh(BigDecimal zahlartBetragWaeh) {
    this.zahlartBetragWaeh = zahlartBetragWaeh;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ZWaehrungen.class.getSimpleName() + "[", "]")
      .add("zahlartWaeh='" + zahlartWaeh + "'")
      .add("zahlartBetragWaeh=" + zahlartBetragWaeh)
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }
}
