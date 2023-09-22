package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static java.lang.Thread.sleep;

public class HelloController {
    @FXML
    private Label welcomeText, goodbye;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        goodbye.setText("");
    }

    @FXML
    protected void onGoodByeButtonClick(){
        goodbye.setText("Goodbye");
        welcomeText.setText("");

        new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(Platform::exit);
        }).start();
    }
}