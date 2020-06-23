package com.opencore.dsfinvk.models.einzelaufzeichnung;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

/**
 * In dieser Datei können Referenzen auf Vorgänge innerhalb der DSFinV-K ebenso wie Verweise auf externe Systeme vorgenommen werden.
 * Welche Art der Referenzierung vorliegt, ergibt sich aus dem Typ der Referenzierung.
 */
// TODO: Braucht einen Klassenvalidator
public class BonReferenzen extends BaseBon {

  public static final String FILENAME = "references.csv";

  @Size(max = 50)
  @Column(value = "POS_ZEILE", type = DataType.AlphaNumeric)
  private String posZeile;

  @NotNull
  @Column(value = "REF_TYP", type = DataType.AlphaNumeric)
  private RefTyp refTyp;

  @Column(value = "REF_NAME", type = DataType.AlphaNumeric)
  private String refName;

  @Column(value = "REF_DATUM", type = DataType.AlphaNumeric)
  private LocalDateTime refDatum;

  @Column(value = "REF_Z_KASSE_ID", type = DataType.AlphaNumeric)
  private String refZKasseId;

  @Column(value = "REF_Z_NR", type = DataType.Numeric)
  private Long refZNr;

  @Column(value = "REF_BON_ID", type = DataType.AlphaNumeric)
  private String refBonId;

  /**
   * Positionsnummer innerhalb des Belegs (muss eindeutig und fortlaufend sein).
   */
  public String getPosZeile() {
    return posZeile;
  }

  public void setPosZeile(String posZeile) {
    this.posZeile = posZeile;
  }

  public RefTyp getRefTyp() {
    return refTyp;
  }

  public void setRefTyp(RefTyp refTyp) {
    this.refTyp = refTyp;
  }

  public String getRefName() {
    return refName;
  }

  public void setRefName(String refName) {
    this.refName = refName;
  }

  public LocalDateTime getRefDatum() {
    return refDatum;
  }

  public void setRefDatum(LocalDateTime refDatum) {
    this.refDatum = refDatum;
  }

  public String getRefZKasseId() {
    return refZKasseId;
  }

  public void setRefZKasseId(String refZKasseId) {
    this.refZKasseId = refZKasseId;
  }

  public Long getRefZNr() {
    return refZNr;
  }

  public void setRefZNr(Long refZNr) {
    this.refZNr = refZNr;
  }

  public String getRefBonId() {
    return refBonId;
  }

  public void setRefBonId(String refBonId) {
    this.refBonId = refBonId;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonReferenzen.class.getSimpleName() + "[", "]")
      .add("posZeile='" + posZeile + "'")
      .add("refTyp=" + refTyp)
      .add("refName='" + refName + "'")
      .add("refDatum=" + refDatum)
      .add("refZKasseId='" + refZKasseId + "'")
      .add("refZNr=" + refZNr)
      .add("refBonId='" + refBonId + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

  @SuppressWarnings("FieldNamingConvention")
  public enum RefTyp {
    ExterneRechnung, ExternerLieferschein, Transaktion, ExterneSonstige
  }

}
