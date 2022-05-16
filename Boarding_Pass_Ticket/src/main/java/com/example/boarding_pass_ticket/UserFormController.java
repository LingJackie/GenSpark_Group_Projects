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


    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phone_number;
    @FXML private TextField gender;
    @FXML private TextField age;
    @FXML private TextField date;
    @FXML private TextField destination;
    @FXML private TextField departure_time;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        int phoneNum = Integer.parseInt(phone_number.getText());
        int age = Integer.parseInt(this.age.getText());
        BoardingPass bp = new BoardingPass(name.getText(),email.getText(),phoneNum, gender.getText()
                                            ,age,date.getText(), destination.getText(),departure_time.getText());

        actiontarget.setText("Sign in button pressed");
    }
}