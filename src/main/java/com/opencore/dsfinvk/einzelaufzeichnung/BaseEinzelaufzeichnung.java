package com.opencore.dsfinvk.einzelaufzeichnung;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencore.dsfinvk.BaseModel;

/**
 * This is a base class for all files of the "Einzelaufzeichnungsmodul"
 */
public abstract class BaseEinzelaufzeichnung extends BaseModel {

  @NotBlank
  @Size(max = 40)
  @JsonProperty("BON_ID")
  private String bonId;

  @NotBlank
  @Size(max = 50)
  @JsonProperty("POS_ZEILE")
  private String posZeile;

  /**
   * Die BON_ID ist die von der eingesetzten Kasse vergebene, stetig fortlaufende und eindeutige Kennzeichnung aller Vorgänge.
   * Die BON_ID muss automatisiert und unveränderbar für jeden einzelnen Beleg in der Kasse vergeben werden.
   * Sie sollte in numerisch aufsteigender Form vergeben werden.
   */
  public String getBonId() {
    return bonId;
  }

  public void setBonId(String bonId) {
    this.bonId = bonId;
  }

  /**
   * Positionsnummer innerhalb des Belegs (muss eindeutig und fortlaufend sein).
   */
  public String getPosZeile() {
    return posZeile;
  }

  public void setPosZeile(String posZeile) {
    this.posZeile = posZeile;
  }
}
