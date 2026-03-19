package com.ibby.lab.minesweeper.clock.console;

import com.ibby.lab.minesweeper.clock.common.ClockService;
import com.ibby.lab.minesweeper.clock.common.PrintService;
import com.ibby.lab.minesweeper.clock.common.WatchOutletFormatter;

public class ClockConsole {

  public static void main(String[] args) {
    ClockService clockService = new ClockService(new WatchOutletFormatter(), new PrintService());
    clockService.run();
  }
}
