package com.nexushub.playground.clock;

public class PrintService {
  public void print(String[][] list) {
    String trennLinie = "-------------";
    String trennWand = "|";
    System.out.println(trennLinie);
    for (String[] line : list) {
      System.out.print(trennWand);
      for (String letter : line) {
        System.out.print(letter);
      }
      System.out.println(trennWand);
    }
    System.out.println(trennLinie);
  }
}
