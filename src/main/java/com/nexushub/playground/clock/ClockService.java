package com.nexushub.playground.clock;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockService {
  private final WatchOutletFormatter watchOutletFormatter;

  private final PrintService printService;

  public ClockService(WatchOutletFormatter watchOutletFormatter, PrintService printService) {
    this.watchOutletFormatter = watchOutletFormatter;
    this.printService = printService;
  }

  public void run() {
    formatAndPrintTime();
    scheduleTaskWithInitalDelay();
  }

  private void formatAndPrintTime() {
    String[][] time = watchOutletFormatter.showTime();
    printService.print(time);
  }

  private void scheduleTaskWithInitalDelay() {
    try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1)) {

      Runnable task = this::formatAndPrintTime;

      LocalDateTime now = LocalDateTime.now();
      int fiveMinutesInSeconds = 300;
      int secondsUntilNext5Minute = fiveMinutesInSeconds - (now.getMinute() % 5) * 60 - now.getSecond();

      scheduler.scheduleAtFixedRate(task, secondsUntilNext5Minute, fiveMinutesInSeconds, TimeUnit.SECONDS);
    }
  }
}
