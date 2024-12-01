package com.nexushub.playground.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class ResourceReader {
  private static final String TXT_ENDING = ".txt";

  private ResourceReader() {
  }

  public static List<String> readInput(String fileName) {
    String file = !fileName.contains(".txt") ? fileName + TXT_ENDING : fileName;
    URL resource = ResourceReader.class.getClassLoader().getResource(file);
    if (resource == null) {
      throw new IllegalArgumentException("File not found! " + file);
    } else {
      try (InputStream is = resource.openStream()) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.lines().toList();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return List.of();
  }
}
