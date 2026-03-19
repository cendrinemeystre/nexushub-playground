package com.nexushub.playground.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Hangman {
  private String word;

  private String hiddenWord;

  public void chooseWord(boolean german) {
    String filename = german ? "/de.txt" : "/en.txt";
    try (InputStream is = Main.class.getResourceAsStream(filename);
         BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Random rand = new Random();
      String line = reader.readLine();
      String[] split = line.split(";");
      this.word = split[rand.nextInt(line.length())];
      this.hiddenWord = "*".repeat(this.word.length());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void checkInput(char input) {
    if (word.contains(String.valueOf(input))) {
      String[] split = this.hiddenWord.split("");
      for (int i = 0; i < hiddenWord.length(); i++) {
        if (word.charAt(i) == input) {
          split[i] = String.valueOf(input);
        }
      }
      hiddenWord = "";
      for (String s : split) {
        hiddenWord += s;
      }
    }
  }

  public void checkIfDone() {
    if (word.equals(hiddenWord)) {
      IO.println("You guessed the word!");
    }
  }
}
