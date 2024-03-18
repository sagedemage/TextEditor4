module org.example.texteditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens org.example.texteditor to javafx.fxml;
}