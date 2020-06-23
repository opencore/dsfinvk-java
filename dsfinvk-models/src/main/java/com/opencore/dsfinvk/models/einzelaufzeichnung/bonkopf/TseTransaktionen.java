package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.validation.constraints.NotNull;

import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

public class TseTransaktionen extends BaseBon {

  public static final String FILENAME = "transactions_tse.csv";

  @NotNull
  @Column(value = "TSE_ID", type = DataType.Numeric)
  private Long tseId;

  @NotNull
  @Column(value = "TSE_TANR", type = DataType.Numeric)
  private Long tseTanr;

  @NotNull
  @Column(value = "TSE_TA_START", type = DataType.AlphaNumeric)
  private LocalDateTime tseTaStart;

  @NotNull
  @Column(value = "TSE_TA_ENDE", type = DataType.AlphaNumeric)
  private LocalDateTime tseTaEnde;

  // TODO: enum
  @NotNull
  @Column(value = "TSE_TA_VORGANGSART", type = DataType.AlphaNumeric)
  private String tseTaVorgangsart;

  @NotNull
  @Column(value = "TSE_TA_SIGZ", type = DataType.Numeric)
  private Long tseTaSigz;

  @NotNull
  @Column(value = "TSE_TA_SIG", type = DataType.Numeric)
  private String tseTaSig;

  @Column(value = "TSE_TA_FEHLER", type = DataType.AlphaNumeric)
  private String tseTaFehler;

  @Column(value = "TSE_VORGANGSDATEN", type = DataType.AlphaNumeric)
  private String tseVorgangsdaten;

  public Long getTseId() {
    return tseId;
  }

  public void setTseId(Long tseId) {
    this.tseId = tseId;
  }

  public Long getTseTanr() {
    return tseTanr;
  }

  public void setTseTanr(Long tseTanr) {
    this.tseTanr = tseTanr;
  }

  public LocalDateTime getTseTaStart() {
    return tseTaStart;
  }

  public void setTseTaStart(LocalDateTime tseTaStart) {
    this.tseTaStart = tseTaStart;
  }

  public LocalDateTime getTseTaEnde() {
    return tseTaEnde;
  }

  public void setTseTaEnde(LocalDateTime tseTaEnde) {
    this.tseTaEnde = tseTaEnde;
  }

  public String getTseTaVorgangsart() {
    return tseTaVorgangsart;
  }

  public void setTseTaVorgangsart(String tseTaVorgangsart) {
    this.tseTaVorgangsart = tseTaVorgangsart;
  }

  public Long getTseTaSigz() {
    return tseTaSigz;
  }

  public void setTseTaSigz(Long tseTaSigz) {
    this.tseTaSigz = tseTaSigz;
  }

  public String getTseTaSig() {
    return tseTaSig;
  }

  public void setTseTaSig(String tseTaSig) {
    this.tseTaSig = tseTaSig;
  }

  public String getTseTaFehler() {
    return tseTaFehler;
  }

  public void setTseTaFehler(String tseTaFehler) {
    this.tseTaFehler = tseTaFehler;
  }

  public String getTseVorgangsdaten() {
    return tseVorgangsdaten;
  }

  public void setTseVorgangsdaten(String tseVorgangsdaten) {
    this.tseVorgangsdaten = tseVorgangsdaten;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TseTransaktionen.class.getSimpleName() + "[", "]")
      .add("tseId=" + tseId)
      .add("tseTanr=" + tseTanr)
      .add("tseTaStart=" + tseTaStart)
      .add("tseTaEnde=" + tseTaEnde)
      .add("tseTaVorgangsart='" + tseTaVorgangsart + "'")
      .add("tseTaSigz=" + tseTaSigz)
      .add("tseTaSig='" + tseTaSig + "'")
      .add("tseTaFehler='" + tseTaFehler + "'")
      .add("tseVorgangsdaten='" + tseVorgangsdaten + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
