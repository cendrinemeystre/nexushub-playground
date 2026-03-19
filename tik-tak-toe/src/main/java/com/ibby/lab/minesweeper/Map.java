package com.ibby.lab.minesweeper;

import java.util.Arrays;

public class Map {
  private final char[][] map;

  public Map() {
    map = new char[3][3];
    for (char[] chars : map) {
      Arrays.fill(chars, ' ');
    }
  }

  public void setField(int i, int j, char player) {
    this.map[i][j] = player;
  }

  public boolean validateInput(int i, int j) {
    if (i > 2 || j > 2 || i < 0 || j < 0) {
      System.out.println("This is not a valid input min 0 and max 2");
      return false;
    }
    if (map[i][j] != ' ') {
      System.out.println("This field is already set");
      return false;
    }
    return true;
  }

  public boolean hasWon() {
    for (char[] line : map) {
      char p = line[0];
      if (line[1] == p && line[2] == p && p != ' ') {
        return true;
      }
    }

    for (int j = 0; j < map[0].length; j++) {
      char p = map[0][j];
      if (map[1][j] == p && map[2][j] == p && p != ' ') {
        return true;
      }
    }

    char middle = map[1][1];
    return ((middle == map[0][0] && map[2][2] == middle) || (middle == map[0][2] && map[2][0] == middle)) && middle != ' ';
  }

  public char[][] getMap() {
    return map;
  }
}
