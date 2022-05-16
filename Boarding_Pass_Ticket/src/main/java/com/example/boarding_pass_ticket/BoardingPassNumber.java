package com.example.boarding_pass_ticket;

import java.util.UUID;

public class BoardingPassNumber {

    public static String boardingPassNumber(String uniqueNumber){
        UUID uniqueBoardingNumber = UUID.randomUUID();
        return uniqueNumber;
    }
}
