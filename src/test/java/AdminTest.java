

import org.example.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    public void testReviewBooking_confirmsBooking() {
        Admin admin = new Admin();
        Passenger passenger = new Passenger("John Doe", User.Gender.MALE, 123456, "Canadian", true, new ArrayList<>());
        List<Passenger> passengers = new ArrayList<>();
        List<CrewMember> crew = new ArrayList<>();
        InternationalFlight flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Toronto", "Paris", 500.0, 5, passengers, crew, true);
        Booking booking = new Booking();
        booking.setAdmin(admin);
        booking.setFlight(flight);
        admin.reviewBooking(booking, passenger);
        assertEquals(4, flight.getAvailableSeats());
        assertTrue(flight.getPassengers().contains(passenger));
        assertEquals(passenger, booking.getPassenger());
        assertTrue(admin.getManagedBooking().contains(booking));
    }

    @Test
    public void testReviewBooking_doesNothingIfNoSeats() {
        Admin admin = new Admin();
        Passenger passenger = new Passenger("Alice", User.Gender.FEMALE, 654321, "French", true, new ArrayList<>());
        List<Passenger> passengers = new ArrayList<>();
        List<CrewMember> crew = new ArrayList<>();
        InternationalFlight flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(3), "Berlin", "London", 300.0, 0, passengers, crew, false);
        Booking booking = new Booking();
        booking.setAdmin(admin);
        booking.setFlight(flight);
        admin.reviewBooking(booking, passenger);
        assertEquals(0, flight.getAvailableSeats());
        assertFalse(flight.getPassengers().contains(passenger));
        assertNull(booking.getPassenger());
        assertFalse(admin.getManagedBooking().contains(booking));
    }

    @Test
    public void testReviewCancelling_removesPassengerAndIncreasesSeats() {
        Admin admin = new Admin();
        Passenger passenger = new Passenger("David", User.Gender.MALE, 111222, "USA", true, new ArrayList<>());
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passenger);
        List<CrewMember> crew = new ArrayList<>();
        InternationalFlight flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "NYC", "Tokyo", 1200.0, 2, passengers, crew, true);
        Booking booking = new Booking();
        booking.setAdmin(admin);
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        admin.reviewCancelling(booking, passenger);
        assertFalse(flight.getPassengers().contains(passenger));
        assertEquals(3, flight.getAvailableSeats());
    }
}