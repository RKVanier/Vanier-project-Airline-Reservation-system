import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTest {

    @BeforeEach
    public void setUp() {
        new BookingSystem(new ArrayList<>());
    }

    @Test
    public void testAddBooking() {
        List<Passenger> passengers = new ArrayList<>();
        List<CrewMember> crew = new ArrayList<>();
        Admin admin = new Admin();
        Flight flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Paris", "London", 250.0, 10, passengers, crew, true);
        Booking booking = new Booking();
        booking.setAdmin(admin);
        booking.setFlight(flight);
        BookingSystem.addBooking(booking);
        assertTrue(BookingSystem.getBookings().contains(booking));
    }

    @Test
    public void testGenerateReportCreatesFile() throws Exception {
        Passenger passenger = new Passenger("Jane Doe", User.Gender.FEMALE, 123456, "British", true, new ArrayList<>());
        Admin admin = new Admin();
        List<Passenger> passengers = new ArrayList<>();
        List<CrewMember> crew = new ArrayList<>();
        Flight flight = new InternationalFlight(LocalDateTime.now(), LocalDateTime.now().plusHours(3), "Rome", "Berlin", 300.0, 5, passengers, crew, true);
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setAdmin(admin);
        booking.book();
        BookingSystem.addBooking(booking);
        BookingSystem.generateReport();
        File reportFile = new File("src/main/resources/BookingReport");
        assertTrue(reportFile.exists());
        String content = new String(Files.readAllBytes(Paths.get("src/main/resources/BookingReport")));
        assertTrue(content.contains("Jane Doe"));
        assertTrue(content.contains("CONFIRMED"));
    }
}