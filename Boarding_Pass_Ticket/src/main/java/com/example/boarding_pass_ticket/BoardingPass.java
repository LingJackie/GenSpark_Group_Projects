package com.example.boarding_pass_ticket;

import java.text.DateFormat;
import java.time.LocalTime;

public class BoardingPass {
    String boardingPassNum;

//    DateFormat date;
    String date; // DATATYPE SUBJECT TO CHANGE

    String origin;
    String destination;
    String eta; // DATATYPE SUBJECT TO CHANGE

//    LocalTime departureTime;
    String departureTime; // DATATYPE SUBJECT TO CHANGE

    String name;
    String email;
    int phoneNum;
    String gender;
    int age;

    int totalTicketPrice;

    public BoardingPass(String name, String email, int phoneNum, String gender, int age, String date, String destination,String departureTime){
        this.name=name;
        this.email=email;
        this.phoneNum=phoneNum;
        this.gender=gender;
        this.age=age;
        this.date=date;
        this.destination=destination;
        this.departureTime=departureTime;
    }
}
