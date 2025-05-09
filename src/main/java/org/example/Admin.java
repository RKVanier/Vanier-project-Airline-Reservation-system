package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void book(Booking booking, Passenger passenger) {
        if (booking.getFlight().availableSeats > 0) {
            booking.book();
            booking.getFlight().passengers.add(passenger);
            booking.getFlight().availableSeats--;
            managedBooking.add(booking);
            generateReport();
        } else {
            System.out.println("No more available seats. Try to book another flight.");
        }
    }

    /**
     * Change the status of the booking as only the Admin can do this (Canceled status)
     * and adds it to the booking and then calls a method to rewrite the data in a file
     */
    public void cancel(Booking booking, Passenger passenger) {
        booking.cancel();
        booking.getFlight().passengers.remove(passenger);
        booking.getFlight().availableSeats++;
        generateReport();
    }

    /**
     * Writes all the bookings in a file to keep records of them by using text O
     */
    public void generateReport() {
        managedBooking.sort((b1, b2) -> b1.getBookingId() - b2.getBookingId());
        File bookingReport = new File("src/main/resources/BookingReport");
        try (FileWriter fileWriter = new FileWriter(bookingReport)) {
            for (Booking booking : managedBooking) {
                int bookingId = booking.getBookingId();
                String status = booking.getStatus().toString();
                int adminId = this.id;
                String name = this.name;
                Gender gender = this.gender;
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
