module org.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires org.controlsfx.controls;

    opens org.example.texteditor to javafx.fxml;
}