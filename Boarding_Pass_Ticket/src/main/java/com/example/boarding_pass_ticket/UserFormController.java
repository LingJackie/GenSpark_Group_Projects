package com.example.boarding_pass_ticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UserFormController {


    @FXML private Text actiontarget;


    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phone_number;
    @FXML private TextField gender;
    @FXML private TextField age;
    @FXML private DatePicker date;
    @FXML private TextField destination;
    @FXML private TextField departure_time;


    public boolean isFieldEmpty(){
        return name.getText().isEmpty() || email.getText().isEmpty() || phone_number.getText().isEmpty() || gender.getText().isEmpty()
                 || age.getText().isEmpty() || date.getValue() == null || destination.getText().isEmpty() ||departure_time.getText().isEmpty();
    }
    public boolean isPhoneNumValid(String phNum){
        return phNum.length()
    }

    // Outputs a response for invalid field inputs
    public void handleBadFieldInputs(){
        if(name.getText().isEmpty())
            name.setPromptText("Missing");

        if(email.getText().isEmpty())
            email.setPromptText("Missing");
        else if(!email.getText().contains("@") || !email.getText().contains(".")){
            email.clear();
            email.setPromptText("Invalid email");
        }

        if(phone_number.getText().isEmpty())
            phone_number.setPromptText("Missing");
        if(gender.getText().isEmpty())
            gender.setPromptText("Missing");
        if(age.getText().isEmpty())
            age.setPromptText("Missing");
//        if(date == null)
//            date.setPromptText("Missing");
        if(destination.getText().isEmpty())
            destination.setPromptText("Missing");
        if(departure_time.getText().isEmpty())
            departure_time.setPromptText("Missing");
    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        handleBadFieldInputs();
        if(isFieldEmpty()){
            actiontarget.setText("Missing information. Please double check.");
            return;
        }

        int phoneNum = Integer.parseInt(phone_number.getText());
        int age = Integer.parseInt(this.age.getText());
        BoardingPass bp = new BoardingPass(name.getText(),email.getText(),phoneNum, gender.getText()
                                            ,age,date.getValue().toString(), destination.getText(),departure_time.getText());

        actiontarget.setText("Info Submitted");
    }
}