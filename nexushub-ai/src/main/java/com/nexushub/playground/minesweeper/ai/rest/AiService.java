package com.nexushub.playground.minesweeper.ai.rest;

public interface AiService {
  String getCatHaiku();

  PoetryDto getPoetryByGenreAndTheme(String genre, String theme);

  String getOther();
}
