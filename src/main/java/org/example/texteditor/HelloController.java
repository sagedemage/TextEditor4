package org.example.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea textBox;

    @FXML
    protected void onOpenMenuItemClick() {
        String content = textBox.getText();
        HelloApplication.setWindowTitle(content);
        System.out.println("Opened file");
    }

    @FXML
    protected void onSaveMenuItemClick() {
        System.out.println("Saved file");
    }
}