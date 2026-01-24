package com.nexushub.playground.spiel;

import com.nexushub.playground.spiel.cell.Mine;
import com.nexushub.playground.spiel.cell.Zelle;

import java.util.Objects;
import java.util.Random;

public class Spielfeld {
  public Zelle[][] zellen;

  private int minenAnzahl;

  /**
   * @param minenAnzahl Integer mit der Eingabe des Benutzers.
   * @author Cendrine
   * Konstruktor. Prüft, ob die minenAnzahl zwischen 5 und 50 ist.
   * Ist dem nicht so, wird dies auf das Mininum resp. das Maximum
   * gesetzt. Das zellen Array wird mit neuen Zellen gefüllt.
   *
   **/
  public Spielfeld(int minenAnzahl, int groesse) {
    int min = 5;
    int maxGroesse = 10;
    if (groesse < min) {
      this.zellen = new Zelle[min][min];
    } else if (groesse > maxGroesse) {
      this.zellen = new Zelle[maxGroesse][maxGroesse];
    } else {
      this.zellen = new Zelle[groesse][groesse];
    }

    int maxBomben = (int) Math.pow(groesse, 2) - 10;
    if (minenAnzahl < min) {
      this.minenAnzahl = min;
    } else this.minenAnzahl = Math.min(minenAnzahl, maxBomben);

    for (int i = 0; i < zellen.length; i++) {
      for (int j = 0; j < zellen[i].length; j++) {
        zellen[i][j] = new Zelle();
        zellen[i][j].setStatus(Status.VERDECKT);
      }
    }
    setzeMinen();
    setzeZahl();
  }

  /**
   * Setzt alle Minen nach dem Zufallsprinzip.
   *
   **/
  private void setzeMinen() {
    Random random = new Random();
    int minen = minenAnzahl;
    for (int i = 0; i < minenAnzahl; i++) {
      int x = random.nextInt(zellen.length);
      int y = random.nextInt(zellen[0].length);
      if (!zellen[x][y].hatMine()) {
        zellen[x][y].setMine(new Mine());
        minen--;
      } else {
        minenAnzahl = minen;
        setzeMinen();
      }
    }
  }

