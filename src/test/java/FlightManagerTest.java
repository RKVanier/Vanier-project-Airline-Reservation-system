import org.example.Flight;
import org.example.FlightManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FlightManagerTest {

    @BeforeEach
    public void setUp() {
        FlightManager.getFlights().clear();
    }

    @Test
    public void addFlightTest() {

        Flight flight = new Flight() {};
        FlightManager.addFlight(flight);
        assertEquals(1, FlightManager.getFlights().size());
        assertTrue(FlightManager.getFlights().contains(flight));
    }

    @Test
    public void getAvailableFlightsTest() {
        Flight flight1 = new Flight() {};
        flight1.setAvailableSeats(5);
        Flight flight2 = new Flight() {};
        flight2.setAvailableSeats(0);

        FlightManager.addFlight(flight1);
        FlightManager.addFlight(flight2);

        List<Flight> result = FlightManager.getAvailableFlights();
        assertEquals(1, result.size());
        assertTrue(result.contains(flight1));
    }
}