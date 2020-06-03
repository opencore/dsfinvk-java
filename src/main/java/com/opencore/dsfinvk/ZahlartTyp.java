package com.opencore.dsfinvk;

@SuppressWarnings("FieldNamingConvention")
public enum ZahlartTyp {

  /**
   * Die Zahlart "Bar" bildet alle Bargeldbewegungen innerhalb einer Kasse ab.
   */
  Bar,

  /**
   * Die Zahlart "Unbar" bildet alle Sachverhalte ohne Bargeldbewegung ab.
   * Dabei ist die Zahlart "Unbar" als eine zusammenfassende Form für alle unbaren Zahlarten anzusehen.
   * Dies ist eine Lösungsmöglichkeit für Kassen, die die unbaren Zahlarten nicht weiter differenzieren können.
   */
  Unbar,

  /**
   * Die Zahlart "Keine" steht für Vorgänge, die mit keiner Zahlung abgeschlossen werden (z. B. Lieferscheine, Bestellungen, vollständig mit Ein- oder Mehrzweckgutschein bezahlte Leistung).
   */
  Keine,

  /**
   * Die Zahlart "ECKarte" stellt alle über die Verwendung einer EC-Karte vereinnahmten bzw. verausgabten Zahlungen dar.
   * Der Begriff "EC-Karte" in der DSFinV-K steht für "Debit- Karten" (also insbesondere girocard, Maestro etc.).
   */
  ECKarte,

  /**
   * Die Zahlart "Kreditkarte" stellt alle über die Verwendung einer Kreditkarte vereinnahmten bzw. verausgabten Zahlungen dar.
   */
  Kreditkarte,

  /**
   * Die Zahlart "ElZahlungsdienstleister" stellt alle über elektronischen Zahlungsdienstleistern vereinnahmten bzw. verausgabten Zahlungen dar.
   */
  ElZahlungsdienstleister,

  /**
   * Bei der Zahlart "Guthabenkarte" werden alle Zahlungen erfasst, die mit einem zuvor auf ein entsprechendes Medium aufgeladenem Guthaben getätigt werden.
   */
  Guthabenkarte

}
