package com.ibby.lab.minesweeper;

import com.ibby.lab.minesweeper.console.Benutzerschnittstelle;
import com.ibby.lab.minesweeper.spiel.Spielfeld;
import com.ibby.lab.minesweeper.spiel.Status;

/**
 * Der Ablauf des Spiels wird hier behandelt.
 *
 * @author Cendrine
 * @version 1.0
 */
public class Minesweeper {
  private static Spielfeld spielfeld;

  private static final Benutzerschnittstelle ui = new Benutzerschnittstelle();

  /**
   * Der Ablauf des Spiels findet hier statt.
   **/
  public void geheSpielSchleifeDurch() {
    aufsetzen();
    while (!pruefeObSpielFertig()) {
      ui.zeichneSpielfeld(spielfeld);
      ui.druckAnleitung();
      spielfeld.veraendereStatus(ui.x, ui.y, ui.status);
    }
  }

  /**
   * Alles, was zum Starten des Spiels benötigt wird, wird hier gemacht.
   **/
  private void aufsetzen() {
    int groesse = ui.fragSpielfeldGroesse();
    int anzahl = ui.fragBombenAnzahl();
    spielfeld = new Spielfeld(anzahl, groesse);
  }

  /**
   * Überprüft, ob eine Bombe explodiert ist oder ob alle Bomben markiert
   * wurden und die anderen Zellen aufgedeckt sind. Wenn ja, dann wird true zurückgegeben.
   *
   * @return boolean
   *
   **/
  private boolean pruefeObSpielFertig() {
    int done = 0;
    for (int x = 0; x < spielfeld.zellen.length; x++) {
      for (int y = 0; y < spielfeld.zellen[x].length; y++) {
        if (spielfeld.zellen[x][y].getStatus() == Status.EXPLODIERT) {
          ui.zeichneSpielfeld(spielfeld);
          ui.druckSpielEnde();
          return true;
        }
        if ((spielfeld.zellen[x][y].hatMine() && spielfeld.zellen[x][y].getStatus() == Status.MARKIERT) ||
          (spielfeld.zellen[x][y].getStatus() == Status.AUFGEDECKT)) {
          done++;
        }
      }
    }
    if (done == spielfeld.zellen.length * spielfeld.zellen[0].length) {
      ui.zeichneSpielfeld(spielfeld);
      ui.druckSpielGewonnen();
      return true;
    }
    return false;
  }
}