  /**
   * Zählt wie viele Bomben sich um eine Zelle befinden und setzt diesen Wert in der Zelle.
   **/
  private void setzeZahl() {
    for (int x = 0; x < zellen.length; x++) {
      for (int y = 0; y < zellen[x].length; y++) {
        int count = 0;
        if (!zellen[x][y].hatMine()) {
          if (x == 0 && y == 0) { // Ecke oben Links
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y + 1].hatMine()) {
              count++;
            }
          } else if (x == 0 && y == zellen[0].length - 1) { // Ecke unten Links
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
          } else if (x == zellen.length - 1 && y == 0) { // Ecke oben Rechts
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
          } else if (x == zellen.length - 1 && y == zellen[0].length - 1) { //Ecke unten Rechts
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
          } else if (x == 0) { // linke Wand
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y - 1].hatMine()) {
              count++;
            }
          } else if (y == 0) { // Obere Wand
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y + 1].hatMine()) {
              count++;
            }
          } else if (x == zellen.length - 1) { // Rechte Wand
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y + 1].hatMine()) {
              count++;
            }
          } else if (y == zellen[0].length - 1) { // Untere Wand
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y - 1].hatMine()) {
              count++;
            }
          } else { // Mitte
            if (zellen[x + 1][y].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y].hatMine()) {
              count++;
            }
            if (zellen[x][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x + 1][y - 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y + 1].hatMine()) {
              count++;
            }
            if (zellen[x - 1][y - 1].hatMine()) {
              count++;
            }
          }
          zellen[x][y].setOutput(count);
        }
      }
    }
  }

  /**
   * Deckt die angegebene Koordinate auf, wenn es keine Mine ist und sie verdeckt ist.
   *
   * @param x Integer welcher die Position x entgegennimmt.
   * @param y Integer welcher die Position y entgegennimmt.
   *
   **/
  private void deckeKoordinateAuf(int x, int y) {
    if (!zellen[x][y].hatMine() && zellen[x][y].getStatus() == Status.VERDECKT) {
      zellen[x][y].setStatus(Status.AUFGEDECKT);
      if (zellen[x][y].getOutput() == 0) {
        deckeUmgebendeKoordinatenAuf(x, y);
      }
    }
  }

  /**
   * Deckt alle Umgebenden Koordinaten auf.
   *
   * @param x Integer welcher die Position x entgegennimmt.
   * @param y Integer welcher die Position y entgegennimmt.
   *
   **/
  private void deckeUmgebendeKoordinatenAuf(int x, int y) {
    if (x == 0 && y == 0) { // Ecke oben Links
      deckeKoordinateAuf(x + 1, y);
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x + 1, y + 1);
    } else if (x == 0 && y == zellen[0].length - 1) { // Ecke unten Links
      deckeKoordinateAuf(x, y - 1);
      deckeKoordinateAuf(x + 1, y - 1);
      deckeKoordinateAuf(x + 1, y);
    } else if (x == zellen.length - 1 && y == 0) { // Ecke oben Rechts
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x - 1, y + 1);
      deckeKoordinateAuf(x - 1, y);
    } else if (x == zellen.length - 1 && y == zellen[0].length - 1) { //Ecke unten Rechts
      deckeKoordinateAuf(x - 1, y);
      deckeKoordinateAuf(x - 1, y - 1);
      deckeKoordinateAuf(x, y - 1);
    } else if (x == 0) { // linke Wand
      deckeKoordinateAuf(x + 1, y);
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x + 1, y + 1);
      deckeKoordinateAuf(x, y - 1);
      deckeKoordinateAuf(x + 1, y - 1);
    } else if (y == 0) { // Obere Wand
      deckeKoordinateAuf(x + 1, y);
      deckeKoordinateAuf(x - 1, y);
      deckeKoordinateAuf(x + 1, y + 1);
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x - 1, y + 1);
    } else if (x == zellen.length - 1) { // Rechte Wand
      deckeKoordinateAuf(x, y - 1);
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x - 1, y - 1);
      deckeKoordinateAuf(x - 1, y);
      deckeKoordinateAuf(x - 1, y + 1);
    } else if (y == zellen[0].length - 1) { // Untere Wand
      deckeKoordinateAuf(x + 1, y);
      deckeKoordinateAuf(x - 1, y);
      deckeKoordinateAuf(x + 1, y - 1);
      deckeKoordinateAuf(x, y - 1);
      deckeKoordinateAuf(x - 1, y - 1);
    } else { // Mitte
      deckeKoordinateAuf(x + 1, y);
      deckeKoordinateAuf(x - 1, y);
      deckeKoordinateAuf(x, y + 1);
      deckeKoordinateAuf(x, y - 1);
      deckeKoordinateAuf(x + 1, y + 1);
      deckeKoordinateAuf(x + 1, y - 1);
      deckeKoordinateAuf(x - 1, y + 1);
      deckeKoordinateAuf(x - 1, y - 1);
    }
  }


  /**
   * Aktualisiert die angegebene Zelle auf den gewünschten Status.
   * Es können nur die Status MARKIERT und VERDECKT verändert werden.
   *
   * @param x      Integer welcher die Position x entgegennimmt.
   * @param y      Integer welcher die Position y entgegennimmt.
   * @param status auf welchen Status die Zelle aktualisiert werden soll.
   *
   **/
  public void veraendereStatus(int x, int y, Status status) {
    if (zellen[x][y].getStatus() == Status.MARKIERT ||
      zellen[x][y].getStatus() == Status.VERDECKT &&
        (Objects.requireNonNull(zellen[x][y].getStatus()) == Status.MARKIERT ||
          zellen[x][y].getStatus() == Status.VERDECKT)) {
      zellen[x][y].setStatus(status);
    }

    if (zellen[x][y].getOutput() == 0 && zellen[x][y].getStatus() == Status.AUFGEDECKT && !zellen[x][y].hatMine()) {
      deckeUmgebendeKoordinatenAuf(x, y);
    }

    if (zellen[x][y].hatMine() && zellen[x][y].getStatus() == Status.AUFGEDECKT) {
      zellen[x][y].setStatus(Status.EXPLODIERT);
    }
  }
}
