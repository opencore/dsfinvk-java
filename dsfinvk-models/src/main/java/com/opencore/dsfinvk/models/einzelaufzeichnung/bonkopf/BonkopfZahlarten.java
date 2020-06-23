package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.ZahlartTyp;
import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
import com.opencore.dsfinvk.util.ValidIso4217Currency;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

public class BonkopfZahlarten extends BaseBon {

  public static final String FILENAME = "datapayment.csv";

  @NotNull
  @Column(value = "ZAHLART_TYP", type = DataType.AlphaNumeric)
  private ZahlartTyp zahlartTyp;

  @Column(value = "ZAHLART_NAME", type = DataType.AlphaNumeric)
  private String zahlartName;

  // TODO: Das sollte eigentlich eher direkt ein Currency Feld sein
  @NotBlank
  @Size(max = 3)
  @ValidIso4217Currency
  @Column(value = "ZAHLWAEH_CODE", type = DataType.AlphaNumeric)
  private String zahlwaehCode;

  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column(value = "ZAHLWAEH_BETRAG", type = DataType.Numeric)
  private BigDecimal zahlwaehBetrag;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column(value = "BASISWAEH_BETRAG", type = DataType.Numeric)
  private BigDecimal basiswaehBetrag;

  public ZahlartTyp getZahlartTyp() {
    return zahlartTyp;
  }

  public void setZahlartTyp(ZahlartTyp zahlartTyp) {
    this.zahlartTyp = zahlartTyp;
  }

  public String getZahlartName() {
    return zahlartName;
  }

  public void setZahlartName(String zahlartName) {
    this.zahlartName = zahlartName;
  }

  /**
   * Währung der verwendeten Zahlart, wenn die verwendete Währung von der Basiswährung abweicht.
   * <p/>
   * Weiterführende Informationen finden Sie hier: <a href="https://www.iso.org/iso-4217-currency-codes.html">https://www.iso.org/iso-4217-currency- codes.html</a>
   */
  public String getZahlwaehCode() {
    return zahlwaehCode;
  }

  public void setZahlwaehCode(String zahlwaehCode) {
    this.zahlwaehCode = zahlwaehCode;
  }

  /**
   * Betrag in Fremdwährung
   */
  public BigDecimal getZahlwaehBetrag() {
    return zahlwaehBetrag;
  }

  public void setZahlwaehBetrag(BigDecimal zahlwaehBetrag) {
    this.zahlwaehBetrag = zahlwaehBetrag;
  }

  /**
   * Betrag in Basiswährung.
   * <p/>
   * Bei Fremdwährung erfolgt hier eine Umrechnung in die Basiswährung.
   */
  public BigDecimal getBasiswaehBetrag() {
    return basiswaehBetrag;
  }

  public void setBasiswaehBetrag(BigDecimal basiswaehBetrag) {
    this.basiswaehBetrag = basiswaehBetrag;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonkopfZahlarten.class.getSimpleName() + "[", "]")
      .add("zahlartTyp=" + zahlartTyp)
      .add("zahlartName='" + zahlartName + "'")
      .add("zahlwaehCode='" + zahlwaehCode + "'")
      .add("zahlwaehBetrag=" + zahlwaehBetrag)
      .add("basiswaehBetrag=" + basiswaehBetrag)
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
