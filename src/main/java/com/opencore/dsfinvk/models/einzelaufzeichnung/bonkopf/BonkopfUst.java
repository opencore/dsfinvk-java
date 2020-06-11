package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
import com.opencore.dsfinvk.util.ValidVatId;
import com.opencore.dsfinvk.util.annotations.Column;

/**
 * Da es mehrere USt-Sätze pro Bonkopf geben kann, sind diese in einer Detail-Tabelle aufgeführt.
 * Hierbei gelten die zum Bonkopf aufgeführten Grundsätze.
 */
public class BonkopfUst extends BaseBon {

  public static final String FILENAME = "transactions_vat.csv";

  @NotNull
  @ValidVatId
  @Column("UST_SCHLUESSEL")
  private String ustSchluessel;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column("BON_BRUTTO")
  private BigDecimal bonBrutto;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column("BON_NETTO")
  private BigDecimal bonNetto;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  @Column("BON_UST")
  private BigDecimal bonUst;

  /**
   * ID zum Umsatzsteuersatz (vgl. Tz. 3.2.6 Datei: Stamm_USt)
   */
  public String getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(String ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  /**
   * Im gedruckten Bon ausgewiesene Bruttosummen pro UST_SCHLUESSEL.
   * <p/>
   * An dieser Stelle ist nicht einfach die Summe aus den betroffenen Positionen zu bilden.
   * Vielmehr muss der gedruckte Betrag dargestellt werden (Rechnungsdoppel).
   * Beträge sind mit zwei Dezimalstellen darzustellen, obwohl das Datenfeld eigentlich auf 5 Dezimalstellen ausgelegt ist.
   */
  public BigDecimal getBonBrutto() {
    return bonBrutto;
  }

  public void setBonBrutto(BigDecimal bonBrutto) {
    this.bonBrutto = bonBrutto;
  }

  /**
   * Im gedruckten Bon ausgewiesene Nettosummen pro UST_SCHLUESSEL.
   * <p/>
   * An dieser Stelle ist nicht einfach die Summe aus den betroffenen Positionen zu bilden.
   * Vielmehr muss der gedruckte Betrag dargestellt werden (Rechnungsdoppel).
   * Beträge sind mit zwei Dezimalstellen darzustellen, obwohl das Datenfeld eigentlich auf 5 Dezimalstellen ausgelegt ist.
   */
  public BigDecimal getBonNetto() {
    return bonNetto;
  }

  public void setBonNetto(BigDecimal bonNetto) {
    this.bonNetto = bonNetto;
  }

  /**
   * Im gedruckten Bon ausgewiesene USt pro UST_SCHLUESSEL.
   * <p/>
   * An dieser Stelle ist nicht einfach die Summe aus den betroffenen Positionen zu bilden.
   * Vielmehr muss der gedruckte Betrag dargestellt werden (Rechnungsdoppel).
   * Beträge sind mit zwei Dezimalstellen darzustellen, obwohl das Datenfeld eigentlich auf fünf Dezimalstellen ausgelegt ist.
   * Begrifflich handelt es sich hier um die ausgewiesene Umsatzsteuer, die den Kunden evtl. zum Vorsteuerabzug berechtigt.
   */
  public BigDecimal getBonUst() {
    return bonUst;
  }

  public void setBonUst(BigDecimal bonUst) {
    this.bonUst = bonUst;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonkopfUst.class.getSimpleName() + "[", "]")
      .add("ustSchluessel='" + ustSchluessel + "'")
      .add("bonBrutto=" + bonBrutto)
      .add("bonNetto=" + bonNetto)
      .add("bonUst=" + bonUst)
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
