package com.nexushub.playground;

import java.io.IOException;

public class Main {
  static void main(String[] args) throws IOException {
    if (args.length != 1) {
      IO.println("Usage: java -jar playground.jar <fileName>");
    }
    Spliiit spliiit = new Spliiit(args[0]);
    spliiit.readFile();
  }
}
