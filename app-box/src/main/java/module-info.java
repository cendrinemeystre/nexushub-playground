module com.nexushub.playground.app.box {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
  requires jakarta.xml.bind;
  requires annotations;

  opens com.ibby.lab.minesweeper.app.box.xml.structure to jakarta.xml.bind;
  opens com.ibby.lab.minesweeper.app.box to javafx.fxml;
  exports com.ibby.lab.minesweeper.app.box;
}