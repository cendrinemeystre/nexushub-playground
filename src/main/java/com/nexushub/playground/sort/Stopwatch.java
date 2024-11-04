package com.nexushub.playground.sort;

import java.time.Duration;
import java.time.Instant;

public class Stopwatch {
  private Instant start;

  private Instant end;

  public void start() {
    start = Instant.now();
  }

  public void stop() {
    end = Instant.now();
  }

  public long getElapsedTimeMillis() {
    return Duration.between(start, end).toMillis();
  }
}
