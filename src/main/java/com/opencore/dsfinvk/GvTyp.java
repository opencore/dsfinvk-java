package com.opencore.dsfinvk;

@SuppressWarnings("FieldNamingConvention")
public enum GvTyp {
  /**
   * Der Geschäftsvorfalltyp "Umsatz" dokumentiert alle Umsätze auf Ebene des Kassenabschlusses und der Einzelpositionen.
   * Dabei können sofortige Entgeltminderungen wie Skonti oder sonstige Preisnachlässe auf Ebene des Vorgangs und des Kassenabschlusses im Umsatz saldiert dargestellt werden.
   * <p/>
   * Auf Einzelpositionsebene werden sie stets getrennt dargestellt.
   * <p/>
   * Der Geschäftsvorfalltyp Umsatz kann mit allen Umsatzsteuerschlüsseln und Zahlarten verwendet werden.
   */
  Umsatz,

  /**
   * Im Geschäftsvorfalltyp "Pfand" werden alle Pfandeinnahmen aus Handelsgeschäften dargestellt.
   * <p/>
   * Hierbei ist aus umsatzsteuerlicher Sicht zu differenzieren, ob es sich bei Hingabe eines Transportbehältnisses gegen gesondert vereinbartes Pfandgeld, um ein (selbstständiges) Transporthilfsmittel oder lediglich um eine sog. Warenumschließung handelt.
   * Während Transporthilfsmittel grundsätzlich der Vereinfachung des Warentransports und der Lagerung dienen (z. B. Paletten, Kisten), handelt es sich bei Warenumschließungen um innere/äußere Behältnisse, welche für die Lieferungen der Waren an den Endverbraucher notwendig sind (z. B. Flaschen).
   * Die Hingabe von Transporthilfsmitteln gegen Pfandgeld stellt aus umsatzsteuerlicher Sicht eine eigenständige Lieferung dar, die dem allgemeinen Steuersatz gem. § 12 Abs. 1 UStG unterliegt.
   * <p/>
   * Warenumschließungen hingegen teilen im Gegensatz hierzu als sog. unselbstständige Nebenleistung, das Schicksal der eigentlichen Hauptleistung. (z. B. Lieferung von Milch 7% USt - Pfand Milchflasche ebenfalls 7% USt).
   */
  Pfand,

  /**
   * Der Geschäftsvorfalltyp "PfandRueckzahlung" dokumentiert alle Rückgaben von Pfandgegenständen sowie die Verrechnung des Pfandbetrages oder die Auszahlung an den Kunden.
   */
  PfandRueckzahlung,

  /**
   * Der Geschäftsvorfalltyp "Rabatt" umfasst sowohl Rabatte, die sich auf den gesamten Vorgang beziehen (z. B. Zwischensummenrabatte), als auch Rabatte auf einzelne Artikel.
   * <p/>
   * Aus umsatzsteuerlicher Sicht richtet sich der Umsatz bei einer Lieferung oder sonstigen Leistung nach dem Entgelt.
   * Als Entgelt gilt alles, was der Leistungsempfänger aufwendet, um die Leistung zu erhalten. Bei Rabatten handelt es sich grundsätzlich um Entgeltminderungen, die der Leistungsempfänger bei Zahlung abzieht (z. B. Rabatte oder Skonti) oder dem Empfänger werden bereits gezahlte Beträge zurückgewährt, ohne dass er dafür eine Leistung zu erbringen hat (vgl. Abschn. 10.3 UStAE).
   * Die Pflicht zur Anpassung der Umsatzsteuer bzw. Vorsteuer bei Änderungen der Bemessungsgrundlage ergibt sich aus § 17 UStG.
   * Die Anpassung hat gem. § 17 Abs. 1 S. 7 UStG in dem Besteuerungszeitraum zu erfolgen, in welchem die Änderung der Bemessungsgrundlage eingetreten ist.
   */
  Rabatt,

  /**
   * Der Geschäftsvorfalltyp "Aufschlag" umfasst sowohl Aufschläge, die sich auf die Transaktion beziehen, als auch Aufschläge auf einzelne Artikel.
   * Die Abbildung der Aufschläge erfolgt analog zu den Rabatten.
   * <p/>
   * Aus umsatzsteuerlicher Sicht liegen entsprechend den Rabatten grundsätzlich Änderungen des Entgelts, in diesem Fall Erhöhungen, vor, die eine Verpflichtung zur Anpassung der Bemessungsgrundlage i. S. d. § 17 UStG zur Folge haben.
   */
  Aufschlag,

