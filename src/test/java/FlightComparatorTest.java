import org.example.Flight;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightComparatorTest {

    @Test
    public void compareByPrice() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setPrice(100);
        f2.setPrice(200);
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.PRICE);
        assertTrue(comparator.compare(f1, f2) < 0);
    }

    @Test
    public void compareByDestination() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setDestination("Zurich");
        f2.setDestination("Berlin");
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.DESTINATION);
        assertTrue(comparator.compare(f1, f2) > 0);
    }

    @Test
    public void compareByDepartureTime() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setDepartureDateTime(LocalDateTime.of(2025, 5, 1, 10, 0));
        f2.setDepartureDateTime(LocalDateTime.of(2025, 5, 1, 12, 0));
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.DEPARTURETIME);
        assertTrue(comparator.compare(f1, f2) < 0);
    }

    @Test
    public void compareByFlightId() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setFlightId(1);
        f2.setFlightId(2);
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.FLIGHTID);
        assertTrue(comparator.compare(f1, f2) < 0);
    }

    @Test
    public void compareByOrigin() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setOrigin("Zurich");
        f2.setOrigin("Berlin");
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.ORIGIN);
        assertTrue(comparator.compare(f1, f2) > 0);
    }

    @Test
    public void compareByAvailableSeats() {
        Flight f1 = new Flight() {};
        Flight f2 = new Flight() {};
        f1.setAvailableSeats(10);
        f2.setAvailableSeats(20);
        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.AVAILABLESEATS);
        assertTrue(comparator.compare(f1, f2) < 0);
    }
}