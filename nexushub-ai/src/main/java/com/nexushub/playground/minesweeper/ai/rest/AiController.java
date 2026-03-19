package com.nexushub.playground.minesweeper.ai.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ai")
public class AiController {
  private final AiService aiService;

  public AiController(AiService service) {aiService = service;}

  @GetMapping("/cat")
  public String getCatHaiku() {
    return aiService.getCatHaiku();
  }

  @GetMapping("/other")
  public String getOther() {
    return aiService.getOther();
  }
}
