package com.nexushub.playground.minesweeper.console;


import com.nexushub.playground.minesweeper.spiel.Spielfeld;
import com.nexushub.playground.minesweeper.spiel.Status;

/**
 * Die Benutzerschnittstelle kümmert sich um alles, was mit der Konsole zu tun hat.
 * Alle Konsolen Ausgaben sowie die Benutzer Eingaben werden hier behandelt und weitergegeben.
 *
 * @author Cendrine Meystre
 * @version 1.0
 */
public class Benutzerschnittstelle {
  private static final String LINE_BREAK = "\n";

  private static final String LEERER_STRING = "";

  private static final String SPACE = " ";

  private static final String INDENT = SPACE.repeat(2);

  private static final String START_VOM_SPIELFELD = SPACE.repeat(3);

  private static final String SPIEL_ENDE = "DU HAST VERLOREN!" + LINE_BREAK + "Du bist auf eine Mine gestanden!";

  private static final String SPIEL_GEWONNEN = "DU HAST GEWONNEN!" + LINE_BREAK + "Gratulation!";

  private static final String FEHLERMELDUNG_1 = "Deine Eingabe {} war nicht Korrekt. Probiere es nochmals.";

  private static final String FEHLERMELDUNG_2 = "Deine Eingabe {1} und {2} war nicht Korrekt. Probiere es nochmals.";

  private static final String FRAGE_SPIELFELD_GROESSE = "Wie gross soll das Spielfeld sein? Es muss zwischen 5 - 10 sein. Das Spielfeld ist Quadratisch." + LINE_BREAK;

  private static final String FRAGE_BOMBEN_ANZAHL = "Wie viele Bomben willst du haben?" + LINE_BREAK + "Wenn eine kleinere Zahl als 5 angegeben wird, dann wird es automatisch auf 5 gesetzt. Maximal können 10 Bomben weniger als Zellen vorhanden sind platziert werden." + LINE_BREAK;

  private static final String ANLEITUNG = "Geben Sie ein Kommando ein:" + LINE_BREAK
    + "Txy (z.B. T23 testet Feld Zeile 2, Spalte 3 auf Mine)" + LINE_BREAK
    + "Vxy (z.B. T23 verdeckt Feld Zeile 2, Spalte 3 wieder, wenn es zuvor Markiert wurde)" + LINE_BREAK
    + "Mxy (z.B. M61 kehrt Markierung Feld Zeile 6, Spalte 1)" + LINE_BREAK;


  public int x;

  public int y;

  private int groesse;

  public Status status = Status.VERDECKT;

  /**
   * Der GameOver Text wird angezeigt.
   **/
  public void druckSpielEnde() {
    IO.println(SPIEL_ENDE);
  }

  /**
   * Der GameWon Text wird angezeigt.
   **/
  public void druckSpielGewonnen() {
    IO.println(SPIEL_GEWONNEN);
  }

  /**
   * Die Fehlermeldung wird angezeigt abhängig davon, ob es zwei oder eine falsche Eingabe ist.
   *
   * @param fehler  String der ersten falschen Eingabe.
   * @param fehler2 String der zweiten falschen Eingabe.
   *
   **/
  public void druckFehlermeldung(String fehler, String fehler2) {
    if (fehler2.isEmpty()) {
      IO.println(FEHLERMELDUNG_1.replace("{}", fehler));
    } else {
      IO.println(FEHLERMELDUNG_2.replace("{1}", fehler).replace("{2}", fehler2));
    }
  }

  /**
   * Der Anleitungstext wird angezeigt. Dazu wird die Antwort des Benutzers entgegengenommen und ausprobiert.
   **/
  public void druckAnleitung() {
    String input = IO.readln(ANLEITUNG).toLowerCase();
    IO.println();

    try {
      x = Character.getNumericValue(input.charAt(1));
      y = Character.getNumericValue(input.charAt(2));
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(input.charAt(1)), String.valueOf(input.charAt(2)));
      druckAnleitung();
    } catch (StringIndexOutOfBoundsException e) {
      druckFehlermeldung(String.valueOf(input.charAt(0)), LEERER_STRING);
      druckAnleitung();
    }

    switch (input.charAt(0)) {
      case 't' -> status = Status.AUFGEDECKT;
      case 'm' -> status = Status.MARKIERT;
      case 'v' -> status = Status.VERDECKT;
      default -> {
        druckFehlermeldung(String.valueOf(input.charAt(0)), LEERER_STRING);
        druckAnleitung();
      }
    }
  }

  /**
   * Fragt den Benutzer nach der gewünschten Bombenanzahl. Der Input wird
   * direkt überprüft, ob es ein Integer ist, wenn nicht, muss der Benutzer es nochmals eingeben.
   *
   * @return die Anzahl Bomben.
   *
   **/
  public int fragBombenAnzahl() {
    int anzahl = 5;
    try {
      anzahl = Integer.parseInt(IO.readln(FRAGE_BOMBEN_ANZAHL));
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(anzahl), LEERER_STRING);
      fragBombenAnzahl();
    }
    return anzahl;
  }

  public int fragSpielfeldGroesse() {
    try {
      groesse = Integer.parseInt(IO.readln(FRAGE_SPIELFELD_GROESSE));
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(groesse), LEERER_STRING);
      fragSpielfeldGroesse();
    }
    return groesse;
  }

  /**
   * Zeichnet das Spielfeld und den Inhalt der Zellen, falls diese Aufgedeckt sind.
   **/
  public void zeichneSpielfeld(Spielfeld spielfeld) {
    IO.print(START_VOM_SPIELFELD);
    for (int x = 0; x < spielfeld.zellen.length; x++) {
      IO.print(x + INDENT);
    }
    IO.println();
    for (int x = 0; x < spielfeld.zellen.length; x++) {
      IO.print(x + INDENT);
      for (int y = 0; y < spielfeld.zellen.length; y++) {
        IO.print(spielfeld.zellen[x][y].toString());
      }
      IO.println();
    }
    IO.println(LINE_BREAK);
  }
}