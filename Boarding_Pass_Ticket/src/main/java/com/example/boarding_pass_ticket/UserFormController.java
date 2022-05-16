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

    public boolean isFieldEmpty(){
        return name.getText().isEmpty() || email.getText().isEmpty() || phone_number.getText().isEmpty() || gender.getText().isEmpty()
                 || age.getText().isEmpty() || date.getText().isEmpty() || destination.getText().isEmpty() ||departure_time.getText().isEmpty();
            

    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        if(isFieldEmpty()){
            actiontarget.setText("Missing information. Please check again.");
            return;
        }

        int phoneNum = Integer.parseInt(phone_number.getText());
        int age = Integer.parseInt(this.age.getText());
        BoardingPass bp = new BoardingPass(name.getText(),email.getText(),phoneNum, gender.getText()
                                            ,age,date.getText(), destination.getText(),departure_time.getText());

        actiontarget.setText("Info Submitted");
    }
}