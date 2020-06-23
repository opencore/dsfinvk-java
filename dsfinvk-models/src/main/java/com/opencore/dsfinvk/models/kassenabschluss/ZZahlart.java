package com.opencore.dsfinvk.models.kassenabschluss;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.models.ZahlartTyp;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

/**
 * Für jeden Zahlarttypen ("ZAHLART_TYP") werden (getrennt nach "ZAHLART_NAME") Summen gebildet ("ZAHLART_BETRAG"), die weiter in der Buchhaltung zu verarbeitenden Gesamtbeträge dargestellt.
 */
public class ZZahlart extends BaseModel {

  public static final String FILENAME = "payment.csv";

  @NotNull
  @Column(value = "ZAHLART_TYP", type = DataType.AlphaNumeric)
  private ZahlartTyp zahlartTyp;

  @Size(max = 60)
  @Column(value = "ZAHLART_NAME", type = DataType.AlphaNumeric)
  private String zahlartName;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column(value = "Z_ZAHLART_BETRAG", type = DataType.Numeric)
  private BigDecimal zZahlartBetrag;

  /**
   * Die Bezeichnung der jeweiligen Zahlart.
   * Es muss mindestens eine Unterscheidung zwischen "Bar" und "Unbar" getroffen werden.
   * Die Einzelheiten sind im Anhang D dargestellt.
   */
  public ZahlartTyp getZahlartTyp() {
    return zahlartTyp;
  }

  public void setZahlartTyp(ZahlartTyp zahlartTyp) {
    this.zahlartTyp = zahlartTyp;
  }

  /**
   * Bezeichnung der Zahlart lt. verwendeter Kassensoftware.
   * Weitere Informationen finden sich im Anhang D.
   */
  public String getZahlartName() {
    return zahlartName;
  }

  public void setZahlartName(String zahlartName) {
    this.zahlartName = zahlartName;
  }

  /**
   * Summe aller Einzelbewegungen, differenziert nach Zahlart.
   */
  public BigDecimal getzZahlartBetrag() {
    return zZahlartBetrag;
  }

  public void setzZahlartBetrag(BigDecimal zZahlartBetrag) {
    this.zZahlartBetrag = zZahlartBetrag;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ZZahlart.class.getSimpleName() + "[", "]")
      .add("zahlartTyp=" + zahlartTyp)
      .add("zahlartName='" + zahlartName + "'")
      .add("zZahlartBetrag=" + zZahlartBetrag)
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
