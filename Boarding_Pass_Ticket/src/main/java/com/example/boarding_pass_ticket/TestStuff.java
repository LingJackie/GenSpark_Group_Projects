package com.example.boarding_pass_ticket;



public class TestStuff {
    public static void main(String[] args) throws Exception {
        ETA eta = new ETA();

        System.out.println(eta.calculateEta("7 hours, 30 minutes", "15:24"));
    }
}
