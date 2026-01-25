package com.nexushub.playground.app.box;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppBox extends Application {
  private static final String APP_TITLE = "App-Box";

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("app-box.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 575, 500);
    stage.setTitle(APP_TITLE);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    System.out.println("JavaFX Application Starting...");
    launch();
  }
}