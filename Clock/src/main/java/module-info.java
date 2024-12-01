module com.nexushub.playground.ui {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.bootstrapfx.core;
  requires com.almasb.fxgl.all;

  opens com.nexushub.playground.ui to javafx.fxml;
  exports com.nexushub.playground.ui;
}