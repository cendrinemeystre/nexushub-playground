package com.nexushub.playground.clock.console;

import com.nexushub.playground.clock.common.ClockService;
import com.nexushub.playground.clock.common.PrintService;
import com.nexushub.playground.clock.common.WatchOutletFormatter;

public class ClockConsole {

  public static void main(String[] args) {
    ClockService clockService = new ClockService(new WatchOutletFormatter(), new PrintService());
    clockService.run();
  }
}
