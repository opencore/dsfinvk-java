package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.validation.constraints.NotNull;

import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
import com.opencore.dsfinvk.util.annotations.Column;

public class TseTransaktionen extends BaseBon {

  public static final String FILENAME = "transactions_tse.csv";

  @NotNull
  @Column("TSE_ID")
  private Long tseId;

  @NotNull
  @Column("TSE_TANR")
  private Long tseTanr;

  @NotNull
  @Column("TSE_TA_START")
  private LocalDateTime tseTaStart;

  @NotNull
  @Column("TSE_TA_ENDE")
  private LocalDateTime tseTaEnde;

  // TODO: enum
  @NotNull
  @Column("TSE_TA_VORGANGSART")
  private String tseTaVorgangsart;

  @NotNull
  @Column("TSE_TA_SIGZ")
  private Long tseTaSigz;

  @NotNull
  @Column("TSE_TA_SIG")
  private String tseTaSig;

  @Column("TSE_TA_FEHLER")
  private String tseTaFehler;

  @Column("TSE_VORGANGSDATEN")
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
