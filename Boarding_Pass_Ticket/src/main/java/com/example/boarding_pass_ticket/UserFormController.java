package com.example.boarding_pass_ticket;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserFormController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}