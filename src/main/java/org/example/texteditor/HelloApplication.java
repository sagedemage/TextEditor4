package org.example.texteditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;

public class HelloApplication extends Application {
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        final int WIDTH = 700;
        final int HEIGHT = 340;

        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        stage.setTitle("Untitled");
        stage.setScene(scene);
        stage.show();
    }

    public static void setWindowTitle(String title) {
        stage.setTitle(title);
    }

    public static File showOpenDialog() {
        /* Opens a file from the file chooser dialog */
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        return selectedFile;
    }

    public static void main(String[] args) {
        launch();
    }
}