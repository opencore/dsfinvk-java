package com.opencore.dsfinvk.models.stammdaten;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.opencore.dsfinvk.models.BaseModel;
import com.opencore.dsfinvk.util.ValidStammUst;
import com.opencore.dsfinvk.util.ValidUstSchluessel;
import com.opencore.gdpdu.index.annotations.Column;
import com.opencore.gdpdu.index.models.DataType;

/**
 * Stammdaten zur Umsatzsteuer (ID, USt-Satz, Beschreibung).
 * <p/>
 * Die Zuordnung der verwendeten Umsatzsteuerschlüssel wird innerhalb der DSFinV-K in den Stammdaten festgelegt (s. u.).
 * <p/>
 * In der folgenden Übersicht werden die Umsatzsteuerschlüssel mit Beschreibung und den aktuell gültigen Umsatzsteuersätzen dargestellt.
 * Bei einer Änderung der gesetzlichen Umsatzsteuersätze können Anpassungen ab der ID 1000 individuell für den Unternehmer erfolgen.
 * Diese Anpassungen (ab ID 1000) können nach einem Kassenabschluss jederzeit vorgenommen werden und sind in den entsprechenden Systembeschreibungen bzw. Verfahrensdokumentationen zu dokumentieren.
 * <p/>
 * Anpassungen der IDs von 8-999 bleiben der DFKA-Taxonomie und der DSFinV-K vorbehalten und sind in den Begleitdokumenten bei Änderungen zu dokumentieren und zu erläutern.
 * <p/>
 * Die Beschreibung kann individuell angepasst werden (z. B. Ergänzung kassenüblicher Beschreibungen, die auch auf den Belegen aufgedruckt sind).
 *
 * <table>
 *   <tr>
 *     <th>ID</th>
 *     <th>USt-Satz</th>
 *     <th>Beschreibung</th>
 *   </tr>
 *   <tr>
 *     <td>1</td>
 *     <td></td>
 *     <td>Zum Zeitpunkt der Erfassung des Geschäftsvorfalls geltender allgemeiner Steuersatz (§ 12 Abs. 1 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>2</td>
 *     <td></td>
 *     <td>Zum Zeitpunkt der Erfassung des Geschäftsvorfalls geltender ermäßigter Steuersatz (§ 12 Abs. 2 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>3</td>
 *     <td>10,70%</td>
 *     <td>Durchschnittsatz (§ 24 Abs. 1 Nr. 3 UStG) übrige Fälle</td>
 *   </tr>
 *   <tr>
 *     <td>4</td>
 *     <td>5,50%</td>
 *     <td>Durchschnittsatz (§ 24 Abs. 1 Nr. 1 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>5</td>
 *     <td>0,00%</td>
 *     <td>Nicht Steuerbar</td>
 *   </tr>
 *   <tr>
 *     <td>6</td>
 *     <td>0,00%</td>
 *     <td>Umsatzsteuerfrei</td>
 *   </tr>
 *   <tr>
 *     <td>7</td>
 *     <td>0,00%</td>
 *     <td>UmsatzsteuerNichtErmittelbar</td>
 *   </tr>
 *   <tr>
 *     <td>11</td>
 *     <td>19,00%</td>
 *     <td>Historischer allgemeiner Steuersatz (§ 12 Abs. 1 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>12</td>
 *     <td>7,00%</td>
 *     <td>Historischer ermäßigter Steuersatz (§ 12 Abs. 2 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>21</td>
 *     <td>16,00%</td>
 *     <td>Historischer allgemeiner Steuersatz (§ 12 Abs. 1 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>22</td>
 *     <td>5,00%</td>
 *     <td>Historischer ermäßigter Steuersatz (§ 12 Abs. 2 UStG)</td>
 *   </tr>
 *   <tr>
 *     <td>bis 999</td>
 *     <td></td>
 *     <td>reserviert für Änderungen DSFinV-K</td>
 *   </tr>
 *   <tr>
 *     <td>ab 1000</td>
 *     <td></td>
 *     <td>individuelle Sachverhalte (Altsteuersätze, § 13b UStG, o.ä.)</td>
 *   </tr>
 * </table>
 *
 * <h3>Verwendung der ID 7</h3>
 * In vielen Kassensystemen ist es technisch nicht möglich - bei späterem Zahlungseingang (Forderungsauflösung) - die Beträge getrennt nach USt-Sätzen darzustellen.
 * <p/>
 * Für Unternehmer, die ihren Gewinn gemäß § 4 Abs. 3 EStG ermitteln (Einnahme-Überschussrechner) und/oder Unternehmer, die eine Versteuerung nach vereinnahmten Entgelten gemäß § 20 UStG durchführen, wären diese Kassensysteme nicht zur Einnahmeerfassung nutzbar, da z. B. die Bezahlung von Lieferscheinen oder bestehenden Forderungen an der Kasse umsatzsteuerlich nicht korrekt dargestellt werden könnte.
 * <p/>
 * Damit auch diese Kassensysteme verwendet werden können, bietet die DSFinV-K die folgende Lösung, welche die Umsatzsteuer bereits zum Zeitpunkt der Warenbewegung und nicht erst zum Zeitpunkt der Zahlung auslöst:
 * <p/>
 * Die ID 7 dient der Kennzeichnung von Forderungsauflösungen, deren umsatzsteuerliche Zuordnung von der Kasse nicht dargestellt werden kann.
 * Wird die ID 7 eingesetzt, ist dies im Kassenabschluss im Datenfeld KEINE_UST_ZUORDNUNG zu dokumentieren.
 * <p/>
 * In diesen Fällen ist seitens der Finanzverwaltung folgende Sichtweise zu vertreten:
 * <blockquote>"Wird bei der Versteuerung nach vereinnahmten Entgelten die Umsatzsteuer aus technischen Gründen nicht zum Zeitpunkt der Vereinnahmung, sondern zu einem früheren Zeitpunkt berücksichtigt, z. B. zum Zeitpunkt der Entstehung einer Forde- rung bei Kreditkartenzahlung oder einer Stundung, ist dies nicht zu beanstanden."</blockquote>
 *
 * <h3>Besondere Sachverhalte i. R. d. Umsatzsteuer</h3>
 * Ab der "ID" = 1000 können besondere umsatzsteuerliche Sachverhalte (z. B. Differenzbesteuerung § 25a UStG, Sachverhalte des § 13b UStG) kenntlich gemacht werden.
 * <p/>
 * Diese Sachverhalte müssen durch die Kassenhersteller bzw. Kassenhändler individuell angelegt werden.
 */
