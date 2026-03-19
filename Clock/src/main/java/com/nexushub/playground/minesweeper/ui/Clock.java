package com.nexushub.playground.minesweeper.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Clock extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("watch-outlet.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    stage.setTitle("Watch Outlet");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}