  /**
   * Der Geschäftsvorfalltyp "ZuschussEcht" dient der ertrags- und umsatzsteuerlich zutreffenden Erfassung eines Entgelts von dritter Seite.
   * <p/>
   * Entgelt von dritter Seite liegt in der Regel nur vor, wenn ein unmittelbarer Leistungsaustausch zwischen Zahlungsempfänger (Unternehmer) und dem zahlenden Dritten zu verneinen ist (Abschn. 10.2 Abs. 3 UStAE).
   * Die zugehörige Zahlung dient der Preisauffüllung, wenn sie den erklärten Zweck hat, das Entgelt für die Leistung des Zahlungsempfängers an den Leistungsempfänger (Kunde) auf die nach Kalkulationsgrundsätzen erforderliche Höhe zu bringen und dadurch das Zustandekommen eines Leistungsaustauschs zu sichern oder wenigstens zu erleichtern (Abschn. 10.2 Abs. 5 UStAE).
   * <p/>
   * Auf dem Beleg kann entweder der volle Betrag mit der entsprechenden Umsatzsteuer oder der geminderte Betrag mit der Umsatzsteuer, die auf den vollen Betrag entfällt, ausgewiesen werden (Abschn. 14.10 Abs. 1 UStAE).
   */
  ZuschussEcht,

  /**
   * Der Geschäftsvorfalltyp "ZuschussUnecht" dient der ertrags- und umsatzsteuerlich zutreffenden Erfassung von Entgelt von dritter Seite, sofern es sich nicht um einen Geschäftsvorfall "ZuschussEcht" handelt.
   * <p/>
   * Da ein unmittelbarer Leistungsaustausch zwischen dem Zahlungsempfänger (Unternehmer) und dem zahlenden Dritten besteht, entsteht ein nachträglicher Preisnachlass zum Zeitpunkt der Zahlung von dritter Seite.
   */
  ZuschussUnecht,

  /**
   * Im Geschäftsvorfalltyp "TrinkgeldAG" werden Einnahmen aus Trinkgeldzahlungen an den Arbeitgeber erfasst.
   * Der Vorgang der Vereinnahmung stellt einen separaten Geschäftsvorfall dar.
   * Dies gilt unabhängig davon, ob das Trinkgeld für den Arbeitgeber bzw. den Arbeitnehmer bestimmt ist und welche Zahlart dafür verwendet wird.
   * <p/>
   * Die entsprechenden umsatzsteuerlichen Vorgaben sind zu berücksichtigen und werden gemäß der Zuordnung zu den USt-Schlüsseln verarbeitet.
   * <p/>
   * TrinkgeldAG bezeichnet lediglich den Zufluss in die Kasse.
   * Die Entnahme bzw. der Abfluss erfolgt durch die Geschäftsvorfalltypen Geldtransit bzw. Privatentnahme.
   */
  TrinkgeldAG,

  /**
   * Im Geschäftsvorfalltyp "TrinkgeldAN" werden alle Ein- und Auszahlungen von Trinkgeld an den Arbeitnehmer erfasst.
   * <p/>
   * Da das Trinkgeld für den Arbeitnehmer weder lohnsteuerliche noch umsatzsteuerliche Konsequenzen für den Unternehmer nach sich zieht, ist es möglich, mit diesem Geschäftsvorfalltyp sowohl die Ein- als auch die Auszahlung an den Arbeitnehmer darzustellen.
   */
  TrinkgeldAN,

  /**
   * Der Geschäftsvorfall „EinzweckgutscheinKauf“ umfasst alle Gutscheine, die über bestimmte, konkret bezeichnete Lieferungen oder sonstige Leistungen, bei denen der Ort der Leistung sowie die für diese Umsätze geschuldete Steuer zum Zeitpunkt der Ausstellung des Gutscheins feststehen, ausgestellt werden (§ 3 Abs. 14 UStG).
   * <p/>
   * Da die Lieferung oder sonstige Leistung im Zeitpunkt des Gutscheinverkaufs noch nicht erfolgt ist, wurde aus ertragsteuerlicher Sicht bei der Gewinnermittlung nach § 4 Abs. 1 EStG noch kein Ertrag realisiert, bei der Gewinnermittlung nach § 4 Abs. 3 EStG sind die Einnahmen bereits zum Zeitpunkt des Gutscheinverkaufs aufzuzeichnen.
   * <p/>
   * Umsatzsteuerlich gelten die Lieferung bzw. die sonstige Leistung mit der Übertragung des Gutscheins als erbracht.
   * Es ist der für die zu erbringende Lieferung oder sonstige Leistung anzuwendende Steuersatz auszuweisen (§ 3 Abs. 14 Satz 2 UStG).
   */
  EinzweckgutscheinKauf,