@ValidStammUst
public class StammUst extends BaseModel {

  public static final String FILENAME = "vat.csv";

  @Positive
  @NotNull // TODO: This does not seem to work but it's still caught by the @Positive annotation
  @ValidUstSchluessel
  @Column(value = "UST_SCHLUESSEL", type = DataType.Numeric)
  private long ustSchluessel;

  @Digits(integer = Integer.MAX_VALUE, fraction = 2)
  //@NotNull -> TODO This is now optional as of DSFinV-K
  @Column(value = "UST_SATZ", type = DataType.Numeric)
  private BigDecimal ustSatz;

  @Size(max = 55)
  @NotBlank
  @Column(value = "UST_BESCHR", type = DataType.AlphaNumeric)
  private String ustBeschr;

  public long getUstSchluessel() {
    return ustSchluessel;
  }

  public void setUstSchluessel(long ustSchluessel) {
    this.ustSchluessel = ustSchluessel;
  }

  /**
   * Hier wird der Prozentsatz des jeweiligen Umsatzsteuersatzes dokumentiert.
   */
  public BigDecimal getUstSatz() {
    return ustSatz;
  }

  public void setUstSatz(BigDecimal ustSatz) {
    this.ustSatz = ustSatz;
  }

  /**
   * Hier kann die Beschreibung der unterschiedlichen Steuersätze dokumentiert werden, z. B. "Allgemeiner Steuersatz", "ermäßigter Steuersatz".
   * Zusätzlich können individuelle Anpassungen vorgenommen werden.
   */
  public String getUstBeschr() {
    return ustBeschr;
  }

  public void setUstBeschr(String ustBeschr) {
    this.ustBeschr = ustBeschr;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StammUst.class.getSimpleName() + "[", "]")
      .add("ustSchluessel=" + ustSchluessel)
      .add("ustSatz=" + ustSatz)
      .add("ustBeschr='" + ustBeschr + "'")
      .add("zKasseId='" + getzKasseId() + "'")
      .add("zErstellung=" + getzErstellung())
      .add("zNr=" + getzNr())
      .toString();
  }

}
