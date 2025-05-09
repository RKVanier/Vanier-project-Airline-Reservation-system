import org.example.Flight;
import org.example.FlightManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class FlightManagerTest {

    @Test
    public void addFlightTest() {
        FlightManager manager = new FlightManager();
        Flight flight = new Flight() {};
        manager.addFlight(flight);
        assertEquals(1, manager.getFlights().size());
        assertTrue(manager.getFlights().contains(flight));
    }

    @Test
    public void getAvailableFlightsTest() {
        FlightManager manager = new FlightManager();

        Flight flight1 = new Flight() {};
        flight1.setAvailableSeats(5);
        Flight flight2 = new Flight() {};
        flight2.setAvailableSeats(0);

        manager.addFlight(flight1);
        manager.addFlight(flight2);

        List<Flight> result = manager.getAvailableFlights();
        assertEquals(1, result.size());
        assertTrue(result.contains(flight1));
    }
}