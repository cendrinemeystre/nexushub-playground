module com.nexushub.playground.ui {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.bootstrapfx.core;
  requires com.almasb.fxgl.all;

  opens com.ibby.lab.minesweeper.ui to javafx.fxml;
  exports com.ibby.lab.minesweeper.ui;
}