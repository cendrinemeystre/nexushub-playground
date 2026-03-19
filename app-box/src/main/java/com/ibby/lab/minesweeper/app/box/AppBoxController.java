package com.ibby.lab.minesweeper.app.box;

import com.ibby.lab.minesweeper.app.box.xml.XmlReader;
import com.ibby.lab.minesweeper.app.box.xml.structure.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AppBoxController {
  @FXML
  private TextFlow textFlow;

  @FXML
  private Button yesButton;

  @FXML
  private Button noButton;

  private XmlReader xmlReader;

  private Application application;

  private int next;

  public AppBoxController() {
    this.xmlReader = new XmlReader();
    application = xmlReader.unmarshal("valentinstag");
    next = 0;
  }

  public void initialize() {
    Font font = new Font(30);
    yesButton.setText("Yes");
    yesButton.setFont(font);
    noButton.setText("No");
    noButton.setFont(font);
    Text e = new Text(getNextText());
    e.setFont(font);
    textFlow.getChildren().add(e);
    noButton.setOnAction(event -> {
      if (next < application.getTextList().size() - 1) {
        next++;
        textFlow.getChildren().clear();
        Text e1 = new Text(getNextText());
        e1.setFont(font);
        textFlow.getChildren().add(e1);
      } else {
        noButton.setDisable(true);
      }
    });
    yesButton.setOnAction(event -> {
      textFlow.getChildren().clear();
      Text e1 = new Text(application.getEndText());
      e1.setFont(font);
      textFlow.getChildren().add(e1);
      noButton.setVisible(false);
      yesButton.setVisible(false);
    });
  }

  private String getNextText() {
    return application.getTextList().stream() //
      .filter(e -> e.getId() == next) //
      .findFirst() //
      .orElseThrow() //
      .getContent();
  }
}
