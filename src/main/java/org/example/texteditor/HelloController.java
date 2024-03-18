package org.example.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextArea textBox;
    private File openFile = new File("Untitled");

    @FXML
    protected void onOpenTextFileAction() {
        /* An action to open a text file from the file chooser dialog */
        File text_file = HelloApplication.showOpenDialog();

        if (text_file != null) {
            try {
                /* Read the text file to get the content
                and display it on the text area called textBox */
                Scanner myReader = new Scanner(text_file);

                String text_content = "";

                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    line = line.concat("\n");
                    text_content = text_content.concat(line);
                }

                myReader.close();

                textBox.setText(text_content);
                HelloApplication.setWindowTitle(text_file.getPath());
                this.openFile = text_file;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onSaveTextFileAction() {
        /* An action to save a text file */
        if (this.openFile.getPath().equals("Untitled")) {
            File text_file = HelloApplication.showSaveDialog();

            if (text_file != null) {
                String text_content = textBox.getText();
                saveTextFile(text_file, text_content);

                HelloApplication.setWindowTitle(text_file.getPath());
                this.openFile = text_file;
            }
        } else {
            String text_content = textBox.getText();
            saveTextFile(openFile, text_content);
        }
    }

    private void saveTextFile(File file, String text_content) {
        /* File operation to save a text file */
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(text_content);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}