package com.nexushub.playground.minesweeper.ai.configuration;

import org.springframework.ai.chat.prompt.Prompt;

public interface AiClient {
  default String generate(String message) {
    return null;
  }

  AiResponse generate(Prompt prompt);
}
