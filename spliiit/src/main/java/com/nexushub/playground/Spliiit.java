package com.nexushub.playground;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Spliiit {
  private final String filename;

  private final Map<String, KeyValue> count = new HashMap();

  private final Set<String> typeSet = new HashSet();

  public Spliiit(String filename) {
    this.filename = filename;
  }

  public void readFile() throws IOException {
    String downloadsDir = System.getProperty("user.home") + File.separator + "Downloads";
    File baseDir = new File(downloadsDir);
    File targetFile = new File(baseDir, filename).getCanonicalFile();

    if (!targetFile.getPath().startsWith(baseDir.getCanonicalPath())) {
      throw new SecurityException("Invalid file path");
    }
    try (FileInputStream fis = new FileInputStream(targetFile); ZipInputStream zipInputStream = new ZipInputStream(fis)) {
      ZipEntry entry;
      while ((entry = zipInputStream.getNextEntry()) != null) {
        if (!entry.isDirectory()) {
          String fileContent = readFileContent(zipInputStream);
          String[] split = fileContent.split("\n");
          mapCountMap(split);
          Total total = calculateTotal(split);
          System.out.printf("Total P: %.2f%n", total.p());
          System.out.printf("Total C: %.2f%n", total.c());
          Diff diff = calculateDiff(total);
          System.out.printf("%s schuldet: %.2f%n", diff.name(), diff.sum());
          System.out.printf("%s%n", "-".repeat(30));
          count.values().forEach(k -> System.out.printf("%s:\tP:%.2f\t|\tC:%.2f%n", k.type(), k.total().p(), k.total().c()));
        }
        zipInputStream.closeEntry();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String readFileContent(ZipInputStream zipInputStream) throws IOException {
    StringWriter stringWriter = new StringWriter();
    char[] buffer = new char[1024];
    int bytesRead;
    InputStreamReader reader = new InputStreamReader(zipInputStream, StandardCharsets.UTF_8);
    while ((bytesRead = reader.read(buffer)) != -1) {
      stringWriter.write(buffer, 0, bytesRead);
    }
    return stringWriter.toString();
  }

  private Total calculateTotal(String[] split) {
    double totalP = 0;
    double totalC = 0;
    for (int i = 4; i < split.length; i++) {
      String substring = split[i].substring(17).trim();
      if (substring.contains("<") || !substring.contains(",")) {
        continue;
      }
      String[] whoAndWhat = substring.split(":");
      String[] sumAndWhat = whoAndWhat[1].split(",");
      double sum = Double.parseDouble(sumAndWhat[0]);
      String who = whoAndWhat[0].toLowerCase();
      updateCountMap(sumAndWhat[1].trim(), who, sum);
      if (who.contains("bear")) {
        totalP += sum;
      } else {
        totalC += sum;
      }
    }
    return new Total(totalP, totalC);
  }

  private void mapCountMap(String[] split) {
    Arrays.stream(split).filter(line -> line.contains("=")).forEach(e -> {
      String trim = e.substring(17).trim().split(":")[1].trim();
      String[] kv = trim.split("=");
      String value = kv[1].trim();
      if (kv[1].contains("<")) {
        value = kv[1].replace(" <Diese Nachricht wurde bearbeitet.>", "");
      }
      count.put(kv[0], new KeyValue(value, new Total()));
      typeSet.add(kv[0].toLowerCase());
    });
  }

  private void updateCountMap(String key, String who, double sum) {
    if (count.containsKey(key)) {
      count.put(key, updateKeyValue(count.get(key), who, sum));
    }
    if (typeSet.contains(key.toLowerCase())) {
      count.entrySet()
        .stream()
        .filter(e -> e.getValue().type().equals(key))
        .map(Map.Entry::getKey)
        .findFirst().ifPresent(foundKey -> count.put(foundKey, updateKeyValue(count.get(foundKey), who, sum)));
    }
  }

  private Diff calculateDiff(Total total) {
    double diff;
    String name;
    if (total.p() > total.c()) {
      diff = (total.p() - total.c()) / 2;
      name = "Cendrine";
    } else {
      diff = (total.c() - total.p()) / 2;
      name = "Patrick";
    }
    return new Diff(diff, name);
  }

  private KeyValue updateKeyValue(KeyValue value, String who, double sum) {
    double p = value.total().p();
    double c = value.total().c();
    if (who.contains("bear")) {
      p += sum;
    } else {
      c += sum;
    }
    return new KeyValue(value.type(), new Total(p, c));
  }
}

record Total(double p, double c) {
  public Total() {
    this(0, 0);
  }
}

record Diff(double sum, String name) {
}

record KeyValue(String type, Total total) {
}