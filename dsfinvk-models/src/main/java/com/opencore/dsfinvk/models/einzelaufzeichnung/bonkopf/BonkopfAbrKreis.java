package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

import java.util.StringJoiner;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.einzelaufzeichnung.BaseBon;
 import com.opencore.gdpdu.index.annotations.Column;

/**
 * Der Abrechnungskreis ist eine variable Einheit, mit der ein Beleg einem bestimmten Kriterium (Tisch, Abteilung etc.) zugeordnet werden kann.
 * Insbesondere in der Gastronomie können über diese Zuordnung Splittbuchungen und Tischverlegungen nachvollzogen werden.
 */
public class BonkopfAbrKreis extends BaseBon {

  public static final String FILENAME = "allocation_groups.csv";

  @Size(max = 50)
  @Column("ABRECHNUNGSKREIS")
  private String abrechnungskreis;

  /**
   * Der Abrechnungskreis ist eine variable Einheit, mit der ein Beleg einem bestimmten Kriterium (Tisch, Abteilung etc.) zugeordnet werden kann.
   */
  public String getAbrechnungskreis() {
    return abrechnungskreis;
  }

  public void setAbrechnungskreis(String abrechnungskreis) {
    this.abrechnungskreis = abrechnungskreis;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BonkopfAbrKreis.class.getSimpleName() + "[", "]")
      .add("abrechnungskreis='" + abrechnungskreis + "'")
      .add("bonId='" + getBonId() + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
