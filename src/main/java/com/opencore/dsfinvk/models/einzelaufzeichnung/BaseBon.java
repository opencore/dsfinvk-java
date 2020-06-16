package com.opencore.dsfinvk.models.einzelaufzeichnung;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * This is a base class for all files of the "Einzelaufzeichnungsmodul"
 */
public abstract class BaseBon extends BaseModel {

  @NotBlank
  @Size(max = 40)
  @Column("BON_ID")
  private String bonId;

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

}
