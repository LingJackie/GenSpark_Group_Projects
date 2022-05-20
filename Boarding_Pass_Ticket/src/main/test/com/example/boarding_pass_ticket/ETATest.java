package com.example.boarding_pass_ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ETATest {
    ETA testEta;

    @BeforeEach
    void setUp() {
        testEta = new ETA();
    }

    @Test
    void testCalculateEta(){
        assertEquals("22:54",testEta.calculateEta("7 hours, 30 minutes", "15:24"));

        assertEquals("06:30",testEta.calculateEta("7 hours, 30 minutes", "23:00"));
    }
}