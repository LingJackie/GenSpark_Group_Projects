package Boarding_Pass_Ticket.src.main.java;

import java.util.UUID;

public class BoardingPassNumber {

    public static String boardingPassNumber(String uniqueNumber){
        UUID uniqueBoardingNumber = UUID.randomUUID();
        return uniqueNumber;
    }
}
