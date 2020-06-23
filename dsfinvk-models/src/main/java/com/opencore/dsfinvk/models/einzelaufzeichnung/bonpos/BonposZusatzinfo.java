package com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.util.ValidUstSchluessel;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

public class BonposZusatzinfo extends BaseBonpos {

  public static final String FILENAME = "subitems.csv";

  @NotBlank
  @Size(max = 50)
  @Column(value = "ZI_ART_NR", type = DataType.AlphaNumeric)
  private String ziArtNr;

  @Size(max = 50)
  @Column(value = "ZI_GTIN", type = DataType.AlphaNumeric)
  private String ziGtin;

  @Size(max = 60)
  @Column(value = "ZI_NAME", type = DataType.AlphaNumeric)
  private String ziName;

  @Size(max = 40)
  @Column(value = "ZI_WARENGR_ID", type = DataType.AlphaNumeric)
  private String ziWarengrId;

  @Size(max = 50)
  @Column(value = "ZI_WARENGR", type = DataType.AlphaNumeric)
  private String ziWarengr;

  @NotNull
  @Digits(integer = Integer.MAX_VALUE, fraction = 3)
  @Column(value = "ZI_MENGE", type = DataType.Numeric)
  private BigDecimal ziMenge;

  @Digits(integer = Integer.MAX_VALUE, fraction = 3)
  @Column(value = "ZI_FAKTOR", type = DataType.Numeric)
  private BigDecimal ziFaktor;

  /**
   * Maßeinheit des Artikels auf SubItem-Ebene.
   */
  @Size(max = 50)
  @Column(value = "ZI_EINHEIT", type = DataType.AlphaNumeric)
  private String ziEinheit;

  /**
   * ID zum Umsatzsteuersatz (vgl. Ausführungen zu Tz. 3.2.6 Datei: Stamm_USt)
   */
  @Positive
  @NotNull // TODO: This does not seem to work but it's still caught by the @Positive annotation
  @ValidUstSchluessel
  @Column(value = "ZI_UST_SCHLUESSEL", type = DataType.Numeric)
  private Long ustSchluessel;

  /**
   * Basispreis Brutto
   */
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "ZI_BASISPREIS_BRUTTO", type = DataType.Numeric)
  private BigDecimal ziBasispreisBrutto;

  /**
   * Basispreis Netto
   */
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "ZI_BASISPREIS_NETTO", type = DataType.Numeric)
  private BigDecimal ziBasispreisNetto;

  /**
   * USt-Betrag auf Basispreis
   */
  @Digits(integer = Integer.MAX_VALUE, fraction = 5)
  @Column(value = "ZI_BASISPREIS_UST", type = DataType.Numeric)
  private BigDecimal ziBasispreisUst;

  public String getZiArtNr() {
    return ziArtNr;
  }

  public void setZiArtNr(String ziArtNr) {
    this.ziArtNr = ziArtNr;
  }

  public String getZiGtin() {
    return ziGtin;
  }

  public void setZiGtin(String ziGtin) {
    this.ziGtin = ziGtin;
  }

  public String getZiName() {
    return ziName;
  }

  public void setZiName(String ziName) {
    this.ziName = ziName;
  }

  public String getZiWarengrId() {
    return ziWarengrId;
  }

  public void setZiWarengrId(String ziWarengrId) {
    this.ziWarengrId = ziWarengrId;
  }

  public String getZiWarengr() {
    return ziWarengr;
  }

  public void setZiWarengr(String ziWarengr) {
    this.ziWarengr = ziWarengr;
  }

  public BigDecimal getZiMenge() {
    return ziMenge;
  }

  public void setZiMenge(BigDecimal ziMenge) {
    this.ziMenge = ziMenge;
  }

  public BigDecimal getZiFaktor() {
    return ziFaktor;
  }

  public void setZiFaktor(BigDecimal ziFaktor) {
    this.ziFaktor = ziFaktor;
  }

  public String getZiEinheit() {
    return ziEinheit;
  }

  public void setZiEinheit(String ziEinheit) {
    this.ziEinheit = ziEinheit;
  }

  public Long getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(Long ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  public BigDecimal getZiBasispreisBrutto() {
    return ziBasispreisBrutto;
  }

  public void setZiBasispreisBrutto(BigDecimal ziBasispreisBrutto) {
    this.ziBasispreisBrutto = ziBasispreisBrutto;
  }

  public BigDecimal getZiBasispreisNetto() {
    return ziBasispreisNetto;
  }

  public void setZiBasispreisNetto(BigDecimal ziBasispreisNetto) {
    this.ziBasispreisNetto = ziBasispreisNetto;
  }

  public BigDecimal getZiBasispreisUst() {
    return ziBasispreisUst;
  }

  public void setZiBasispreisUst(BigDecimal ziBasispreisUst) {
    this.ziBasispreisUst = ziBasispreisUst;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonposZusatzinfo.class.getSimpleName() + "[", "]")
      .add("ziArtNr='" + ziArtNr + "'")
      .add("ziGtin='" + ziGtin + "'")
      .add("ziName='" + ziName + "'")
      .add("ziWarengrId='" + ziWarengrId + "'")
      .add("ziWarengr='" + ziWarengr + "'")
      .add("ziMenge=" + ziMenge)
      .add("ziFaktor=" + ziFaktor)
      .add("ziEinheit='" + ziEinheit + "'")
      .add("ustSchluessel=" + ustSchluessel)
      .add("ziBasispreisBrutto=" + ziBasispreisBrutto)
      .add("ziBasispreisNetto=" + ziBasispreisNetto)
      .add("ziBasispreisUst=" + ziBasispreisUst)
      .add("posZeile='" + getPosZeile() + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
