package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookingSystem {
    private static List<Booking> bookings = new ArrayList<>();

    public BookingSystem(List<Booking> bookings) {
        BookingSystem.bookings = bookings;
    }

    public static void addBooking(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Writes all the bookings in a file to keep records of them by using text O
     */
    public static void generateReport() {
        bookings.sort((b1, b2) -> b1.getBookingId() - b2.getBookingId());
        File bookingReport = new File("src/main/resources/BookingReport");
        try (FileWriter fileWriter = new FileWriter(bookingReport)) {
            for (Booking booking : bookings) {
                int bookingId = booking.getBookingId();
                String status = booking.getStatus().toString();
                int adminId = booking.getAdmin().getId();
                String name = booking.getAdmin().getName();
                User.Gender gender = booking.getAdmin().gender;
                int flightId = booking.getFlight().flightId;
                String origin = booking.getFlight().origin;
                String destination = booking.getFlight().destination;
                double price = booking.getFlight().price;
                int numberPassenger = booking.getFlight().getPassengers().size();
                int numberCrew = booking.getFlight().getCrewMembers().size();
                fileWriter.write(bookingId + "," + status + "," + adminId + "," + name + "," + gender + "," + flightId + "," + origin + "," + destination + "," + price + "," + numberPassenger + "," + numberCrew);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookings);
    }

    @Override
    public String toString() {
        return "BookingSystem{" +
                "bookings=" + bookings +
                '}';
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        BookingSystem.bookings = bookings;
    }
}
