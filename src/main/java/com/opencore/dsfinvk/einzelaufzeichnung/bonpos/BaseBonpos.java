package com.opencore.dsfinvk.einzelaufzeichnung.bonpos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencore.dsfinvk.einzelaufzeichnung.BaseBon;

public abstract class BaseBonpos extends BaseBon {

  @NotBlank
  @Size(max = 50)
  @JsonProperty("POS_ZEILE")
  private String posZeile;

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
