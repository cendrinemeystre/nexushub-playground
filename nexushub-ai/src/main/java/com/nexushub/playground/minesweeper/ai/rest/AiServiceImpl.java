package com.nexushub.playground.minesweeper.ai.rest;

import com.nexushub.playground.minesweeper.ai.configuration.AiClient;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {
  public static final String WRITE_ME_HAIKU_ABOUT_CAT = """
    Write me Haiku about cat,
    haiku should start with the word cat obligatory""";

  private final AiClient aiClient;

  public AiServiceImpl(AiClient client) {aiClient = client;}

  @Override
  public String getCatHaiku() {
    return aiClient.generate(WRITE_ME_HAIKU_ABOUT_CAT);
  }

  @Override
  public PoetryDto getPoetryByGenreAndTheme(String genre, String theme) {
    return null;
  }

  @Override
  public String getOther() {
    return aiClient.generate("How are you?");
  }
}