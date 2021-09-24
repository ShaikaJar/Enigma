package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class EnigmaDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("EnigmaDisplay.fxml"));
        primaryStage.setTitle("Enigma");

        Scene scene = new Scene(root, 450, 320);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        scene.setOnKeyTyped(EnigmaController.instance::handleKey);
        scene.setOnKeyReleased(EnigmaController.instance::handleRelease);

        primaryStage.show();
    }
}