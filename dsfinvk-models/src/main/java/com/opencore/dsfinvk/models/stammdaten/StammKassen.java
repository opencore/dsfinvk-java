package com.opencore.dsfinvk.models.stammdaten;

import java.util.StringJoiner;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.ValidIso4217Currency;
import com.opencore.gdpdu.index.annotations.Column;

/**
 * Stammdaten der einzelnen eingesetzten Kassen.
 * <p/>
 * Technischer Name der Datei: {@code cashregister.csv}
 */
public class StammKassen extends BaseModel {

  public static final String FILENAME = "cashregister.csv";

  @Size(max = 50)
  @Column("KASSE_BRAND")
  private String kasseBrand;

  @Size(max = 50)
  @Column("KASSE_MODELL")
  private String kasseModell;

  @NotBlank
  @Size(max = 70)
  @Column("KASSE_SERIENNR")
  private String kasseSeriennr;

  @Size(max = 50)
  @Column("KASSE_SW_BRAND")
  private String kasseSwBrand;

  @Size(max = 50)
  @Column("KASSE_SW_VERSION")
  private String kasseSwVersion;

  // TODO: Das sollte eigentlich eher direkt ein Currency Feld sein
  @NotBlank
  @Size(max = 3)
  @ValidIso4217Currency
  @Column("KASSE_BASISWAEH_CODE")
  private String kasseBasiswaehCode;

  @Column("KEINE_UST_ZUORDNUNG")
  private Boolean keineUstZuordnung;

  public String getKasseBrand() {
    return kasseBrand;
  }

  public void setKasseBrand(String kasseBrand) {
    this.kasseBrand = kasseBrand;
  }

  public String getKasseModell() {
    return kasseModell;
  }

  public void setKasseModell(String kasseModell) {
    this.kasseModell = kasseModell;
  }

  public String getKasseSeriennr() {
    return kasseSeriennr;
  }

  public void setKasseSeriennr(String kasseSeriennr) {
    this.kasseSeriennr = kasseSeriennr;
  }

  public String getKasseSwBrand() {
    return kasseSwBrand;
  }

  public void setKasseSwBrand(String kasseSwBrand) {
    this.kasseSwBrand = kasseSwBrand;
  }

  public String getKasseSwVersion() {
    return kasseSwVersion;
  }

  public void setKasseSwVersion(String kasseSwVersion) {
    this.kasseSwVersion = kasseSwVersion;
  }

  public String getKasseBasiswaehCode() {
    return kasseBasiswaehCode;
  }

  public void setKasseBasiswaehCode(String kasseBasiswaehCode) {
    this.kasseBasiswaehCode = kasseBasiswaehCode;
  }

  public Boolean isKeineUstZuordnung() {
    return keineUstZuordnung;
  }

  public void setKeineUstZuordnung(Boolean keineUstZuordnung) {
    this.keineUstZuordnung = keineUstZuordnung;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammKassen.class.getSimpleName() + "[", "]")
      .add("kasseBrand='" + kasseBrand + "'")
      .add("kasseModell='" + kasseModell + "'")
      .add("kasseSeriennr='" + kasseSeriennr + "'")
      .add("kasseSwBrand='" + kasseSwBrand + "'")
      .add("kasseSwVersion='" + kasseSwVersion + "'")
      .add("kasseBasiswaehCode='" + kasseBasiswaehCode + "'")
      .add("keineUstZuordnung=" + keineUstZuordnung)
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
