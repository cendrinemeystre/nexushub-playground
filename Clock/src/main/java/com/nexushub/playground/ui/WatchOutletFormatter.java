package com.nexushub.playground.ui;


import javafx.scene.text.Text;

import java.time.LocalDateTime;


public class WatchOutletFormatter {
  private static final String FILE_NAME = "watchOutlet.txt";

  private Text[][] WATCH_OUTLET = new Text[10][11];

  private boolean first = true;

  private int minute;

  private int lastMinute;

  public WatchOutletFormatter() {
    convertOutlet();
  }

  public Text[][] showTime() {
    resetWatchOutlet();
    formatWatchOutlet();
    return WATCH_OUTLET;
  }

  private void formatWatchOutlet() {
    LocalDateTime now = LocalDateTime.now();
    minute = now.getMinute();
    if (lastMinute != minute && (minute % 5 == 0 || first)) {
      if (minute % 5 == 0) {
        lastMinute = minute;
      }
      first = false;
      defaultPartBold();
      minuteBold();
      vorOrAb();
      hourBold(now.getHour());
    }
  }

  private void defaultPartBold() {
    multiPartBold(0, 0, 1);
    multiPartBold(0, 3, 6);
    multiPartBold(9, 8, 10);
  }

  private void minuteBold() {
    if (isInTimeRange(5) || isInTimeRange(55)) {
      multiPartBold(0, 8, 10);
    }
    if (isInTimeRange(10) || isInTimeRange(50)) {
      multiPartBold(1, 8, 10);
    }
    if (isInTimeRange(15) || isInTimeRange(45)) {
      multiPartBold(1, 0, 5);
    }
    if (isInTimeRange(20) || isInTimeRange(40)) {
      multiPartBold(2, 0, 5);
    }
    if (isInTimeRange(25) || isInTimeRange(35)) {
      multiPartBold(0, 8, 10);
      multiPartBold(3, 3, 7);
    }
    if (isInTimeRange(30)) {
      multiPartBold(3, 3, 7);
    }
  }

  private void vorOrAb() {
    if (minute == 30) {
      return;
    }
    if (isInTimeRange(25)) {
      multiPartBold(2, 8, 10);
      return;
    }
    if (isInTimeRange(35)) {
      multiPartBold(3, 0, 1);
      return;
    }
    if (minute < 30) {
      multiPartBold(3, 0, 1);
    } else {
      multiPartBold(2, 8, 10);
    }
  }

  private void hourBold(int hour) {
    if (minute == 25 || minute > 35) {
      hour++;
    }
    switch (hour) {
      case 0, 12 -> multiPartBold(9, 0, 5);
      case 1, 13 -> multiPartBold(4, 0, 2);
      case 2, 14 -> multiPartBold(4, 3, 6);
      case 3, 15 -> multiPartBold(4, 8, 10);
      case 4, 16 -> multiPartBold(5, 0, 4);
      case 5, 17 -> multiPartBold(5, 5, 8);
      case 6, 18 -> multiPartBold(6, 0, 5);
      case 7, 19 -> multiPartBold(6, 6, 10);
      case 8, 20 -> multiPartBold(7, 0, 4);
      case 9, 21 -> multiPartBold(7, 5, 8);
      case 10, 22 -> multiPartBold(8, 0, 3);
      case 11, 23 -> multiPartBold(8, 7, 10);
      default -> throw new IllegalStateException("Unexpected value: " + hour);
    }
  }

  private boolean isInTimeRange(int time) {
    return minute >= time && minute <= time + 4;
  }

  private void multiPartBold(int line, int from, int to) {
    for (int i = from; i <= to; i++) {
      bold(line, i);
    }
  }

  private void bold(int i, int j) {
    WATCH_OUTLET[i][j].getStyleClass().add("bold-text");
  }

  private void convertOutlet() {
    String[] outlet = ResourceReader.readInput(FILE_NAME).toArray(new String[10]);
    for (int i = 0; i < outlet.length; i++) {
      String[] line = outlet[i].split("");
      for (int j = 0; j < line.length; j++) {
        Text text = new Text(line[j]);
        text.getStyleClass().add("normal-text");
        WATCH_OUTLET[i][j] = text;
      }
    }
  }

  private void resetWatchOutlet() {
    for (Text[] texts : WATCH_OUTLET) {
      for (Text text : texts) {
        text.getStyleClass().clear();
        text.getStyleClass().add("normal-text");
      }
    }
  }
}
