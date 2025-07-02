package com.nexushub.playground;

public class TikTakToe {
  public static final char X = 'X';

  public static final char O = 'O';

  private final Map map;

  private final GuiService guiService;

  public TikTakToe() {
    map = new Map();
    guiService = new GuiService();
  }

  public void game() {
    boolean hasWon = false;
    char currentPlayer = O;
    do {
      guiService.printMap(map);
      guiService.printInstruction(currentPlayer);
      int[] input = guiService.readInput();
      int i = input[0];
      int j = input[1];
      if (map.validateInput(i, j)) {
        map.setField(i, j, currentPlayer);
        hasWon = map.hasWon();
        currentPlayer = updatePlayer(currentPlayer, hasWon);
      }
    } while (!hasWon);
    guiService.printWon(currentPlayer, map);
  }

  private char updatePlayer(char currentPlayer, boolean hasWon) {
    if (hasWon) {
      return currentPlayer;
    }
    return currentPlayer == O ? X : O;
  }
}
