package UI;

import Logic.Enigma;
import Logic.Rolle;
import Logic.Rollwerk;
import Logic.SteckBrett;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;

public class EnigmaInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("EnigmaInterface.fxml"));
        primaryStage.setTitle("Enigma");

        Scene scene = new Scene(root, 450, 320);
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);

        scene.setOnKeyTyped(EnigmaController.instance::handleKey);
        scene.setOnKeyReleased(EnigmaController.instance::handleRelease);

        primaryStage.show();
    }
}
