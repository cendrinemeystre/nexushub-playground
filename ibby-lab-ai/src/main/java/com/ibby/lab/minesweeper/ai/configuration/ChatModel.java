package com.ibby.lab.minesweeper.ai.configuration;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Model;

public interface ChatModel extends Model<Prompt, ChatResponse> {
  default String call(String message) {
    return null;
  }

  @Override
  ChatResponse call(Prompt prompt);
}
