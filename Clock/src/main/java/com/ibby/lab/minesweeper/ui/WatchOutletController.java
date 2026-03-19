package com.ibby.lab.minesweeper.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class WatchOutletController {
  @FXML
  private TextFlow textFlow;

  private WatchOutletFormatter watchOutletFormatter = new WatchOutletFormatter();

  public void initialize() {
    updateTextFlow();
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
      LocalDateTime now = LocalDateTime.now();
      int minute = now.getMinute();

      if (minute % 5 == 0 && now.getSecond() == 0) {
        updateTextFlow();
      }
    }));

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }

  private void updateTextFlow() {
    textFlow.getChildren().clear();
    Text[][] showTimeArr = watchOutletFormatter.showTime();
    List<List<Text>> list = Arrays.stream(showTimeArr).toList().stream().map(e -> Arrays.stream(e).toList()).toList();

    list.forEach(line -> {
      ObservableList<Node> children = textFlow.getChildren();
      children.addAll(line);
      children.add(new Text("\n"));
    });
  }
}
