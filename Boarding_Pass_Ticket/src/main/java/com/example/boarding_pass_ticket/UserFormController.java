package com.example.boarding_pass_ticket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class UserFormController {

    @FXML private Text actiontarget;

    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phone_number;
    @FXML private TextField gender;
    @FXML private TextField age;
    @FXML private DatePicker date;
    @FXML private AutocompleteTextField origin;
    @FXML private AutocompleteTextField destination;
    @FXML private TextField departure_time;

    /**
     * Checks if the user left a field empty
     */
    public boolean isFieldsEmpty(){
        return name.getText().isEmpty() || email.getText().isEmpty() || phone_number.getText().isEmpty() || gender.getText().isEmpty()
                 || age.getText().isEmpty() || date.getValue() == null || destination.getText().isEmpty() ||departure_time.getText().isEmpty();
    }

    /**
     * Displays a "Missing" message for each field that a user leaves empty
     * @return true if any of the fields are empty, false otherwise
     */
    public boolean checkEmptyFields(){
        if(isFieldsEmpty())
            actiontarget.setText("Missing information. Please double check.");
        else
            return false;
        if(name.getText().isEmpty())
            name.setPromptText("Missing");
        if(email.getText().isEmpty())
            email.setPromptText("Missing");
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
        return true;
    }

    /**
     * Checks if the phone number is the correct length
     * @param phNum String containing a phone number
     */
    public boolean isPhoneNumValid(String phNum){
        return phNum.length() >= 10 && phNum.length() <= 15;
    }

    /**
     * Checks if the email is correct and contains an "@" and a website
     * @param email String containing a phone number
     */
    public boolean isEmailValid(String email){
        return email.contains("@") && email.contains(".");
    }


    /**
     * Brings it all together and displays a message if any input is invalid
     */
    public boolean handleInvalidInputs(){
        boolean inputsInvalid = false;
        if(checkEmptyFields()) inputsInvalid = true;
        if(!isPhoneNumValid(phone_number.getText())){
            phone_number.clear();
            phone_number.setPromptText("Invalid phone number");
            inputsInvalid = true;
        }
        if(!isEmailValid(email.getText())){
            email.clear();
            email.setPromptText("Invalid email");
            inputsInvalid = true;
        }


        return inputsInvalid;
    }

    /**
     * Creates a new BoardingPass object when the submit button is clicked
     */
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        if(handleInvalidInputs()) return;// Ends the method prematurely if the inputs are invalid

        int phoneNum = Integer.parseInt(phone_number.getText());
        int age = Integer.parseInt(this.age.getText());
        BoardingPass bp = new BoardingPass(name.getText(),email.getText(),phoneNum, gender.getText()
                                            ,age,date.getValue().toString(), destination.getText(),departure_time.getText());

        actiontarget.setText("Info Submitted");
    }
}