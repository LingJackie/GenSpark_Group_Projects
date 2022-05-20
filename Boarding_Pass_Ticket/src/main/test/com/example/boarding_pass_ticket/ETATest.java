import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class ETATest {

    ETA testEta;

    @BeforeEach
    void setUp() {
        testEta = new ETA();
    }

    @Test
    void testCalculateEta(){

        assertEquals("00:54",testEta.calculateEta("7 hours, 30 minutes", "17:24"));
        assertEquals("07:30",testEta.calculateEta("7 hours, 30 minutes", "00:00"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Completed...");
    }
}
