package org.example;

import java.util.Objects;

public class Booking implements Bookable{
    private int bookingId;
    private Flight flight;
    private Status status;

    private static int nextId = 1;

    public Booking() {
        this.bookingId = nextId++;
        this.flight = null;
        this.status = Status.PROCESSING;
    }

    public Booking(Flight flight, Status status) {
        this.bookingId = nextId++;
        this.flight = flight;
        this.status = status;
    }

    /**
     * A method to change the status of a booking to "CONFIRMED" which only an admin do
     */
    @Override
    public void book() {
        this.status = Status.CONFIRMED;
    }

    /**
     * A method to change the status of a booking to "CANCELLED" which only an admin do
     */
    @Override
    public void cancel() {
        this.status = Status.CANCELLED;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && Objects.equals(flight, booking.flight) && status == booking.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flight, status);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flight=" + flight +
                ", status=" + status +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public enum Status {
        CONFIRMED, PROCESSING, CANCELLED
    }
}
