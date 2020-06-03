package com.opencore.dsfinvk.einzelaufzeichnung.bonpos;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencore.util.ValidUstSchluessel;

/**
 * In dieser Tabelle werden Detailangaben zur Entstehung des Preises abgelegt, z. B. spezielle Kunden-Rabatte oder auch Aufschläge.
 */
public class BonposPreisfindung extends BaseBonpos {

  public static final String FILENAME = "itemamounts.csv";

  @SuppressWarnings("FieldNamingConvention")
  public enum Typ {
    base_amount, discount, extra_amount
  }

  @JsonProperty("TYP")
  private Typ typ;

  @Positive
  @NotNull // TODO: This does not seem to work but it's still caught by the @Positive annotation
  @ValidUstSchluessel
  @JsonProperty("UST_SCHLUESSEL")
  private Long ustSchluessel;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @JsonProperty("PF_BRUTTO")
  private BigDecimal pfBrutto;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @JsonProperty("PF_NETTO")
  private BigDecimal pfNetto;

  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @JsonProperty("PF_UST")
  private BigDecimal pfUst;

  public Typ getTyp() {
    return typ;
  }

  public void setTyp(Typ typ) {
    this.typ = typ;
  }

  public Long getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(Long ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  public BigDecimal getPfBrutto() {
    return pfBrutto;
  }

  public void setPfBrutto(BigDecimal pfBrutto) {
    this.pfBrutto = pfBrutto;
  }

  public BigDecimal getPfNetto() {
    return pfNetto;
  }

  public void setPfNetto(BigDecimal pfNetto) {
    this.pfNetto = pfNetto;
  }

  public BigDecimal getPfUst() {
    return pfUst;
  }

  public void setPfUst(BigDecimal pfUst) {
    this.pfUst = pfUst;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonposPreisfindung.class.getSimpleName() + "[", "]")
      .add("typ=" + typ)
      .add("ustSchluessel=" + ustSchluessel)
      .add("pfBrutto=" + pfBrutto)
      .add("pfNetto=" + pfNetto)
      .add("pfUst=" + pfUst)
      .add("posZeile='" + getPosZeile() + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
