package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {
    private int id;
    private List<Booking> managedBooking;

    private static int nextId = 1;

    public Admin() {
        super();
        this.id = nextId++;
        this.managedBooking = new ArrayList<>();
    }

    public Admin(String name, Gender gender, int id, List<Booking> managedBooking) {
        super(name, gender);
        this.id = nextId++;
        this.managedBooking = managedBooking;
    }

    /**
     * Change the status of the booking as only the Admin can do this (Confirmed status)
     * and adds it to the bookings and then calls a method to rewrite the data in a file
     */
    public void reviewBooking(Booking booking, Passenger passenger) {

            if (booking != null) {
                if (booking.getFlight().availableSeats > 0) {
                    booking.book();
                    booking.setPassenger(passenger);
                    booking.getFlight().passengers.add(passenger);
                    booking.getFlight().availableSeats--;
                    managedBooking.add(booking);
                    BookingSystem.addBooking(booking);
                    BookingSystem.generateReport();
                }
            }
    }

    /**
     * Change the status of the booking as only the Admin can do this (Canceled status)
     * and adds it to the booking and then calls a method to rewrite the data in a file
     */
    public void reviewCancelling(Booking booking, Passenger passenger) {
        if (booking != null && booking.getFlight() != null && booking.getFlight().passengers.contains(passenger)) {
            booking.cancel();
            booking.getFlight().passengers.remove(passenger);
            booking.getFlight().availableSeats++;
            BookingSystem.generateReport();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return id == admin.id && Objects.equals(managedBooking, admin.managedBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, managedBooking);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", managedBooking=" + managedBooking +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Booking> getManagedBooking() {
        return managedBooking;
    }

    public void setManagedBooking(List<Booking> managedBooking) {
        this.managedBooking = managedBooking;
    }
}