  /**
   * Der Geschäftsvorfall "EinzweckgutscheinEinloesung" umfasst alle Einlösungen von zuvor erworbenen Einzweckgutscheinen.
   * <p/>
   * Um einen Bezug zum ursprünglich ausgestellten Gutschein zu ermöglichen, kann die Gutscheinnummer im Feld GUTSCHEIN_NR angegeben werden.
   */
  EinzweckgutscheinEinloesung,

  /**
   * Der Geschäftsvorfall "MehrzweckgutscheinKauf" umfasst alle Gutscheine, die gegen die Hingabe eines bestimmten Geldbetrags ausgegeben werden und die keine Einzweckgutscheine sind (§ 3 Abs. 15 Satz 1 UStG).
   * <p/>
   * Aus umsatzsteuerlicher Sicht ist die Ausgabe eines Mehrzweckgutscheins nicht steuerbar (§ 3 Abs. 15 Satz 2 UStG).
   * Es handelt sich um ein zahlungsmittelähnliches Instrument.
   * Eine Anzahlung gem. § 13 Abs. 1 S. 1 Nr. 1 Buchst. a S. 4 UStG scheidet wegen des fehlenden konkreten Leistungszusammenhangs aus.
   * Im Zeitpunkt der Ausgabe eines Mehrzweckgutscheins ist somit eine Rechnung ohne Umsatzsteuerausweis zu erfassen.
   */
  MehrzweckgutscheinKauf,

  /**
   * Der Geschäftsvorfalltyp "MehrzweckgutscheinEinloesung" umfasst alle Einlösungen von zuvor erworbenen Mehrzweckgutscheinen.
   * <p/>
   * Um einen Bezug zum ursprünglich ausgestellten Gutschein zu ermöglichen, kann die Gutscheinnummer im Feld GUTSCHEIN_NR angegeben werden.
   */
  MehrzweckgutscheinEinloesung,

  /**
   * Der Geschäftsvorfalltyp "Forderungsentstehung" dient der Erfassung von Transaktionen in einer Kasse, bei denen die Warenbewegung bereits erfolgt ist, jedoch die Zahlung zu einem späteren Zeitpunkt erfolgen soll (wahlweise über ein nachgelagertes System oder in der Kasse).
   * <p/>
   * Die umsatzsteuerlich zutreffenden Konsequenzen sind grundsätzlich in der Kasse zu erfüllen.
   * Ist eine Kasse nicht in der Lage, die zutreffenden umsatzsteuerlichen Konsequenzen darzustellen, sind die Transaktionen mit dem Umsatzsteuerschlüssel (ID) 7 zu kennzeichnen (siehe Ausführungen im Kapitel 3.2.6 Datei: Stamm_USt).
   * TODO: Fix reference once StammUst exists
   */
  Forderungsentstehung,

  /**
   * Der Geschäftsvorfalltyp "Forderungsaufloesung" umfasst den Ausgleich von entstandenen Forderungen.
   * <p/>
   * Um einen Bezug zur ursprünglichen Forderung zu ermöglichen, ist in den dafür vorgesehenen Feldern eine Referenzierung auf den Ursprungsbeleg (mit der Forderungsentstehung) aufzuzeichnen.
   *
   * <ul>
   *   <li>Auflösung einer Forderung, die in der Kasse erfasst wurde:
   *   In der Datei „Bon_Referenzen“ (references.csv) sind mindestens die Felder REF_TYP mit dem Wert "Transaktion", REF_Z_NR, REF_Z_KASSE_ID und REF_BON_ID zu füllen.</li>
   *   <li>Auflösung einer Forderung, die in einem externen Aufzeichnungssystem erfasst wurde:
   *   In der Datei "Bon_Referenzen" (references.csv) sind mindestens die Felder REF_TYP mit einem der Werte "ExterneRechnung", "ExternerLieferschein" oder "Ex- terneSonstige" (nähere Erläuterung dazu im Feld REF_NAME), und REF_BON_ID zu füllen.</li>
   * </ul>
   */
  Forderungsaufloesung,

