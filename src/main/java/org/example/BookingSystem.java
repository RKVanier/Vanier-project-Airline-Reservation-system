package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookingSystem {
    private List<Booking> bookings;

    public BookingSystem() {
        this.bookings = new ArrayList<>();
    }

    public BookingSystem(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookingSystem that = (BookingSystem) o;
        return Objects.equals(bookings, that.bookings);
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
        this.bookings = bookings;
    }
}
