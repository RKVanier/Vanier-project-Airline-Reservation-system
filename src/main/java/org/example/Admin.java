package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {
    private int id;

    private static int nextId = 1;

    public Admin() {
        this.id = nextId++;

    }

    public Admin(String name, Gender gender, int id) {
        super(name, gender);
        this.id = nextId++;
    }

    /**
     * Change the status of the booking as only the Admin can do this (Confirmed status)
     * and adds it to the bookings and then calls a method to rewrite the data in a file
     */
    public void book(Booking booking) {

    }

    /**
     * Change the status of the booking as only the Admin can do this (Canceled status)
     * and adds it to the booking and then calls a method to rewrite the data in a file
     */
    public void cancel(Booking booking) {
        booking.cancel();
        booking.getFlight().availableSeats++;
    }

    /**
     * Writes all the bookings in a file to keep records of them by using text IO
     */
    public void generateReport() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return id == admin.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
