package com.nexushub.playground.minesweeper.ai.configuration;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.StreamingModel;
import reactor.core.publisher.Flux;

public interface StreamingChatModel extends StreamingModel<Prompt, ChatResponse> {

  default Flux<String> stream(String message) {
    return null;
  }

  @Override
  Flux<ChatResponse> stream(Prompt prompt);
}
