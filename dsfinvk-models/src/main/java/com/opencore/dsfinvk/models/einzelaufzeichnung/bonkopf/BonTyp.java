package com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;

@SuppressWarnings("FieldNamingConvention")
public enum BonTyp {

  /**
   * Der Vorgangstyp "Beleg" umfasst alle Vorgänge, die über die Kasse abgeschlossen werden.
   * Der Vorgangstyp umfasst neben der Rechnung (§ 14 UStG) auch Gutschriften und Korrekturrechnungen.
   * <p/>
   * Beim Vorgangstyp "Beleg" sind alle Zahlarten möglich.
   * <p/>
   * Der Vorgangstyp "Beleg" ist immer dann zu wählen, wenn eine Änderung der Vermogenszusammensetzung des Betriebes aus dem Vorgang resultiert.
   */
  Beleg,

  /**
   * Der Vorgangstyp "AVRechnung" hat keine Auswirkung auf weiterverarbeitende Prozesse innerhalb der Kasse.
   * AVRechnung kann genutzt werden, um in der Kasse integrierte Warenwirtschaftssysteme nachvollziehbar abbilden zu können.
   * <p/>
   * Hinweis: Lieferung, Rechnung und Zahlung fallen zeitlich auseinander.
   */
  AVRechnung,

  /**
   * Der Vorgangstyp "AVTransfer" dokumentiert alle Vorgänge, die zwar in der Kasse erfasst, aber für den Abrechnungsprozess nicht weiterverarbeitet werden sollen.
   * Die weitere Verarbeitung dieser Vorgänge erfolgt manuell bzw. aus einem anderen System heraus.
   * <p/>
   * Beispiel:
   * Ein Unternehmen verkauft Ware gegen Lieferschein.
   * <p/>
   * Erhielte der Lieferschein den Vorgangstyp "Beleg", würde der Umsatz sowie die Forderungsentstehung im Kassenabschluss erfasst und ggf. verbucht (abhängig von der Gewinnermittlungsart und der Umsatzversteuerungsart).
   * <p/>
   * Erhält der Lieferschein an der Kasse den Vorgangstyp "AVTransfer", so wird dieser Lieferschein von der Darstellung im Kassenabschluss ausgeschlossen.
   * Der Anwender kann den Lieferschein manuell oder über ein anderes System für die Buchführung aufbereiten.
   */
  AVTransfer,

  /**
   * Der Vorgangstyp "AVBestellung" dokumentiert Bestellungen, die im Kassensystem direkt erfasst und als eigenständiger Vorgang behandelt werden.
   * <p/>
   * Als Bestellungen gelten verbindliche Willenserklärungen von Käufern gegenüber den Verkäufern, Waren oder Dienstleistungen zu festgelegten Bedingungen erwerben zu wol- len.
   * Die Bestellung wird verbindlich, wenn Sie den Empfänger erreicht.
   * Lieferungen oder Leistungen werden im Rahmen des Bestellprozesses noch nicht ausgeführt.
   * <p/>
   * Im Falle einer Zahlung bzw. Anzahlung handelt es sich nicht um einen Vorgang vom Typ "AVBestellung".
   * In diesem Fall ist der Vorgangstyp "Beleg" zu verwenden, da es sich aufgrund der Veränderungen der Vermögenszusammensetzung des Betriebes um einen Geschäftsvorfall handelt.
   */
  AVBestellung,

  /**
   * Der Vorgangstyp "AVTraining" kennzeichnet alle Vorgänge, die zu Übungszwecken durchgefü̈hrt werden (z. B. die Einarbeitung neuer Mitarbeiter/-innen).
   * Es können sämtliche Vorgänge im Trainingsmodus durchgeführt werden.
   * Soll "AVTraining" verwendet werden, ist dies aktiv durch die Kasse anzusteuern.
   * Alle Handlungen des Trainingsmodus müssen dokumentiert, gesondert gekennzeichnet und mittels der DSFinV-K abgebildet werden.
   * Sie haben jedoch keine Auswirkungen auf den Kassenabschluss.
   * <p/>
   * Eine Bezahlung an der Kasse darf im Zusammenhang mit diesem Vorgangstyp nicht erfolgen.
   */
  AVTraining,