  /**
   * Der Geschäftsvorfalltyp "Anzahlungseinstellung" dient der Erfassung von Vorgängen in einer Kasse, bei denen die Zahlung bereits erfolgt ist, jedoch die Warenbewegung erst zu einem späteren Zeitpunkt erfolgen soll.
   * <p/>
   * Nach § 13 Abs. 1 Nr. 1 Satz 1 Buchst. a Satz 4 UStG entsteht die Steuer, in den Fällen, in denen das Entgelt oder ein Teil des Entgelts vor Ausführung der Leistung oder Teilleistung gezahlt wird, bereits mit dessen Vereinnahmung.
   * Als Zeitpunkt der Vereinnahmung gilt bei Bargeschäften der Zahlungszeitpunkt, bei Banküberweisungen der Zeitpunkt der Gutschrift auf dem Empfängerkonto.
   * Die Umsatzversteuerung erfolgt bei Anzahlungen im Rahmen der Umsatzsteuervoranmeldung zum Zeitpunkt der Vereinnahmung.
   */
  Anzahlungseinstellung,

  /**
   * Der Geschäftsvorfalltyp "Anzahlungsaufloesung" dient der Auflösung von Anzahlungen bei erfolgter Warenbewegung und Ausgleich des noch offenen Betrags.
   * <p/>
   * Um einen Bezug zur ursprünglichen Anzahlung zu ermöglichen, sind die Felder – wie unter dem Geschäftsvorfalltyp {@link GvTyp#Forderungsaufloesung} beschreiben – zu füllen
   */
  Anzahlungsaufloesung,

  // Die folgenden Typen betreffen ausschließlich den Kassenstand

  /**
   * Der Geschäftsvorfalltyp "Anfangsbestand" stellt den Bargeldbestand der Kasse zu Beginn des jeweiligen Abrechnungszeitraums (untertägig möglich) dar.
   * Dabei wird der Anfangsbestand für die DSFinV-K zur Verfügung gestellt und ist dadurch sowohl bei den einzelnen Vorgängen als auch zur Dokumentation im Kassenabschluss relevant.
   * <p/>
   * Unter dem Geschäftsvorfalltyp Anfangsbestand wird ausschließlich der Bargeldbestand, welcher zum Zeitpunkt der Eröffnung der Kasse bereits in der Kasse vorhanden ist, erfasst.
   * <p/>
   * Wird im Rahmen des vorhergehenden Kassenabschlusses das Bargeld vollständig entnommen, beträgt der Anfangsbestand 0,00 in der Basiswährung.
   * Das Auffüllen des Bargeldbestandes ist über den Geschäftsvorfalltyp "Geldtransit" zu erfassen.
   * <p/>
   * Der Geschäftsvorfall "Anfangsbestand" einer Kasse verändert nicht die Vermögenszusammensetzung eines Unternehmens.
   * <p/>
   * Eine Erfassung ist nicht zwingend erforderlich.
   */
  Anfangsbestand,

  /**
   * Der Geschäftsvorfalltyp "Privatentnahme" dokumentiert die Entnahme von Bargeld des Unternehmers aus der Kasse zu privaten Zwecken.
   * <p/>
   * Ertragsteuerlich gelten als Entnahmen gem. § 4 Abs. 1 S. 2 EStG alle Wirtschaftsgüter, die der steuerpflichtige Unternehmer dem Betrieb im Laufe des Wirtschaftsjahres für sich, für seinen Haushalt oder für andere betriebsfremde Zwecke entnimmt.
   * Entnahmen dürfen den Gewinn nicht mindern und sind im Rahmen der Gewinnermittlung hinzuzurechnen.
   * <p/>
   * Die Bewertung einer Entnahme hat mit dem Teilwert zu erfolgen, welcher im Falle von Barentnahmen aus der Kasse grundsätzlich dem Nennwert entspricht.
   * <p/>
   * Aus umsatzsteuerlicher Sicht handelt es sich bei der Privatentnahme von Barmitteln um Geschäftsvorfälle ohne USt-Bezug.
   * Sachentnahmen werden grundsätzlich einer Lieferung gegen Entgelt gleichgestellt (§ 3 Abs. 1b UStG), sofern diese entnommenen Gegenstände bei Bezug zum vollen oder teilweisen Vorsteuerabzug berechtigt haben.
   */
  Privatentnahme,

