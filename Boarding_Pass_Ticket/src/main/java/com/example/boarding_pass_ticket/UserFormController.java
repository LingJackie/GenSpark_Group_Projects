package com.example.boarding_pass_ticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UserFormController {
    @FXML
    private Label welcomeText;

    @FXML
    private Text actiontarget;


    @FXML
    private TextField bagel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        String bagelText = bagel.getText();
        actiontarget.setText("Sign in button pressed"+ bagelText);
    }
}