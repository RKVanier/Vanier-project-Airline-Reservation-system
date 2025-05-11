import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {
    private Passenger passenger;
    private Flight flight;
    private Admin admin;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger("John Doe", User.Gender.MALE, 12345, "USA", true, new ArrayList<>());
        admin = new Admin();
        flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Paris", "London", 250.0, 10, new ArrayList<>(), new ArrayList<>(), true);
    }

    @Test
    public void testRequestBooking() {
        passenger.requestBooking(flight, admin);
        assertEquals(1, passenger.getBookedFlights().size());
        assertNotNull(passenger.getBookedFlights().get(0).getFlight());
        assertEquals(flight, passenger.getBookedFlights().get(0).getFlight());
    }

    @Test
    public void testRequestCancel() {
        passenger.requestBooking(flight, admin);
        Booking booking = passenger.getBookedFlights().get(0);
        passenger.requestCancel(booking);
        assertEquals(0, passenger.getBookedFlights().size());
    }
}