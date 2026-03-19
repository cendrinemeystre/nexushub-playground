package com.nexushub.playground.minesweeper;

import java.util.Scanner;

public class GuiService {
  private final Scanner scanner = new Scanner(System.in);

  public void printInstruction(char currentPlayer) {
    System.out.print(currentPlayer + " its your turn [line,column]: ");
  }

  public void printWon(char currentPlayer, Map map) {
    System.out.println();
    System.out.println();
    System.out.println();
    printMap(map);
    System.out.println(currentPlayer + " has won");
  }

  public void printMap(Map map) {
    System.out.println("-------");
    for (char[] line : map.getMap()) {
      System.out.print("|");
      for (char c : line) {
        System.out.print(c + "|");
      }
      System.out.println("\n-------");
    }
  }

  public int[] readInput() {
    String input = scanner.nextLine();
    String[] split = input.split(",");
    int i = Integer.parseInt(split[0]);
    int j = Integer.parseInt(split[1]);
    return new int[]{i, j};
  }

}
