package com.nexushub.playground.minesweeper.spiel.cell;

import com.nexushub.playground.minesweeper.spiel.Status;

public class Zelle {
  private Mine mine;

  private Status status;

  private int ausgabe;

  /**
   * Der Output der Zelle wird ausgegeben.
   **/
  @Override
  public String toString() {
    return switch (status) {
      case MARKIERT -> "!  ";
      case AUFGEDECKT -> ausgabe + "  ";
      case EXPLODIERT -> "*  ";
      default -> "   ";
    };
  }

  /**
   * Überprüft, ob die Zelle eine Mine besitzt.
   *
   * @return boolean
   *
   **/
  public boolean hatMine() {
    return this.mine != null;
  }

  public void setMine(Mine mine) {
    this.mine = mine;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setOutput(int output) {
    this.ausgabe = output;
  }

  public int getOutput() {
    return this.ausgabe;
  }
}