  /**
   * Der Geschäftsvorfalltyp "Privateinlage" dokumentiert die Einlage von Bargeld aus der Privatsphäre des Unternehmers in die Kasse.
   * Auch die Begleichung von Betriebsausgaben aus privaten Mitteln stellt eine Form der Bareinlage dar.
   * <p/>
   * Ertragsteuerlich sind nach § 4 Abs. 1 S. 8 EStG als Einlagen alle Wirtschaftsgüter zu erfassen, die der steuerpflichtige Unternehmer dem Betrieb im Laufe des Wirtschaftsjahres zugeführt hat.
   * Die in diesem Zusammenhang zu fordernde Einlagefähigkeit des zugeführten Wirtschaftsguts ist im Falle von Bareinlagen stets gegeben.
   * Einlagen dürfen den Gewinn nicht beeinflussen und sind daher im Rahmen der Gewinnermittlung zu kürzen.
   * Die Bewertung der Einlage hat mit dem Teilwert zu erfolgen, der im Falle von Bareinlagen grundsätzlich dem Nennwert entspricht.
   * <p/>
   * Aus umsatzsteuerlicher Sicht handelt es sich bei der Privateinlage von Barmitteln um Geschäftsvorfälle ohne USt-Bezug (ID 5).
   */
  Privateinlage,

  /**
   * Der Geschäftsvorfalltyp "Geldtransit" bezeichnet die vollständige oder teilweise Entnahme / Einlage von Bargeld und Schecks während oder am Ende des Tages, um es z. B. zur Bank oder in einen Tresor zu bringen.
   * Zusätzlich dient der Geschäftsvorfall der Darstellung von Bargeldverschiebungen zwischen einzelnen Kassen.
   * <p/>
   * Bei einer Überführung in einen privaten Bereich ist der Geschäftsvorfalltyp "Privatentnahme" zu verwenden.
   * Der Geschäftsvorfalltyp "Geldtransit" hat aus umsatzsteuerlicher Sicht keine Relevanz.
   */
  Geldtransit,

  /**
   * Der Geschäftsvorfalltyp "Lohnzahlung" bildet eine (Teil-)Zahlung des Lohnes aus der Kasse (z. B. Lohnvorschuss) vom Arbeitgeber an den Arbeitnehmer ab.
   */
  Lohnzahlung,

  /**
   * Der Geschäftsvorfalltyp "Einzahlung" dient dazu, Geschäftsvorfälle in Form eines Zuflusses, die durch die Standard-Felder der DSFinV-K nicht abgebildet werden können, aufzuzeichnen und darzustellen.
   * Diese Zuflüsse müssen anschließend im Kassenbuch oder den sonstigen erforderlichen Aufzeichnungen für Zwecke der Einzelaufzeichnung noch weiter differenziert und dokumentiert werden.
   * <p/>
   * Die ertrag- und umsatzsteuerliche Qualifikation der hier erfassten Einzahlungen ist bezogen auf den jeweiligen Sachverhalt zu prüfen, die jeweiligen steuerlichen Konsequenzen sind zu ziehen und zu dokumentieren.
   */
  Einzahlung,

  /**
   * Der Geschäftsvorfalltyp "Auszahlung" dient dazu, Geschäftsvorfälle in Form eines Abflusses, die durch die Standard-Felder der DSFinV-K nicht abgebildet werden können, aufzuzeichnen und darzustellen.
   * Diese Abflüsse müssen anschließend im Kassenbuch oder den sonstigen erforderlichen Aufzeichnungen für Zwecke der Einzelaufzeichnung noch weiter differenziert und dokumentiert werden.
   * <p/>
   * Die ertrag- und umsatzsteuerliche Qualifikation der hier erfassten Auszahlungen ist bezogen auf den jeweiligen Sachverhalt zu prüfen, die jeweiligen steuerlichen Konsequenzen sind zu ziehen und ggf. in nachgelagerten Systemen zu dokumentieren.
   */
  Auszahlung,

  /**
   * Der Geschäftsvorfall "DifferenzSollIst" stellt die Abweichung zwischen einem errechneten und dem gezählten Kassenbestand dar, der bei Überprüfung der Kassensturzfähigkeit bzw. beim Kassensturz auftreten kann.
   * Differenzen können so festgestellt, protokolliert und ausgeglichen werden.
   * Es kann sich sowohl um Fehlbeträge als auch um positive Differenzen handeln.
   * <p/>
   * Diese Differenzen müssen im Kassenbuch oder den sonstigen erforderlichen Aufzeichnungen weiter differenziert und dokumentiert werden.
   * <p/>
   * Die ertrag- und umsatzsteuerliche Qualifikation der Differenzen ist bezogen auf den jeweiligen Sachverhalt zu prüfen, die jeweiligen steuerlichen Konsequenzen sind zu ziehen und ggf. in nachgelagerten Systemen zu dokumentieren.
   */
  DifferenzSollIst
}
