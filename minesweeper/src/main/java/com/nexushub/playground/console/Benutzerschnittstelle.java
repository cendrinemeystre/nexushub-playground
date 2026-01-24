package com.nexushub.playground.console;


import com.nexushub.playground.spiel.Spielfeld;
import com.nexushub.playground.spiel.Status;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Die Benutzerschnittstelle kümmert sich um alles was mit der Konsole zu tun hat.
 * Alle Konsolen Ausgaben sowie die Benutzer Eingaben werden hier behandelt und weitergegeben.
 *
 * @author Cendrine
 * @version 1.0
 */
public class Benutzerschnittstelle {
  private static PrintStream out = System.out;

  private static Scanner scanner = new Scanner(System.in);

  public int x;

  public int y;

  private int groesse;

  public Status status = Status.VERDECKT;

  /**
   * Konstruktor.
   *
   * @param out PrintStream damit es generisch ist und nicht auf die Konsole fixiert ist.
   **/
  public Benutzerschnittstelle(PrintStream out) {
    this.out = out;
  }

  /**
   * Der GameOver Text wird angezeigt.
   **/
  public void druckSpielEnde() {
    out.println("GAME OVER!\nYou stepped on a mine!");
  }

  /**
   * Der GameWon Text wird angezeigt.
   **/
  public void druckSpielGewonnen() {
    out.println("YOU WON!\nCongratulation!");
  }

  /**
   * Die Fehlermeldung wird angezeigt abhängig davon, ob es zwei oder eine falsche Eingabe ist.
   *
   * @param fehler  String der ersten falschen Eingabe.
   * @param fehler2 String der zweiten falschen Eingabe.
   *
   **/
  public void druckFehlermeldung(String fehler, String fehler2) {
    if (fehler2.equals(null)) {
      out.println("Deine Eingabe " + fehler + " war nicht Korrekt. Probiere es nochmals.");
    } else {
      out.println("Deine Eingabe " + fehler + " und " + fehler2 + " war nicht Korrekt. Probiere es nochmals.");
    }
  }

  /**
   * Der Anleitungs Text wird angezeigt. Dazu wird die Antwort des Benutzers entgegengenommen und ausprobiert.
   **/
  public void druckAnleitung() {
    out.println("Geben Sie ein Kommando ein:\n"
      + "Txy (z.B. T23 testet Feld Zeile 2, Spalte 3 auf Mine)\n"
      + "Vxy (z.B. T23 verdeckt Feld Zeile 2, Spalte 3 wieder, wenn es zuvor Markiert wurde)\n"
      + "Mxy (z.B. M61 kehrt Markierung Feld Zeile 6, Spalte 1)");

    String input = scanner.nextLine().toLowerCase();
    out.println();

    try {
      x = Character.getNumericValue(input.charAt(1));
      y = Character.getNumericValue(input.charAt(2));
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(input.charAt(1)), String.valueOf(input.charAt(2)));
      druckAnleitung();
    }

    switch (input.charAt(0)) {
      case 't' -> status = Status.AUFGEDECKT;
      case 'm' -> status = Status.MARKIERT;
      case 'v' -> status = Status.VERDECKT;
      default -> {
        druckFehlermeldung(String.valueOf(input.charAt(0)), "");
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
    out.println("Wie viele Bomben willst du haben?\nWenn eine kleinere Zahl als 5 angegeben wird, dann wird es automatisch auf 5 gesetzt. Maximal können 10 Bomben weniger als Zellen vorhanden sind platziert werden.");
    try {
      anzahl = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(anzahl), "");
      fragBombenAnzahl();
    }
    return anzahl;
  }

  public int fragSpielfeldGroesse() {
    out.println("Wie gross soll das Spielfeld sein? Es muss zwischen 5 - 10 sein. Das Spielfeld ist Quadratisch.");
    try {
      groesse = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      druckFehlermeldung(String.valueOf(groesse), "");
      fragSpielfeldGroesse();
    }
    return groesse;
  }

  /**
   * Zeichnet das Spielfeld und den Inhalt der Zellen, falls diese Aufgedeckt sind.
   **/
  public void zeichneSpielfeld(Spielfeld spielfeld) {
    out.print("   ");
    for (int x = 0; x < spielfeld.zellen.length; x++) {
      out.print(x + "  ");
    }
    out.println();
    for (int x = 0; x < spielfeld.zellen.length; x++) {
      out.print(x + "  ");
      for (int y = 0; y < spielfeld.zellen.length; y++) {
        out.print(spielfeld.zellen[x][y].toString());
      }
      out.println();
    }
    out.println("\n");
  }
}