package com.ibby.lab.minesweeper.ai.configuration;

import org.springframework.ai.chat.model.Generation;

import java.util.List;

public class AiResponse {
  private final List<Generation> generations;

  public AiResponse(List<Generation> generations) {this.generations = generations;}
}
