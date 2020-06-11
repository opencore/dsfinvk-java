package com.opencore.dsfinvk.models.stammdaten;

import com.opencore.dsfinvk.models.BaseModel;

// TODO: Fertig stellen, hier gibt es Probleme wg. der Enums und vor allem der "dynamischen" TSE_ZERTIFIKAT* Spalten
public class StammTse extends BaseModel {

  private long tseId;

  private String tseSerial;

  private TseSigAlgo tseSigAlgo;

  private String tseZeitformat;

  private TsePdEncoding tsePdEncoding;

  private String tsePublicKey;

  private String tseZertifikatI;

  private String tseZertifikatII;

}
