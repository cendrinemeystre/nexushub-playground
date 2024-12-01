package com.nexushub.playground.clock;

public class Clock {

  public static void main(String[] args) {
    ClockService clockService = new ClockService(new WatchOutletFormatter(), new PrintService());
    clockService.run();
  }
}
