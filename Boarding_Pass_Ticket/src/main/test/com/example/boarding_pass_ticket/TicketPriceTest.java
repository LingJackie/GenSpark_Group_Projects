import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class TicketPriceTest {

    TicketPrice ticketPrice;

    @BeforeEach
    void setUp() {
        ticketPrice = new TicketPrice();
    }

    @Test
    void testTicketPriceDiscountForWomen() {
        ticketPrice.setOriginalTicketPrice(100);
        ticketPrice.generateTicketPriceDiscount(20, "female");
        assertEquals(75, ticketPrice.getDiscountedTicketPrice(), "Should return 40.");
    }

    @Test
    void testTicketPriceDiscountForChildren() {
        ticketPrice.setOriginalTicketPrice(100);
        ticketPrice.generateTicketPriceDiscount(10, "male");
        assertEquals(50, ticketPrice.getDiscountedTicketPrice(), "Should return 40.");
    }

    @Test
    void testTicketPriceDiscountForElderly() {
        ticketPrice.setOriginalTicketPrice(100);
        ticketPrice.generateTicketPriceDiscount(65, "female");
        assertEquals(40, ticketPrice.getDiscountedTicketPrice(), "Should return 40.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Completed...");
    }
}

