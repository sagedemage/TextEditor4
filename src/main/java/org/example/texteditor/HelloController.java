package org.example.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextArea textBox;

    @FXML
    protected void onOpenTextFile() {
        /* Opens a text file from the file chooser dialog */
        File text_file = HelloApplication.showOpenDialog();

        try {
            /* Read the text file to get the content
            and display it on the text area called textBox */
            Scanner myReader = new Scanner(text_file);

            String text_content = "";

            while(myReader.hasNextLine()) {
                String line = myReader.nextLine();
                line = line.concat("\n");
                text_content = text_content.concat(line);
            }

            textBox.setText(text_content);
            HelloApplication.setWindowTitle(text_file.getPath());
            System.out.println(text_file.getAbsolutePath());
            System.out.println("Opened file");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSaveMenuItemClick() {
        System.out.println("Saved file");
    }
}