package org.example.texteditor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.controlsfx.control.Notifications;

public class MainController {
    @FXML
    private TextArea textBox;
    private File openFile = new File("Untitled");

    @FXML
    protected void onOpenTextFileAction() {
        /* An action to open a text file from the file chooser dialog */
        File text_file = MainApplication.showOpenDialog();

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
                MainApplication.setWindowTitle(text_file.getPath());
                this.openFile = text_file;

                Notifications.create().title("Opened File")
                        .text("Opened the text file!")
                        .darkStyle()
                        .threshold(3, Notifications.create().title("Collapsed Notification"))
                        .showInformation();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onSaveTextFileAction() {
        /* An action to save a text file */
        if (this.openFile.getPath().equals("Untitled")) {
            File text_file = MainApplication.showSaveDialog();

            if (text_file != null) {
                String text_content = textBox.getText();
                saveTextFile(text_file, text_content);

                MainApplication.setWindowTitle(text_file.getPath());
                this.openFile = text_file;

                Notifications.create().title("Saved New File")
                        .text("Saved a new text file!")
                        .darkStyle()
                        .threshold(3, Notifications.create().title("Collapsed Notification"))
                        .showInformation();
            }
        } else {
            String text_content = textBox.getText();
            saveTextFile(openFile, text_content);

            Notifications.create().title("Saved File")
                    .text("Saved the text file!")
                    .darkStyle()
                    .threshold(3, Notifications.create().title("Collapsed Notification"))
                    .showInformation();
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