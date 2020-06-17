package com.opencore.dsfinvk.models.kassenabschluss;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.models.GvTyp;
import com.opencore.dsfinvk.util.ValidUstSchluessel;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * Für jeden Geschäftsvorfalltypen ("GV_Typ") werden (getrennt nach "GV_NAME" als Summen) die weiter zu verarbeitenden Gesamtbeträge dargestellt.
 */
public class ZGVTyp extends BaseModel {

  public static final String FILENAME = "businesscases.csv";

  @NotNull
  @Column("GV_TYP")
  private GvTyp gvTyp;

  @Size(max = 40)
  @Column("GV_NAME")
  private String gvName;

  @Column("AGENTUR_ID")
  private Long agenturId;

  @Positive
  @NotNull // TODO: This does not seem to work but it's still caught by the @Positive annotation
  @ValidUstSchluessel
  @Column("UST_SCHLUESSEL")
  private long ustSchluessel;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column("Z_UMS_BRUTTO")
  private BigDecimal zUmsBrutto;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column("Z_UMS_NETTO")
  private BigDecimal zUmsNetto;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column("Z_UST")
  private BigDecimal zUst;

  /**
   * Mittels des Unterscheidungskriteriums "GV_TYP" können verschiedene Geschäftsvorfallstypen mit unterschiedlichen Ausprägungen auf Positionsebene dargestellt und für die spätere Verbuchung aufsummiert werden.
   */
  public GvTyp getGvTyp() {
    return gvTyp;
  }

  public void setGvTyp(GvTyp gvTyp) {
    this.gvTyp = gvTyp;
  }

  /**
   * Zur Differenzierung und Unterteilung von Geschäftsvorfalltypen (GV_TYP) können hier zusätzliche Beschreibungen definiert werden.
   * Weitere Informationen finden sich in den Ausführungen in Anhang C (Individualisierung bzw. weitergehende Untergliederung der Geschäftsvorfallarten).
   */
  public String getGvName() {
    return gvName;
  }

  public void setGvName(String gvName) {
    this.gvName = gvName;
  }

  /**
   * Zuordnung der Geschäftsvorfalltypen (GV_TYP) zu Agenturumsätzen, differenziert nach der Agentur (AGENTUR_ID).
   * <p/>
   * Wird das Feld mit 0 gefüllt, werden die jeweiligen GV_TYPEN dem eigenen Unternehmen zugeordnet (=kein Agenturbezug).
   */
  public Long getAgenturId() {
    return agenturId;
  }

  public void setAgenturId(Long agenturId) {
    this.agenturId = agenturId;
  }

  /**
   * ID zum Umsatzsteuersatz, wie in den Ausführungen zu 3.2.6 Datei: Stamm_USt beschrieben.
   */
  public long getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(long ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  /**
   * Summe des zugeordneten Geschäftsvorfalltypen ("GV_TYP"), differenziert nach Umsatzsteuersatz - inklusive Umsatzsteuer
   */
  public BigDecimal getzUmsBrutto() {
    return zUmsBrutto;
  }

  public void setzUmsBrutto(BigDecimal zUmsBrutto) {
    this.zUmsBrutto = zUmsBrutto;
  }

  /**
   * Summe des zugeordneten Geschäftsvorfalltypen ("GV_TYP"), differenziert nach Umsatzsteuersatz - exklusive Umsatzsteuer
   */
  public BigDecimal getzUmsNetto() {
    return zUmsNetto;
  }

  public void setzUmsNetto(BigDecimal zUmsNetto) {
    this.zUmsNetto = zUmsNetto;
  }

  /**
   * Umsatzsteuerbetrag, der auf den Umsatzsteuersatz entfällt.
   */
  public BigDecimal getzUst() {
    return zUst;
  }

  public void setzUst(BigDecimal zUst) {
    this.zUst = zUst;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ZGVTyp.class.getSimpleName() + "[", "]")
      .add("gvTyp=" + gvTyp)
      .add("gvName='" + gvName + "'")
      .add("agenturId=" + agenturId)
      .add("ustSchluessel=" + ustSchluessel)
      .add("zUmsBrutto=" + zUmsBrutto)
      .add("zUmsNetto=" + zUmsNetto)
      .add("zUst=" + zUst)
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
