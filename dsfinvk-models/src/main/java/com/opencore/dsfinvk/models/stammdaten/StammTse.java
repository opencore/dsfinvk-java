package com.opencore.dsfinvk.models.stammdaten;

import java.util.StringJoiner;

import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

// TODO: Fertig stellen, hier gibt es Probleme wg. der Enums und vor allem der "dynamischen" TSE_ZERTIFIKAT* Spalten
public class StammTse extends BaseModel {

  public static final String FILENAME = "tse.csv";
  
  @Column(value = "TSE_ID", type = DataType.Numeric)
  private long tseId;
 
  @Size(max = 68)
  @Column(value = "TSE_SERIAL", type = DataType.AlphaNumeric)
  private String tseSerial;

  @Size(max = 21)
  @Column(value = "TSE_SIG_ALGO", type = DataType.AlphaNumeric)
  private String tseSigAlgo;

  @Size(max = 31)
  @Column(value = "TSE_ZEITFORMAT", type = DataType.AlphaNumeric)
  private String tseZeitformat;

  @Size(max = 5)
  @Column(value = "TSE_PD_ENCODING", type = DataType.AlphaNumeric)
  private String tsePdEncoding;

  @Size(max = 512)
  @Column(value = "TSE_PUBLIC_KEY", type = DataType.AlphaNumeric)
  private String tsePublicKey;
  
  @Size(max = 1000)
  @Column(value = "TSE_ZERTIFIKAT_I", type = DataType.AlphaNumeric)
  private String tseZertifikatI;
  
  @Size(max = 1000)
  @Column(value = "TSE_ZERTIFIKAT_II", type = DataType.AlphaNumeric)
  private String tseZertifikatII;

public String getTseSigAlgo() {
	return tseSigAlgo;
}

public void setTseSigAlgo(String tseSigAlgo) {
	this.tseSigAlgo = tseSigAlgo;
}

public long getTseId() {
	return tseId;
}

public void setTseId(long tseId) {
	this.tseId = tseId;
}

public String getTseSerial() {
	return tseSerial;
}

public void setTseSerial(String tseSerial) {
	this.tseSerial = tseSerial;
}

public String getTseZeitformat() {
	return tseZeitformat;
}

public void setTseZeitformat(String tseZeitformat) {
	this.tseZeitformat = tseZeitformat;
}

public String getTsePdEncoding() {
	return tsePdEncoding;
}

public void setTsePdEncoding(String tsePdEncoding) {
	this.tsePdEncoding = tsePdEncoding;
}

public String getTsePublicKey() {
	return tsePublicKey;
}

public void setTsePublicKey(String tsePublicKey) {
	this.tsePublicKey = tsePublicKey;
}

public String getTseZertifikatI() {
	return tseZertifikatI;
}

public void setTseZertifikatI(String tseZertifikatI) {
	this.tseZertifikatI = tseZertifikatI;
}

public String getTseZertifikatII() {
	return tseZertifikatII;
}

public void setTseZertifikatII(String tseZertifikatII) {
	this.tseZertifikatII = tseZertifikatII;
}

public String toString(){
	  return new StringJoiner(", ", StammTse.class.getSimpleName() + "[", "]")
		      .add("tseId='" + tseId + "'")
		      .add("tseSerial='" + tseSerial + "'")
		      .add("tseSigAlgo='" + tseSigAlgo + "'")
		      .add("tseZeitformat='" + tseZeitformat + "'")
		      .add("tsePdEncoding='" + tsePdEncoding + "'")
		      .add("tsePublicKey='" + tsePublicKey + "'")
		      .add("tseZertifikatI='" + tseZertifikatI + "'")
		      .add("tseZertifikatII='" + tseZertifikatII + "'")
		      .add("zKasseId='" + getzKasseId() + "'")
		      .add("zErstellung=" + getzErstellung())
		      .add("zNr=" + getzNr())
		      .toString();
}

}
