import org.example.Flight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class FlightComparatorTest {

    @Test
    public void compareByPriceTest() {
        Flight f1 = new Flight() {};
        f1.setPrice(150.0);
        Flight f2 = new Flight() {};
        f2.setPrice(250.0);

        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.PRICE);
        assertTrue(comparator.compare(f1, f2) < 0);
    }

    @Test
    public void compareByDestinationTest() {
        Flight f1 = new Flight() {};
        f1.setDestination("New York");
        Flight f2 = new Flight() {};
        f2.setDestination("Amsterdam");

        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.DESTINATION);
        assertTrue(comparator.compare(f1, f2) > 0);
    }

    @Test
    public void compareByDepartureTimeTest() {
        Flight f1 = new Flight() {};
        f1.setDepartureDateTime(LocalDateTime.of(2025, 5, 1, 10, 0));
        Flight f2 = new Flight() {};
        f2.setDepartureDateTime(LocalDateTime.of(2025, 5, 1, 12, 0));

        Flight.FlightComparator comparator = new Flight.FlightComparator(Flight.FlightSortCriteria.DEPARTURETIME);
        assertTrue(comparator.compare(f1, f2) < 0);
    }
}
