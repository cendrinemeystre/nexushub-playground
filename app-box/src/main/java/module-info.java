module com.nexushub.playground.app.box {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
  requires jakarta.xml.bind;
  requires annotations;

  opens com.nexushub.playground.minesweeper.app.box.xml.structure to jakarta.xml.bind;
  opens com.nexushub.playground.minesweeper.app.box to javafx.fxml;
  exports com.nexushub.playground.minesweeper.app.box;
}