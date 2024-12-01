package com.nexushub.playground.clock;

public enum LetterFormat {
  BOLD_ON("\033[0;1m"),
  BOLD_OFF("\033[0;0m");

  private final String format;

  LetterFormat(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }
}
