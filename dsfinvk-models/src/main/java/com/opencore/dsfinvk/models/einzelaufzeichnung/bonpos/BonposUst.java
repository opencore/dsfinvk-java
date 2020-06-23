package com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.opencore.dsfinvk.util.ValidUstSchluessel;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

// TODO: Validator, dass entweder brutto oder (netto + ust) gesetzt ist

/**
 * Für jede Position werden in dieser Datei die Informationen zu den verwendeten USt-Sätzen festgehalten.
 * Da z. B. bei Warenzusammenstellungen mehrere USt-Sätze pro Position oder bei Rabattierungen mehrere Zeilen mit Preisangaben vorkommen können, ist diese Detailtabelle notwendig.
 */
public class BonposUst extends BaseBonpos {

  public static final String FILENAME = "lines_vat.csv";

  @Positive
  @NotNull // TODO: This does not seem to work but it's still caught by the @Positive annotation
  @ValidUstSchluessel
  @Column(value = "UST_SCHLUESSEL", type = DataType.Numeric)
  private Long ustSchluessel;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "POS_BRUTTO", type = DataType.Numeric)
  private BigDecimal posBrutto;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "POS_NETTO", type = DataType.Numeric)
  private BigDecimal posNetto;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "POS_UST", type = DataType.Numeric)
  private BigDecimal posUst;

  /**
   * ID zum Umsatzsteuersatz (vgl. : Ausführungen zu Tz. 3.2.6 Datei: Stamm_USt)
   */
  public Long getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(Long ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  /**
   * Summe des zugeordneten Teiles des Basisbetrages, differenziert nach Umsatzsteuersatz - inklusive Umsatzsteuer.
   * <p/>
   * Es kann entweder BRUTTO (bei Bruttomethode) oder NETTO und UST (bei Nettome- thode) verwendet werden.
   */
  public BigDecimal getPosBrutto() {
    return posBrutto;
  }

  public void setPosBrutto(BigDecimal posBrutto) {
    this.posBrutto = posBrutto;
  }

  /**
   * Summe des zugeordneten Teiles des Basisbetrages, differenziert nach Umsatzsteuersatz - exklusive Umsatzsteuer.
   * <p/>
   * Es kann entweder BRUTTO (bei Bruttomethode) oder NETTO und UST (bei Nettomethode) verwendet werden.
   */
  public BigDecimal getPosNetto() {
    return posNetto;
  }

  public void setPosNetto(BigDecimal posNetto) {
    this.posNetto = posNetto;
  }

  /**
   * Umsatzsteuerbetrag, der auf den jeweiligen Umsatzsteuersatz entfällt.
   * <p/>>
   * Es kann entweder BRUTTO (bei Bruttomethode) oder NETTO und UST (bei Nettomethode) verwendet werden.
   */
  public BigDecimal getPosUst() {
    return posUst;
  }

  public void setPosUst(BigDecimal posUst) {
    this.posUst = posUst;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonposUst.class.getSimpleName() + "[", "]")
      .add("ustSchluessel=" + ustSchluessel)
      .add("posBrutto=" + posBrutto)
      .add("posNetto=" + posNetto)
      .add("posUst=" + posUst)
      .add("posZeile='" + getPosZeile() + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
