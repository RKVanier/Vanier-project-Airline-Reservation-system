import org.example.Booking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    public void bookTest() {
        Booking booking = new Booking();
        booking.book();
        assertEquals(Booking.Status.CONFIRMED, booking.getStatus());
    }

    @Test
    public void cancelTest() {
        Booking booking = new Booking();
        booking.cancel();
        assertEquals(Booking.Status.CANCELLED, booking.getStatus());
    }
}