  /**
   * Der Vorgangstyp "AVBelegstorno" kennzeichnet alle Vorgänge, die vollständig storniert werden.
   * Die Verwendung ist nur innerhalb eines Kassenabschlusses zulässig.
   * Der Einsatz von AVBelegstorno ist kassensystemabhängig und für die Kassensysteme gedacht, die anstatt einer Gegenbuchung nur ein Storno-Kennzeichen am Originalbeleg verwenden.
   * <p/>
   * Der AVBelegstorno zeigt eine vollständige Stornierung des Originalbelegs an, so dass sämtliche Beträge nicht mehr im Kassenabschluss berücksichtigt werden.
   * <p/>
   * Hinweis: Mit dem AVBelegstorno ist nicht die negative Darstellung eines Beleges gemeint.
   * Hierfür muss weiterhin der Vorgangstyp "Beleg" mit umgekehrten Vorzeichen und ohne Storno-Kennzeichen genutzt werden.
   * Zu beachten ist in diesen Fällen, dass eine Referenz auf den ursprünglichen Vorgang erfolgen muss.
   * <p/>
   * Achtung! Sobald eine TSE an einer Kasse eingesetzt wird, ist es technisch nicht mehr möglich, den Vorgangstyp "AVBelegstorno" korrekt zu verwenden, da jeder Beleg schon vor dem Setzen des Storno-Kennzeichens bereits durch die TSE signiert wurde.
   * Insofern ist ein nachträgliches "Nullen" eines Beleges nicht mehr möglich.
   */
  AVBelegstorno,

  /**
   * Der Vorgangstyp "AVBelegabbruch" kennzeichnet alle Vorgänge, die nach Transaktionsbeginn abgebrochen werden.
   * <p/>
   * Eine tatsächliche Bezahlung darf im Zusammenhang mit diesem Vorgangstyp nicht erfolgen.
   */
  AVBelegabbruch,

  /**
   * Der Vorgangstyp "AVSachbezug" dient der Erfassung der einzelnen Sachbezüge (z. B. Mahlzeiten) von Arbeitnehmern.
   * <p/>
   * Eine Bezahlung an der Kasse darf im Zusammenhang mit diesem Vorgangstyp nicht erfolgen.
   * <p/>
   * Die umsatzsteuerliche Beurteilung erfolgt entsprechend den gesetzlichen Regelungen, muss allerdings gesondert ermittelt gebucht werden.
   * Da es sich hier um einen "Anderen Vorgang" handelt, erfolgt keine automatisierte Weiterverarbeitung.
   * Eine lohnsteuerliche Beurteilung des Vorgangs erfolgt in einem nachgelagerten System (z. B. Lohnbuchhaltung).
   * <p/>
   * Sachbezüge sind grundsätzlich jedem Arbeitnehmer einzeln zuzuordnen.
   * Daher ist der Name oder die Personalnummer des Arbeitnehmers in der Datei “Bonkopf” (transactions.csv) als Kundeninformation anzugeben.
   */
  AVSachbezug,

  /**
   * Der Vorgangstyp "AVSonstige" dient zur Erfassung aller Vorgänge, die hier nicht näher definiert wurden.
   * Wird der Vorgangstyp "AVSonstige" verwendet, ist eine nähere Beschreibung zwingend erforderlich, um die Nachvollziehbarkeit und Prüfbarkeit der Daten zu gewährleisten (siehe "Individualisierung bzw. Tiefergliederung des Vorgangstyps").
   * <p/>
   * Zusätzlich ist zwingend das Feld „BON_NAME“ mit einer individuellen Beschreibung zu füllen.
   */
  AVSonstige

}
